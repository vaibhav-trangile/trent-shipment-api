package com.tatatrent.wms.ui.rest.dto;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShipmentOrder {
	
    @Valid
    @NotNull
	@JsonProperty("shipmentOrderHeader")
	private ShipmentOrderHeader shipmentOrderHeader;

	public ShipmentOrder() {
		
	}

	public ShipmentOrder(ShipmentOrderHeader shipmentOrderHeader) {
		this.shipmentOrderHeader = shipmentOrderHeader;
	}

	public ShipmentOrderHeader getShipmentOrderHeader() {
		return shipmentOrderHeader;
	}

	public void setShipmentOrderHeader(ShipmentOrderHeader shipmentOrderHeader) {
		this.shipmentOrderHeader = shipmentOrderHeader;
	}

	@Override
	public int hashCode() {
		return Objects.hash(shipmentOrderHeader);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShipmentOrder other = (ShipmentOrder) obj;
		return Objects.equals(shipmentOrderHeader, other.shipmentOrderHeader);
	}

	@Override
	public String toString() {
		return "ShipmentOrder [header=" + shipmentOrderHeader + "]";
	}
}
