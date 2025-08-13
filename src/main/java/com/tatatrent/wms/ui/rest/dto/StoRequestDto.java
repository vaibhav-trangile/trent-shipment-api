package com.tatatrent.wms.ui.rest.dto;

import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StoRequestDto {
	
	@Valid
	@JsonProperty("shipmentOrder")
	private ShipmentOrder shipmentOrder;

	public StoRequestDto() {
		
	}

	public StoRequestDto(ShipmentOrder shipmentOrder) {
		this.shipmentOrder = shipmentOrder;
	}

	public ShipmentOrder getShipmentOrder() {
		return shipmentOrder;
	}

	public void setShipmentOrder(ShipmentOrder shipmentOrder) {
		this.shipmentOrder = shipmentOrder;
	}

	@Override
	public int hashCode() {
		return Objects.hash(shipmentOrder);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoRequestDto other = (StoRequestDto) obj;
		return Objects.equals(shipmentOrder, other.shipmentOrder);
	}

	@Override
	public String toString() {
		return "StoRequestDto [shipmentOrder=" + shipmentOrder + "]";
	}
}
