package com.tatatrent.wms.services.impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tatatrent.wms.db.repos.WmsRepository;
import com.tatatrent.wms.services.ShipmentService;
import com.tatatrent.wms.ui.rest.dto.ShipmentOrder;
import com.tatatrent.wms.ui.rest.dto.ShipmentOrderDetailDTO;
import com.tatatrent.wms.ui.rest.dto.ShipmentOrderHeaderDTO;
import com.tatatrent.wms.util.AppConstants;

@Service
public class ShipmentServiceImpl implements ShipmentService {
	
	private static final Logger logger = LoggerFactory.getLogger(ShipmentServiceImpl.class);
	
	@Autowired
	private WmsRepository wmsRepository;

	@Override
	public boolean processOrder(ShipmentOrder orders) {
		logger.info("Inside saveOrderToDb");
		String transid = generateTransId();
		if (transid != null && transid.trim().length() > 0) {
			ShipmentOrderHeaderDTO dto = generateTheCompleteDTo(orders, transid);
			logger.info("received ShipmentOrderHeaderDTO :: \n {}", dto);
			Optional<Boolean> saveOrderToDb = wmsRepository.saveOrderToDb(dto);
			if (saveOrderToDb.isPresent()) {
				return saveOrderToDb.get();
			}
		}
		return false;
	}

	private ShipmentOrderHeaderDTO generateTheCompleteDTo(ShipmentOrder orders, String transid) {
		ShipmentOrderHeaderDTO headerDto = new ShipmentOrderHeaderDTO();
		headerDto.setTransid(transid);
		headerDto.setOrderKey(orders.getShipmentOrderHeader().getOrderKey());
		headerDto.setExternOrderKey(orders.getShipmentOrderHeader().getExternOrderKey());
		headerDto.setOrderDate(orders.getShipmentOrderHeader().getOrderDate());
		headerDto.setDeliveryDate(orders.getShipmentOrderHeader().getDeliveryDate());
		headerDto.setRequestedShipDate(orders.getShipmentOrderHeader().getRequestedShipDate());
		headerDto.setStorerKey(orders.getShipmentOrderHeader().getStorerKey());
		headerDto.setrSystemId(orders.getShipmentOrderHeader().getRSystemId());
		headerDto.setPriority(orders.getShipmentOrderHeader().getPriority());
		headerDto.setType(orders.getShipmentOrderHeader().getType());
		headerDto.setConsigneeKey(orders.getShipmentOrderHeader().getConsigneeKey());
		headerDto.setBuyerPO(orders.getShipmentOrderHeader().getBuyerPO());
		headerDto.setSusr1(orders.getShipmentOrderHeader().getSusr1());
		headerDto.setSusr2(orders.getShipmentOrderHeader().getSusr2());
		headerDto.setSusr3(orders.getShipmentOrderHeader().getSusr3());
		headerDto.setSusr4(orders.getShipmentOrderHeader().getSusr4());
		headerDto.setSusr5(orders.getShipmentOrderHeader().getSusr5());
		headerDto.setShipmentOrderDetailDto(getOrderDeatils(orders, transid));
		return headerDto;
	}

	private List<ShipmentOrderDetailDTO> getOrderDeatils(ShipmentOrder orders, String transid) {
		List<ShipmentOrderDetailDTO> detailDtoList = orders.getShipmentOrderHeader().getShipmentOrderDetail().stream().map(osd -> {
			ShipmentOrderDetailDTO detailDto = new ShipmentOrderDetailDTO();
			detailDto.setTransid(transid);
			detailDto.setOrderKey(AppConstants.checkValues(orders.getShipmentOrderHeader().getOrderKey(), osd.getOrderKey()));
			detailDto.setExternOrderKey(AppConstants.checkValues(orders.getShipmentOrderHeader().getExternOrderKey(), osd.getExternOrderKey()));
			detailDto.setOrderKey(AppConstants.checkValues(orders.getShipmentOrderHeader().getExternOrderKey(), osd.getExternOrderKey()));
			detailDto.setExternLineNo(osd.getExternLineNo());
			detailDto.setStorerKey(AppConstants.checkValues(orders.getShipmentOrderHeader().getStorerKey(), osd.getStorerKey()));
			detailDto.setSku(osd.getSku());
			detailDto.setOpenQty(osd.getOpenQty());
			detailDto.setSusr1(osd.getSusr1());
			detailDto.setSusr2(osd.getSusr2());
			detailDto.setSusr3(osd.getSusr3());
			detailDto.setSusr4(osd.getSusr4());
			detailDto.setSusr5(osd.getSusr5());
			detailDto.setLottable06(osd.getLottable06());
			detailDto.setLottable07(osd.getLottable07());
			detailDto.setLottable08(osd.getLottable08());
			detailDto.setPlant(osd.getPlant());
			detailDto.setSloc(osd.getSloc());
			return detailDto;
		}).collect(Collectors.toList());
		return detailDtoList;
	}

	

	private String generateTransId() {
		return wmsRepository.getTransid().orElse("");
	}
}
