package org.ship.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ShipType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ship_type", catalog = "ship_administration")
public class ShipType implements java.io.Serializable {

	// Fields

	private Integer shipTypeCode;
	private String shipTypeName;

	// Constructors

	/** default constructor */
	public ShipType() {
	}

	/** full constructor */
	public ShipType(String shipTypeName) {
		this.shipTypeName = shipTypeName;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ship_type_code", unique = true, nullable = false)
	public Integer getShipTypeCode() {
		return this.shipTypeCode;
	}

	public void setShipTypeCode(Integer shipTypeCode) {
		this.shipTypeCode = shipTypeCode;
	}

	@Column(name = "ship_type_name", length = 32)
	public String getShipTypeName() {
		return this.shipTypeName;
	}

	public void setShipTypeName(String shipTypeName) {
		this.shipTypeName = shipTypeName;
	}

}