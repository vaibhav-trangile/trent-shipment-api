package com.tatatrent.wms.ui.rest.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tatatrent.wms.services.ShipmentService;
import com.tatatrent.wms.ui.rest.dto.ApiResponse;
import com.tatatrent.wms.ui.rest.dto.StoRequestDto;
import com.tatatrent.wms.util.AppConstants;

@Validated
@RestController
@RequestMapping(AppConstants.SHIPMENT_BASE_URL)
public class ShipmentOrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(ShipmentOrderController.class);
	
	@Autowired
	private ShipmentService shipMentService;
	
	@PostMapping(value = AppConstants.SHIPMENT_ORDER_ENDPOINT, consumes = AppConstants.CONSUMABLES, produces = AppConstants.CONSUMABLES)
	public ResponseEntity<ApiResponse> saveOrders(@RequestBody @Valid StoRequestDto orders) {
		logger.info("Order came to controller:: \n {}",orders);
		try {
//			boolean saveOrderToDb = shipMentService.saveOrderToDb(orders.getShipmentOrder());
			if (shipMentService.processOrder(orders.getShipmentOrder())) {
				return new ResponseEntity<ApiResponse>(new ApiResponse(), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<ApiResponse>(new ApiResponse(HttpStatus.REQUEST_TIMEOUT.value(), false, "Something went wrong."), HttpStatus.CREATED);
			}
		} catch (Exception e) {
			logger.error("Got exception: {}", e);
		}
		return null;
	}
	
	
	

}
