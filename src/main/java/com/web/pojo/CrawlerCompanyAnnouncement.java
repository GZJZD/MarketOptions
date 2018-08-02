package com.web.pojo;
/**
 * 公司公告
 * @author Administrator
 *
 */
public class CrawlerCompanyAnnouncement {
	//主键
	private Long id;
	//股票名称
	private String sharesName;
	//股票代码
	private String sharesCode;
	//公告标题
	private String announceTitle;
	//公告地址
	private String announceUrl;
	//公告类型
	private String announceType;
	//公告日期
	private String announceDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSharesName() {
		return sharesName;
	}
	public void setSharesName(String sharesName) {
		this.sharesName = sharesName;
	}
	public String getSharesCode() {
		return sharesCode;
	}
	public void setSharesCode(String sharesCode) {
		this.sharesCode = sharesCode;
	}
	public String getAnnounceTitle() {
		return announceTitle;
	}
	public void setAnnounceTitle(String announceTitle) {
		this.announceTitle = announceTitle;
	}
	public String getAnnounceUrl() {
		return announceUrl;
	}
	public void setAnnounceUrl(String announceUrl) {
		this.announceUrl = announceUrl;
	}
	public String getAnnounceType() {
		return announceType;
	}
	public void setAnnounceType(String announceType) {
		this.announceType = announceType;
	}
	public String getAnnounceDate() {
		return announceDate;
	}
	public void setAnnounceDate(String announceDate) {
		this.announceDate = announceDate;
	}
	
}
