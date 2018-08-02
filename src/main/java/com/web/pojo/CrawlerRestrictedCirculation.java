package com.web.pojo;
/**
 * 限售解禁
 * @author Administrator
 *
 */
public class CrawlerRestrictedCirculation {
	//主键
	private Long id;
	//股票名称
	private String sharesName;
	//股票代码
	private String sharesCode;
	//解禁时间
	private String circulationDate;
	//解禁股东数
	private String shareholdersNum;
	//解禁数量(股)
	private String shareNum;
	//实际解禁数量(股)
	private String realShareNum;
	//未解禁数量(股)
	private String nonShareNum;
	//实际解禁市值(元)	
	private String realSharePrice;
	//占总市值比例(%)
	private String equityRatio;
	//占流通市值比例(%)
	private String shareRatio;
	//解禁前一日收盘价(元)
	private String closePrice;
	//限售股类型
	private String shareType;
	//解禁前20日涨跌幅(%)
	private String beforeRange;
	//解禁后20日涨跌幅(%)
	private String afterRange;
	
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
	public String getCirculationDate() {
		return circulationDate;
	}
	public void setCirculationDate(String circulationDate) {
		this.circulationDate = circulationDate;
	}
	public String getShareholdersNum() {
		return shareholdersNum;
	}
	public void setShareholdersNum(String shareholdersNum) {
		this.shareholdersNum = shareholdersNum;
	}
	public String getShareNum() {
		return shareNum;
	}
	public void setShareNum(String shareNum) {
		this.shareNum = shareNum;
	}
	public String getRealShareNum() {
		return realShareNum;
	}
	public void setRealShareNum(String realShareNum) {
		this.realShareNum = realShareNum;
	}
	public String getNonShareNum() {
		return nonShareNum;
	}
	public void setNonShareNum(String nonShareNum) {
		this.nonShareNum = nonShareNum;
	}
	public String getRealSharePrice() {
		return realSharePrice;
	}
	public void setRealSharePrice(String realSharePrice) {
		this.realSharePrice = realSharePrice;
	}
	public String getEquityRatio() {
		return equityRatio;
	}
	public void setEquityRatio(String equityRatio) {
		this.equityRatio = equityRatio;
	}
	public String getShareRatio() {
		return shareRatio;
	}
	public void setShareRatio(String shareRatio) {
		this.shareRatio = shareRatio;
	}
	public String getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(String closePrice) {
		this.closePrice = closePrice;
	}
	public String getShareType() {
		return shareType;
	}
	public void setShareType(String shareType) {
		this.shareType = shareType;
	}
	public String getBeforeRange() {
		return beforeRange;
	}
	public void setBeforeRange(String beforeRange) {
		this.beforeRange = beforeRange;
	}
	public String getAfterRange() {
		return afterRange;
	}
	public void setAfterRange(String afterRange) {
		this.afterRange = afterRange;
	}
	
}
