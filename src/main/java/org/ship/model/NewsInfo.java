package org.ship.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * NewsInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "news_info", catalog = "ship_administration")
public class NewsInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6693681650130362012L;

	/**
	 * 
	 */
	// Fields

	private Long newsCode;
	private String newsTitle;
	private String newsContext;
	private String newsImages;
	private Long newsState;
	private Long userId;

	// Constructors

	/** default constructor */
	public NewsInfo() {
	}

	/** minimal constructor */
	public NewsInfo(String newsTitle, Long newsState, Long userId) {
		this.newsTitle = newsTitle;
		this.newsState = newsState;
		this.userId = userId;
	}

	/** full constructor */
	public NewsInfo(String newsTitle, String newsContext, String newsImages,
			Long newsState, Long userId) {
		this.newsTitle = newsTitle;
		this.newsContext = newsContext;
		this.newsImages = newsImages;
		this.newsState = newsState;
		this.userId = userId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "news_code", unique = true, nullable = false)
	public Long getNewsCode() {
		return this.newsCode;
	}

	public void setNewsCode(Long newsCode) {
		this.newsCode = newsCode;
	}

	@Column(name = "news_title", nullable = false, length = 64)
	public String getNewsTitle() {
		return this.newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	@Column(name = "news_context", length = 65535)
	public String getNewsContext() {
		return this.newsContext;
	}

	public void setNewsContext(String newsContext) {
		this.newsContext = newsContext;
	}

	@Column(name = "news_images", length = 128)
	public String getNewsImages() {
		return this.newsImages;
	}

	public void setNewsImages(String newsImages) {
		this.newsImages = newsImages;
	}

	@Column(name = "news_state", nullable = false)
	public Long getNewsState() {
		return this.newsState;
	}

	public void setNewsState(Long newsState) {
		this.newsState = newsState;
	}

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}