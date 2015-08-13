package org.ship.api.model;


public class ShipInfoModel {
	
	private Long shipId;
	private String shipName;
	private String shipType;
	private String shipSize;
	private String shipCapacity;
	private String shipImages;
	
	
	
	
	@Override
	public String toString() {
		return "ShipInfoModel [shipId=" + shipId + ", shipName=" + shipName
				+ ", shipType=" + shipType + ", shipSize=" + shipSize
				+ ", shipCapacity=" + shipCapacity + ", shipImages="
				+ shipImages + "]";
	}
	public Long getShipId() {
		return shipId;
	}
	public void setShipId(Long shipId) {
		this.shipId = shipId;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public String getShipType() {
		return shipType;
	}
	public void setShipType(String shipType) {
		this.shipType = shipType;
	}
	public String getShipSize() {
		return shipSize;
	}
	public void setShipSize(String shipSize) {
		this.shipSize = shipSize;
	}
	public String getShipCapacity() {
		return shipCapacity;
	}
	public void setShipCapacity(String shipCapacity) {
		this.shipCapacity = shipCapacity;
	}
	public String getShipImages() {
		return shipImages;
	}
	public void setShipImages(String shipImages) {
		this.shipImages = shipImages;
	}
	
	
	
}
