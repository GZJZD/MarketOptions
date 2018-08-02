package com.web.pojo;
/**
 * 主力流入
 * @author Administrator
 *
 */
public class CrawlerMainInflux {
	//主键
	private Long id;
	//股票名称
	private String sharesName;
	//股票代码
	private String sharesCode;
	//主力净流入净额
	private String mainInfluxPrice;
	//主力净流入净占比
	private String mainInfluxRatio;
	//超大单净流入净额
	private String hugeInfluxPrice;
	//超大单净流入净占比
	private String hugeInfluxRatio;
	//大单净流入净额
	private String largeInfluxPrice;
	//大单净流入净占比
	private String largeInfluxRatio;
	//中单净流入净额
	private String middleInfluxPrice;
	//中单净流入净占比
	private String middleInfluxRatio;
	//小单净流入净额
	private String smallInfluxPrice;
	//小单净流入净占比
	private String smallInfluxRatio;
	//日期
	private String date;
	
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
	public String getMainInfluxPrice() {
		return mainInfluxPrice;
	}
	public void setMainInfluxPrice(String mainInfluxPrice) {
		this.mainInfluxPrice = mainInfluxPrice;
	}
	public String getMainInfluxRatio() {
		return mainInfluxRatio;
	}
	public void setMainInfluxRatio(String mainInfluxRatio) {
		this.mainInfluxRatio = mainInfluxRatio;
	}
	public String getHugeInfluxPrice() {
		return hugeInfluxPrice;
	}
	public void setHugeInfluxPrice(String hugeInfluxPrice) {
		this.hugeInfluxPrice = hugeInfluxPrice;
	}
	public String getHugeInfluxRatio() {
		return hugeInfluxRatio;
	}
	public void setHugeInfluxRatio(String hugeInfluxRatio) {
		this.hugeInfluxRatio = hugeInfluxRatio;
	}
	public String getLargeInfluxPrice() {
		return largeInfluxPrice;
	}
	public void setLargeInfluxPrice(String largeInfluxPrice) {
		this.largeInfluxPrice = largeInfluxPrice;
	}
	public String getLargeInfluxRatio() {
		return largeInfluxRatio;
	}
	public void setLargeInfluxRatio(String largeInfluxRatio) {
		this.largeInfluxRatio = largeInfluxRatio;
	}
	public String getMiddleInfluxPrice() {
		return middleInfluxPrice;
	}
	public void setMiddleInfluxPrice(String middleInfluxPrice) {
		this.middleInfluxPrice = middleInfluxPrice;
	}
	public String getMiddleInfluxRatio() {
		return middleInfluxRatio;
	}
	public void setMiddleInfluxRatio(String middleInfluxRatio) {
		this.middleInfluxRatio = middleInfluxRatio;
	}
	public String getSmallInfluxPrice() {
		return smallInfluxPrice;
	}
	public void setSmallInfluxPrice(String smallInfluxPrice) {
		this.smallInfluxPrice = smallInfluxPrice;
	}
	public String getSmallInfluxRatio() {
		return smallInfluxRatio;
	}
	public void setSmallInfluxRatio(String smallInfluxRatio) {
		this.smallInfluxRatio = smallInfluxRatio;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
