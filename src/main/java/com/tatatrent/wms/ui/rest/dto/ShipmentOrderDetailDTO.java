package com.tatatrent.wms.ui.rest.dto;

import java.util.Objects;

public class ShipmentOrderDetailDTO {
	
	private String transid;
	private String orderKey;
	private String externOrderKey;
	private String externLineNo;
	private String storerKey;
	private String sku;
	private String openQty;
	private String susr1;
	private String susr2;
	private String susr3;
	private String susr4;
	private String susr5;
	private String lottable06;
	private String lottable07;
	private String lottable08;
	private String plant;
	private String sloc;
	
	public ShipmentOrderDetailDTO() {
		
	}

	public ShipmentOrderDetailDTO(String transid, String orderKey, String externOrderKey, String externLineNo,
			String storerKey, String sku, String openQty, String susr1, String susr2, String susr3, String susr4,
			String susr5, String lottable06, String lottable07, String lottable08, String plant, String sloc) {
		this.transid = transid;
		this.orderKey = orderKey;
		this.externOrderKey = externOrderKey;
		this.externLineNo = externLineNo;
		this.storerKey = storerKey;
		this.sku = sku;
		this.openQty = openQty;
		this.susr1 = susr1;
		this.susr2 = susr2;
		this.susr3 = susr3;
		this.susr4 = susr4;
		this.susr5 = susr5;
		this.lottable06 = lottable06;
		this.lottable07 = lottable07;
		this.lottable08 = lottable08;
		this.plant = plant;
		this.sloc = sloc;
	}

	public String getTransid() {
		return transid;
	}

	public void setTransid(String transid) {
		this.transid = transid;
	}

	public String getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}

	public String getExternOrderKey() {
		return externOrderKey;
	}

	public void setExternOrderKey(String externOrderKey) {
		this.externOrderKey = externOrderKey;
	}

	public String getExternLineNo() {
		return externLineNo;
	}

	public void setExternLineNo(String externLineNo) {
		this.externLineNo = externLineNo;
	}

	public String getStorerKey() {
		return storerKey;
	}

	public void setStorerKey(String storerKey) {
		this.storerKey = storerKey;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getOpenQty() {
		return openQty;
	}

	public void setOpenQty(String openQty) {
		this.openQty = openQty;
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

	public String getLottable06() {
		return lottable06;
	}

	public void setLottable06(String lottable06) {
		this.lottable06 = lottable06;
	}

	public String getLottable07() {
		return lottable07;
	}

	public void setLottable07(String lottable07) {
		this.lottable07 = lottable07;
	}

	public String getLottable08() {
		return lottable08;
	}

	public void setLottable08(String lottable08) {
		this.lottable08 = lottable08;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getSloc() {
		return sloc;
	}

	public void setSloc(String sloc) {
		this.sloc = sloc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(externLineNo, externOrderKey, lottable06, lottable07, lottable08, openQty, orderKey, plant,
				sku, sloc, storerKey, susr1, susr2, susr3, susr4, susr5, transid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShipmentOrderDetailDTO other = (ShipmentOrderDetailDTO) obj;
		return Objects.equals(externLineNo, other.externLineNo) && Objects.equals(externOrderKey, other.externOrderKey)
				&& Objects.equals(lottable06, other.lottable06) && Objects.equals(lottable07, other.lottable07)
				&& Objects.equals(lottable08, other.lottable08) && Objects.equals(openQty, other.openQty)
				&& Objects.equals(orderKey, other.orderKey) && Objects.equals(plant, other.plant)
				&& Objects.equals(sku, other.sku) && Objects.equals(sloc, other.sloc)
				&& Objects.equals(storerKey, other.storerKey) && Objects.equals(susr1, other.susr1)
				&& Objects.equals(susr2, other.susr2) && Objects.equals(susr3, other.susr3)
				&& Objects.equals(susr4, other.susr4) && Objects.equals(susr5, other.susr5)
				&& Objects.equals(transid, other.transid);
	}

	@Override
	public String toString() {
		return "ShipmentOrderDetailDTO [transid=" + transid + ", orderKey=" + orderKey + ", externOrderKey="
				+ externOrderKey + ", externLineNo=" + externLineNo + ", storerKey=" + storerKey + ", sku=" + sku
				+ ", openQty=" + openQty + ", susr1=" + susr1 + ", susr2=" + susr2 + ", susr3=" + susr3 + ", susr4="
				+ susr4 + ", susr5=" + susr5 + ", lottable06=" + lottable06 + ", lottable07=" + lottable07
				+ ", lottable08=" + lottable08 + ", plant=" + plant + ", sloc=" + sloc + "]";
	}
}
