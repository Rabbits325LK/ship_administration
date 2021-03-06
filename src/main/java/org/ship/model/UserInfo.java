package org.ship.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_info", catalog = "ship_administration")
public class UserInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6626496746680570224L;
	/**
	 * 
	 */
	private Long userId;
	private Long roleId;
	private String userName;
	private String userPwd;
	private String nickName;
	private Integer gender;
	private String userIdcard;
	private String address;
	private String email;
	private String tel;
	private String phone;
	private String qq;
	private String userImages;

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(Long roleId) {
		this.roleId = roleId;
	}

	/** full constructor */
	public UserInfo(Long roleId, String userName, String userPwd, String nickName,
			Integer gender, String userIdcard,
			String address, String email, String tel, String phone, String qq,
			String userImages) {
		this.roleId = roleId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.nickName = nickName;
		this.gender = gender;
		this.userIdcard = userIdcard;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.phone = phone;
		this.qq = qq;
		this.userImages = userImages;
	}

	
	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "role_id", nullable = false)
	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Column(name = "user_name", length = 32, nullable = false)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_pwd", length = 64, nullable = false)
	public String getUserPwd() {
		return this.userPwd;
	}
	
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	@Column(name = "nick_name", length = 32)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "gender")
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Column(name = "user_idcard")
	public String getUserIdcard() {
		return userIdcard;
	}

	public void setUserIdcard(String userIdcard) {
		this.userIdcard = userIdcard;
	}

	@Column(name = "address", length = 128)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "email", length = 64)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "tel", length = 13)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "phone", length = 11)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "qq", length = 32)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "user_images", length = 128)
	public String getUserImages() {
		return this.userImages;
	}

	public void setUserImages(String userImages) {
		this.userImages = userImages;
	}

}