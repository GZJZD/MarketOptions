package com.web.pojo;
/**
 * 财报披露
 * @author Administrator
 *
 */
public class CrawlerFinancialDisclosure {
	//主键
	private Long id;
	//股票名称
	private String sharesName;
	//股票代码
	private String sharesCode;
	//业绩变动
	private String performanceChange;
	//预计净利润
	private String expectedNetProfitLeft;
	private String expectedNetProfitRight;
	//业绩变动幅度
	private String performanceChangeRatioLeft;
	private String performanceChangeRatioRight;
	//业绩变动原因
	private String performanceChangeReason;
	//预告类型
	private String previewType;
	//上年同期净利润
	private String previousYearProfit;
	//公告日期
	private String announcementDate;
	
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
	public String getPerformanceChange() {
		return performanceChange;
	}
	public void setPerformanceChange(String performanceChange) {
		this.performanceChange = performanceChange;
	}
	public String getExpectedNetProfitLeft() {
		return expectedNetProfitLeft;
	}
	public void setExpectedNetProfitLeft(String expectedNetProfitLeft) {
		this.expectedNetProfitLeft = expectedNetProfitLeft;
	}
	public String getExpectedNetProfitRight() {
		return expectedNetProfitRight;
	}
	public void setExpectedNetProfitRight(String expectedNetProfitRight) {
		this.expectedNetProfitRight = expectedNetProfitRight;
	}
	public String getPerformanceChangeRatioLeft() {
		return performanceChangeRatioLeft;
	}
	public void setPerformanceChangeRatioLeft(String performanceChangeRatioLeft) {
		this.performanceChangeRatioLeft = performanceChangeRatioLeft;
	}
	public String getPerformanceChangeRatioRight() {
		return performanceChangeRatioRight;
	}
	public void setPerformanceChangeRatioRight(String performanceChangeRatioRight) {
		this.performanceChangeRatioRight = performanceChangeRatioRight;
	}
	public String getPerformanceChangeReason() {
		return performanceChangeReason;
	}
	public void setPerformanceChangeReason(String performanceChangeReason) {
		this.performanceChangeReason = performanceChangeReason;
	}
	public String getPreviewType() {
		return previewType;
	}
	public void setPreviewType(String previewType) {
		this.previewType = previewType;
	}
	public String getPreviousYearProfit() {
		return previousYearProfit;
	}
	public void setPreviousYearProfit(String previousYearProfit) {
		this.previousYearProfit = previousYearProfit;
	}
	public String getAnnouncementDate() {
		return announcementDate;
	}
	public void setAnnouncementDate(String announcementDate) {
		this.announcementDate = announcementDate;
	}
	
}
