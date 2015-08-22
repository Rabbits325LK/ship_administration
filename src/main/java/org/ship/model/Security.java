package org.ship.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Security entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "security", catalog = "ship_manager")
public class Security implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5268055681444418324L;
	private Long securityId;
	private String projectName;
	private String publicKey;
	private String privateKey;
	private Long projectState;

	// Constructors

	/** default constructor */
	public Security() {
	}

	/** minimal constructor */
	public Security(Long securityId, String projectName, String publicKey,
			String privateKey) {
		this.securityId = securityId;
		this.projectName = projectName;
		this.publicKey = publicKey;
		this.privateKey = privateKey;
	}

	/** full constructor */
	public Security(Long securityId, String projectName, String publicKey,
			String privateKey, Long projectState) {
		this.securityId = securityId;
		this.projectName = projectName;
		this.publicKey = publicKey;
		this.privateKey = privateKey;
		this.projectState = projectState;
	}

	// Property accessors
	@Id
	@Column(name = "security_id", unique = true, nullable = false)
	@GeneratedValue
	public Long getSecurityId() {
		return this.securityId;
	}

	public void setSecurityId(Long securityId) {
		this.securityId = securityId;
	}

	@Column(name = "project_name", nullable = false, length = 64)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "public_key", nullable = false, length = 1280)
	public String getPublicKey() {
		return this.publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	@Column(name = "private_key", nullable = false, length = 1280)
	public String getPrivateKey() {
		return this.privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	@Column(name = "project_state")
	public Long getProjectState() {
		return this.projectState;
	}

	public void setProjectState(Long projectState) {
		this.projectState = projectState;
	}

}