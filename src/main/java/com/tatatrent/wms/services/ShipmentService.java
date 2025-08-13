package com.tatatrent.wms.services;

import com.tatatrent.wms.ui.rest.dto.ShipmentOrder;

public interface ShipmentService {
	public boolean processOrder(ShipmentOrder orders);
}
