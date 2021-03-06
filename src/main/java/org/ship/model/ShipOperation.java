package org.ship.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ShipOperation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ship_operation", catalog = "ship_administration")
public class ShipOperation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4671926061235135605L;
	/**
	 * 
	 */
	private Long shipOperationCode;
	private Long shipId;
	private Long userId;
	private Long shipState;
	private Timestamp stratime;
	private Timestamp endtime;

	// Constructors

	/** default constructor */
	public ShipOperation() {
	}

	/** minimal constructor */
	public ShipOperation(Long shipId, Long userId, Long shipState) {
		this.shipId = shipId;
		this.userId = userId;
		this.shipState = shipState;
	}

	/** full constructor */
	public ShipOperation(Long shipId, Long userId, Long shipState,
			Timestamp stratime, Timestamp endtime) {
		this.shipId = shipId;
		this.userId = userId;
		this.shipState = shipState;
		this.stratime = stratime;
		this.endtime = endtime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ship_operation_code", unique = true, nullable = false)
	public Long getShipOperationCode() {
		return this.shipOperationCode;
	}

	public void setShipOperationCode(Long shipOperationCode) {
		this.shipOperationCode = shipOperationCode;
	}

	@Column(name = "ship_id", nullable = false)
	public Long getShipId() {
		return this.shipId;
	}

	public void setShipId(Long shipId) {
		this.shipId = shipId;
	}

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "ship_state", nullable = false)
	public Long getShipState() {
		return this.shipState;
	}

	public void setShipState(Long shipState) {
		this.shipState = shipState;
	}

	@Column(name = "stratime", nullable = false, length = 19)
	public Date getStratime() {
		return this.stratime;
	}

	public void setStratime(Timestamp stratime) {
		this.stratime = stratime;
	}

	@Column(name = "endtime", nullable = false, length = 19)
	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

}