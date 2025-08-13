package com.tatatrent.wms.db.repos;

import java.util.Optional;

import com.tatatrent.wms.ui.rest.dto.ShipmentOrderHeaderDTO;

public interface WmsRepository {
	
	public Optional<String> getTransid();
	public Optional<Boolean> saveOrderToDb(ShipmentOrderHeaderDTO dto);

}
