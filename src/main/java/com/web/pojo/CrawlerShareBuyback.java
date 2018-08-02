package com.web.pojo;

/*
* 股票回购
* */
public class CrawlerShareBuyback {
    private Long id;
    private String sharesName; //股票名称
    private String sharesCode; //股票代码
    private String buybackPriceRange; //回购价格区间
    private String closePrice; //公告日前一日收盘价
    private String buybackVolumnRange;//回购数量区间(股)
    private String shareRatio;//占公告前一日流通股份比例(%)
    private String equityRatio;//占公告前一日总股本比例(%)
    private String buybackAmountRange;//回购金额区间(元)
    private String beginDate;//回购起始时间
    private String implProgress;//实施进度
    private String announcementDate;//公告日期

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

    public String getBuybackPriceRange() {
        return buybackPriceRange;
    }

    public void setBuybackPriceRange(String buybackPriceRange) {
        this.buybackPriceRange = buybackPriceRange;
    }

    public String getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(String closePrice) {
        this.closePrice = closePrice;
    }

    public String getBuybackVolumnRange() {
        return buybackVolumnRange;
    }

    public void setBuybackVolumnRange(String buybackVolumnRange) {
        this.buybackVolumnRange = buybackVolumnRange;
    }

    public String getShareRatio() {
        return shareRatio;
    }

    public void setShareRatio(String shareRatio) {
        this.shareRatio = shareRatio;
    }

    public String getEquityRatio() {
        return equityRatio;
    }

    public void setEquityRatio(String equityRatio) {
        this.equityRatio = equityRatio;
    }

    public String getBuybackAmountRange() {
        return buybackAmountRange;
    }

    public void setBuybackAmountRange(String buybackAmountRange) {
        this.buybackAmountRange = buybackAmountRange;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getImplProgress() {
        return implProgress;
    }

    public void setImplProgress(String implProgress) {
        this.implProgress = implProgress;
    }

    public String getAnnouncementDate() {
        return announcementDate;
    }

    public void setAnnouncementDate(String announcementDate) {
        this.announcementDate = announcementDate;
    }
}
