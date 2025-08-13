package com.tatatrent.wms.util;

import java.sql.Date;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public interface AppConstants {
	Logger logger = LoggerFactory.getLogger(AppConstants.class);
	String DRIVER_CLASS = "oracle.jdbc.OracleDriver";
	String DB_PREFIX = "jdbc:oracle:thin:@";
	String DB_POSTFIX = "1521:";
	String SHIPMENT_BASE_URL = "/trentapi/v1/wms/shipmentprocess";
	String SHIPMENT_ORDER_ENDPOINT = "/orders";
	String CONSUMABLES = "application/json";
	String HEADER_TABLE = "TL_I_ORDERS_STAGE";
	String DETAIL_TABLE = "TL_I_ORDERDETAIL_STG";
	String SUCCESS_RESPONSE_MESSAGE = "Data stored successfully.";
	String API_NAME= "trent-shipment-api";
	
	String TRANS_SQL = "select TL_TRANSID_SEQ.NEXTVAL as transid from dual";
	String INSERT_HEADER_SQL = String.format("INSERT INTO %s (TRANSID, RSYSTEMID, ORDERKEY, EXTERNORDERKEY, STORERKEY, ORDERDATE, DELIVERYDATE, REQUESTEDSHIPDATE, PRIORITY, TYPE, CONSIGNEEKEY, BUYERPO, SUSR1, SUSR2, SUSR3, SUSR4, SUSR5, ADDWHO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", HEADER_TABLE);
    String INSERT_DETAIL_SQL = String.format("INSERT INTO %s (TRANSID, ORDERKEY, EXTERNORDERKEY, EXTERNLINENO, SKU, OPENQTY, STORERKEY,  SUSR1, SUSR2, SUSR3, SUSR4, SUSR5, LOTTABLE06, LOTTABLE07, LOTTABLE08, PLANT, SLOC) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", DETAIL_TABLE);
	String INSERT_ERROR_INTO_DB = "INSERT INTO TL_ALERT_MSG (WHSEID, ALERTTYPE, TABLENAME, PROGNAME, MSG, ADDWHO, EMAILFLAG, URL) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	public static String checkNullValues(String value) {
		if (value == null) {
			return "";
		} else
			return value;
	}
	
		
	
	/**
     * Converts a STADATE string (e.g., 20230307) into a java.sql.Date object.
     *
     * @param stadate The STADATE string.
     * @return A java.sql.Date object.
     */
    public static Date convertToSQLDate(LocalDate stadate) {
    	logger.info("Inside convertToSQLDate() :: {}", stadate);
        try {
//            // Parse the date string into a LocalDate
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-DD-YYYY");
//            LocalDate localDate = LocalDate.parse(stadate, formatter);
//
//            // Convert LocalDate to java.sql.Date
            return Date.valueOf(stadate);

        } catch (Exception e) {
            System.err.println("Error converting STADATE: " + stadate + " - " + e.getMessage());
            return null;
        }
    }
    
    public static String checkValues(String headervalue,
			String detailValue2) {
		if (detailValue2 != null && detailValue2.trim().length() > 0) {
			return detailValue2;
		}
		return headervalue;
	}

}