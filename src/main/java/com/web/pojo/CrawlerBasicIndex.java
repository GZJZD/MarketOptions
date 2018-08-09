package com.web.pojo;
/**
 * 基本指标
 * @author Administrator
 *
 */
public class CrawlerBasicIndex {
	//主键
	private Long id;
	//股票名称
	private String sharesName;
	//股票代码
	private String sharesCode;
	//最新价
	private String latestPrice;
	//涨跌幅
	private String riseFallRatio;
	//涨跌额
	private String riseFallPirce;
	//成交量（手）
	private String volumn;
	//成交额
	private String price;
	//最高价
	private String maxPrice;
	//最低价
	private String minprice;
	//今开价
	private String openPrice;
	//昨收价
	private String closePrice;
	//换手
	private String changeVolumn;
	//量比
	private String quantityRatio;
	//市盈率
	private String peRatio;
	//市净率
	private String pbRatio;
	//时间
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
	public String getLatestPrice() {
		return latestPrice;
	}
	public void setLatestPrice(String latestPrice) {
		this.latestPrice = latestPrice;
	}
	public String getRiseFallRatio() {
		return riseFallRatio;
	}
	public void setRiseFallRatio(String riseFallRatio) {
		this.riseFallRatio = riseFallRatio;
	}
	public String getRiseFallPirce() {
		return riseFallPirce;
	}
	public void setRiseFallPirce(String riseFallPirce) {
		this.riseFallPirce = riseFallPirce;
	}
	public String getVolumn() {
		return volumn;
	}
	public void setVolumn(String volumn) {
		this.volumn = volumn;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getMinprice() {
		return minprice;
	}
	public void setMinprice(String minprice) {
		this.minprice = minprice;
	}
	public String getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(String openPrice) {
		this.openPrice = openPrice;
	}
	public String getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(String closePrice) {
		this.closePrice = closePrice;
	}
	public String getChangeVolumn() {
		return changeVolumn;
	}
	public void setChangeVolumn(String changeVolumn) {
		this.changeVolumn = changeVolumn;
	}
	public String getQuantityRatio() {
		return quantityRatio;
	}
	public void setQuantityRatio(String quantityRatio) {
		this.quantityRatio = quantityRatio;
	}
	public String getPeRatio() {
		return peRatio;
	}
	public void setPeRatio(String peRatio) {
		this.peRatio = peRatio;
	}
	public String getPbRatio() {
		return pbRatio;
	}
	public void setPbRatio(String pbRatio) {
		this.pbRatio = pbRatio;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
