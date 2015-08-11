package org.ship.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ShipInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ship_info", catalog = "ship_administration")
public class ShipInfo implements java.io.Serializable {

	// Fields

	private Integer shipId;
	private String shipName;
	private Integer shipTypeCode;
	private String shipSize;
	private String shipCapacity;
	private String shipImages;

	// Constructors

	/** default constructor */
	public ShipInfo() {
	}

	/** minimal constructor */
	public ShipInfo(String shipName, Integer shipTypeCode) {
		this.shipName = shipName;
		this.shipTypeCode = shipTypeCode;
	}

	/** full constructor */
	public ShipInfo(String shipName, Integer shipTypeCode, String shipSize,
			String shipCapacity, String shipImages) {
		this.shipName = shipName;
		this.shipTypeCode = shipTypeCode;
		this.shipSize = shipSize;
		this.shipCapacity = shipCapacity;
		this.shipImages = shipImages;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ship_id", unique = true, nullable = false)
	public Integer getShipId() {
		return this.shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	@Column(name = "ship_name", nullable = false, length = 64)
	public String getShipName() {
		return this.shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	@Column(name = "ship_type_code", nullable = false)
	public Integer getShipTypeCode() {
		return this.shipTypeCode;
	}

	public void setShipTypeCode(Integer shipTypeCode) {
		this.shipTypeCode = shipTypeCode;
	}

	@Column(name = "ship_size", length = 32)
	public String getShipSize() {
		return this.shipSize;
	}

	public void setShipSize(String shipSize) {
		this.shipSize = shipSize;
	}

	@Column(name = "ship_capacity", length = 32)
	public String getShipCapacity() {
		return this.shipCapacity;
	}

	public void setShipCapacity(String shipCapacity) {
		this.shipCapacity = shipCapacity;
	}

	@Column(name = "ship_images", length = 128)
	public String getShipImages() {
		return this.shipImages;
	}

	public void setShipImages(String shipImages) {
		this.shipImages = shipImages;
	}

}