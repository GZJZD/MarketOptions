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
	private String expectedNetProfit;
	//业绩变动幅度
	private String performanceChangeRatio;
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
	public String getExpectedNetProfit() {
		return expectedNetProfit;
	}
	public void setExpectedNetProfit(String expectedNetProfit) {
		this.expectedNetProfit = expectedNetProfit;
	}
	public String getPerformanceChangeRatio() {
		return performanceChangeRatio;
	}
	public void setPerformanceChangeRatio(String performanceChangeRatio) {
		this.performanceChangeRatio = performanceChangeRatio;
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
