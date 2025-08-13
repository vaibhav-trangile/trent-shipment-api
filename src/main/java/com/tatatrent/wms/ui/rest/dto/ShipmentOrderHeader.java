package com.tatatrent.wms.ui.rest.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ShipmentOrderHeader {
	
	@JsonProperty("orderKey")
	private String orderKey;
	
	@NotBlank(message = "Extern Order key can not be null/blank.")
	@JsonProperty("externOrderKey")
	private String externOrderKey;
	
	@JsonProperty("storerKey")
	private String storerKey;
	
	@JsonProperty("orderDate")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate orderDate;
	
	@JsonProperty("deliveryDate")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate deliveryDate;
	
	@JsonProperty("requestedShipDate")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate requestedShipDate;
	
	@JsonProperty("rSystemId")
	private String rSystemId;
	
	@JsonProperty("priority")
	private String priority;
	
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("consigneeKey")
	@NotBlank(message = "Consignee key (Receiver)  can not be null/blank.")
	private String consigneeKey;
	
	
	@JsonProperty("buyerPO")
	private String buyerPO;
	
	@JsonProperty("susr1")
	private String susr1;
	
	@JsonProperty("susr2")
	private String susr2;
	
	@JsonProperty("susr3")
	private String susr3;
	
	@JsonProperty("susr4")
	private String susr4;
	
	@JsonProperty("susr5")
	private String susr5;
	
	@Valid
	@JsonProperty("shipmentOrderDetail")
	private List<ShipmentOrderDetail> shipmentOrderDetail;
	
	public ShipmentOrderHeader() {
		
	}

	public ShipmentOrderHeader(String orderKey,
			String externOrderKey,
			String storerKey, LocalDate orderDate, LocalDate deliveryDate, LocalDate requestedShipDate,
			String rSystemId, String priority,
			String type,
			String consigneeKey, String buyerPO,
			String susr1, String susr2, String susr3, String susr4, String susr5,
			List<ShipmentOrderDetail> shipmentOrderDetail) {
		this.orderKey = orderKey;
		this.externOrderKey = externOrderKey;
		this.storerKey = storerKey;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.requestedShipDate = requestedShipDate;
		this.rSystemId = rSystemId;
		this.priority = priority;
		this.type = type;
		this.consigneeKey = consigneeKey;
		this.buyerPO = buyerPO;
		this.susr1 = susr1;
		this.susr2 = susr2;
		this.susr3 = susr3;
		this.susr4 = susr4;
		this.susr5 = susr5;
		this.shipmentOrderDetail = shipmentOrderDetail;
	}
	
	@NotBlank(message = "Order key (STO number) can not be null/blank.")
	@JsonProperty("orderKey")
	public String getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}
	
	@NotBlank(message = "External order key can not be null/blank.")
	@JsonProperty("externOrderKey")
	public String getExternOrderKey() {
		return externOrderKey;
	}

	public void setExternOrderKey(String externOrderKey) {
		this.externOrderKey = externOrderKey;
	}

	public String getStorerKey() {
		return storerKey;
	}

	public void setStorerKey(String storerKey) {
		this.storerKey = storerKey;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public LocalDate getRequestedShipDate() {
		return requestedShipDate;
	}

	public void setRequestedShipDate(LocalDate requestedShipDate) {
		this.requestedShipDate = requestedShipDate;
	}
	
	@NotBlank(message = "Rsystemid (supplier) can not be null/blank.")
	@JsonProperty("rSystemId")
	public String getRSystemId() {
		return rSystemId;
	}

	public void setRSystemId(String rSystemId) {
		this.rSystemId = rSystemId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	@NotBlank(message = "Type (Order type) can not be null/blank.")
	@JsonProperty("type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@NotBlank(message = "Consignee key (Receiver)  can not be null/blank.")
	@JsonProperty("consigneeKey")
	public String getConsigneeKey() {
		return consigneeKey;
	}

	public void setConsigneeKey(String consigneeKey) {
		this.consigneeKey = consigneeKey;
	}

	public String getBuyerPO() {
		return buyerPO;
	}

	public void setBuyerPO(String buyerPO) {
		this.buyerPO = buyerPO;
	}

	public String getSusr1() {
		return susr1;
	}

	public void setSusr1(String susr1) {
		this.susr1 = susr1;
	}

	public String getSusr2() {
		return susr2;
	}

	public void setSusr2(String susr2) {
		this.susr2 = susr2;
	}

	public String getSusr3() {
		return susr3;
	}

	public void setSusr3(String susr3) {
		this.susr3 = susr3;
	}

	public String getSusr4() {
		return susr4;
	}

	public void setSusr4(String susr4) {
		this.susr4 = susr4;
	}

	public String getSusr5() {
		return susr5;
	}

	public void setSusr5(String susr5) {
		this.susr5 = susr5;
	}

	public List<ShipmentOrderDetail> getShipmentOrderDetail() {
		return shipmentOrderDetail;
	}

	public void setShipmentOrderDetail(List<ShipmentOrderDetail> shipmentOrderDetail) {
		this.shipmentOrderDetail = shipmentOrderDetail;
	}

	@Override
	public int hashCode() {
		return Objects.hash(buyerPO, consigneeKey, deliveryDate, shipmentOrderDetail, externOrderKey, orderDate, orderKey, priority,
				rSystemId, requestedShipDate, storerKey, susr1, susr2, susr3, susr4, susr5, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShipmentOrderHeader other = (ShipmentOrderHeader) obj;
		return Objects.equals(buyerPO, other.buyerPO) && Objects.equals(consigneeKey, other.consigneeKey)
				&& Objects.equals(deliveryDate, other.deliveryDate) && Objects.equals(shipmentOrderDetail, other.shipmentOrderDetail)
				&& Objects.equals(externOrderKey, other.externOrderKey) && Objects.equals(orderDate, other.orderDate)
				&& Objects.equals(orderKey, other.orderKey) && Objects.equals(priority, other.priority)
				&& Objects.equals(rSystemId, other.rSystemId)
				&& Objects.equals(requestedShipDate, other.requestedShipDate)
				&& Objects.equals(storerKey, other.storerKey) && Objects.equals(susr1, other.susr1)
				&& Objects.equals(susr2, other.susr2) && Objects.equals(susr3, other.susr3)
				&& Objects.equals(susr4, other.susr4) && Objects.equals(susr5, other.susr5)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "ShipmentOrderHeader [orderKey=" + orderKey + ", externOrderKey=" + externOrderKey + ", storerKey="
				+ storerKey + ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate + ", requestedShipDate="
				+ requestedShipDate + ", rSystemId=" + rSystemId + ", priority=" + priority + ", type=" + type
				+ ", consigneeKey=" + consigneeKey + ", buyerPO=" + buyerPO + ", susr1=" + susr1 + ", susr2=" + susr2
				+ ", susr3=" + susr3 + ", susr4=" + susr4 + ", susr5=" + susr5 + ", details=" + shipmentOrderDetail + "]";
	}
}
