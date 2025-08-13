package com.tatatrent.wms.db.repos.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tatatrent.wms.db.config.JdbcDataSource;
import com.tatatrent.wms.db.repos.WmsRepository;
import com.tatatrent.wms.ui.rest.dto.ShipmentOrderDetailDTO;
import com.tatatrent.wms.ui.rest.dto.ShipmentOrderHeaderDTO;
import com.tatatrent.wms.util.AppConstants;

@Repository
public class WmsRepositoryImpl implements WmsRepository{
	
	final Logger logger = LoggerFactory.getLogger(WmsRepositoryImpl.class);
	
	@Autowired
	private JdbcDataSource jdbcSource;
	
	@Override
	public Optional<String> getTransid() {
		logger.info("Inside getTransId()");
		String transid = null;
		try (Connection con = jdbcSource.dataSource().getConnection();
				PreparedStatement stmt = con.prepareStatement(AppConstants.TRANS_SQL);) {
			ResultSet rset = stmt.executeQuery();
			while (rset.next()) {
				transid = rset.getString("transid");
			}
			rset.close();
		} catch (Exception e) {
			logger.error("Exception occured: while obtaining transid in GenericDao.getTransid() method");
		}
		logger.info("returning from getTransId()");
		return Optional.ofNullable(transid);
	}

	@Override
	public Optional<Boolean> saveOrderToDb(ShipmentOrderHeaderDTO dto) {
		logger.info("saveOrderToDb().. ");
		try (Connection conn = jdbcSource.dataSource().getConnection()) {
			conn.setAutoCommit(false);
			insertDetailData(conn, dto.getShipmentOrderDetailDto());
			insertHeadData(conn, dto);
	        conn.commit();
	        String successMsg = "Data inserted successfully.";
	        logger.info(successMsg);
			return Optional.of(Boolean.TRUE);
		} catch (Exception e) {
	        logger.error("Error inserting data {}" +e);
	        handleException(e, dto.getExternOrderKey());
	        return Optional.of(Boolean.FALSE);
	    }
	}

	private void insertDetailData(Connection conn, List<ShipmentOrderDetailDTO> shipmentOrderDetailDtoList) {
		logger.info("Inside insertDetailData ()");
		try (PreparedStatement psDet = conn.prepareStatement(AppConstants.INSERT_DETAIL_SQL)) {
	        for (ShipmentOrderDetailDTO shipmentOrderDetailDto : shipmentOrderDetailDtoList) {
	        	psDet.setString(1, shipmentOrderDetailDto.getTransid());
		        psDet.setString(2, shipmentOrderDetailDto.getOrderKey());
		        psDet.setString(3, shipmentOrderDetailDto.getExternOrderKey());
		        psDet.setString(4, shipmentOrderDetailDto.getExternLineNo());
		        psDet.setString(5, shipmentOrderDetailDto.getStorerKey());
		        psDet.setString(6, shipmentOrderDetailDto.getSku());
		        psDet.setDouble(7, getDoubleValue(shipmentOrderDetailDto.getOpenQty()));
		        psDet.setString(8, shipmentOrderDetailDto.getSusr1());
		        psDet.setString(9, shipmentOrderDetailDto.getSusr2());
		        psDet.setString(10, shipmentOrderDetailDto.getSusr3());
		        psDet.setString(11, shipmentOrderDetailDto.getSusr4());
		        psDet.setString(12, shipmentOrderDetailDto.getSusr5());
		        psDet.setString(13, shipmentOrderDetailDto.getLottable06());
		        psDet.setString(14, shipmentOrderDetailDto.getLottable07());
		        psDet.setString(15, shipmentOrderDetailDto.getLottable08());
		        psDet.setString(16, shipmentOrderDetailDto.getPlant());
		        psDet.setString(17, shipmentOrderDetailDto.getSloc());
	            psDet.addBatch();
	        }
	        psDet.executeBatch();
	    } catch (SQLException e) {
	    	logger.error("Failed to insert detail data() :: {}", e);
			e.printStackTrace();
		}
	}

	private Double getDoubleValue(String openQty) {
		return Double.valueOf(openQty);
	}

	private void insertHeadData(Connection conn, ShipmentOrderHeaderDTO dto) {
		logger.info("Inside insertHeadData ()");
		try (PreparedStatement psHead = conn.prepareStatement(AppConstants.INSERT_HEADER_SQL)) {
	        psHead.setString(1, dto.getTransid());
	        psHead.setString(2, dto.getrSystemId());
	        psHead.setString(3, dto.getOrderKey());
	        psHead.setString(4, dto.getExternOrderKey());
	        psHead.setString(5, dto.getStorerKey());
	        psHead.setDate(6, AppConstants.convertToSQLDate(dto.getOrderDate()));
	        psHead.setDate(7, AppConstants.convertToSQLDate(dto.getDeliveryDate()));
	        psHead.setDate(8, AppConstants.convertToSQLDate(dto.getRequestedShipDate()));
	        psHead.setString(9, dto.getPriority());
	        psHead.setString(10, dto.getType());
	        psHead.setString(11, dto.getConsigneeKey());
	        psHead.setString(12, dto.getBuyerPO());
	        psHead.setString(13, dto.getSusr1());
	        psHead.setString(14, dto.getSusr2());
	        psHead.setString(15, dto.getSusr3());
	        psHead.setString(16, dto.getSusr4());
	        psHead.setString(17, dto.getSusr5());
	        psHead.executeUpdate();
	    } catch (SQLException e) {
	    	logger.error("Failed to insert head data() :: {}", e);
			e.printStackTrace();
		}
	}

	private void handleException(Exception e, String orderKey) {
		 // Attempt to rollback if possible
	    try (Connection conn = jdbcSource.dataSource().getConnection()) {
	        conn.rollback();
	        logger.warn("Transaction rolled back for order :: {}", orderKey);
	    } catch (SQLException rollbackEx) {
	        logger.error("Failed to rollback transaction order :: {}", orderKey);
	    }
		
	}

}
