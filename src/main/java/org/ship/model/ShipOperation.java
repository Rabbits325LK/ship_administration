package org.ship.model;

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

	private Integer shipOperationCode;
	private Integer shipId;
	private Integer userId;
	private Integer shipState;
	private Date stratime;
	private Date endtime;

	// Constructors

	/** default constructor */
	public ShipOperation() {
	}

	/** minimal constructor */
	public ShipOperation(Integer shipId, Integer userId, Integer shipState) {
		this.shipId = shipId;
		this.userId = userId;
		this.shipState = shipState;
	}

	/** full constructor */
	public ShipOperation(Integer shipId, Integer userId, Integer shipState,
			Date stratime, Date endtime) {
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
	public Integer getShipOperationCode() {
		return this.shipOperationCode;
	}

	public void setShipOperationCode(Integer shipOperationCode) {
		this.shipOperationCode = shipOperationCode;
	}

	@Column(name = "ship_id", nullable = false)
	public Integer getShipId() {
		return this.shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "ship_state", nullable = false)
	public Integer getShipState() {
		return this.shipState;
	}

	public void setShipState(Integer shipState) {
		this.shipState = shipState;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "stratime", length = 10)
	public Date getStratime() {
		return this.stratime;
	}

	public void setStratime(Date stratime) {
		this.stratime = stratime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "endtime", length = 10)
	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

}