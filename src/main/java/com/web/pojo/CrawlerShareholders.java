package com.web.pojo;

/*
*股东增减持
* */
public class CrawlerShareholders {
    private Long id;
    private String sharesName;//股票名称
    private String sharesCode;//股票代码
    private String shareholdersName;//股东名称
    private String changeType;//增减
    private String changeShare;//变动数量(万股)
    private String changeEquityRatio;//变动占总股本比例(%)
    private String changeShareRatio;//变动占流通股比例(%)
    private String totalHold;//持股总数(万股)
    private String totalEquityRatio;//占总股本比例(%)
    private String totalShare;//持流通股数(万股)
    private String totalShareRatio;//占流通股比例(%)
    private String beginDate;//变动开始日
    private String endDate;//变动截止日
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

    public String getShareholdersName() {
        return shareholdersName;
    }

    public void setShareholdersName(String shareholdersName) {
        this.shareholdersName = shareholdersName;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getChangeShare() {
        return changeShare;
    }

    public void setChangeShare(String changeShare) {
        this.changeShare = changeShare;
    }

    public String getChangeEquityRatio() {
        return changeEquityRatio;
    }

    public void setChangeEquityRatio(String changeEquityRatio) {
        this.changeEquityRatio = changeEquityRatio;
    }

    public String getChangeShareRatio() {
        return changeShareRatio;
    }

    public void setChangeShareRatio(String changeShareRatio) {
        this.changeShareRatio = changeShareRatio;
    }

    public String getTotalHold() {
        return totalHold;
    }

    public void setTotalHold(String totalHold) {
        this.totalHold = totalHold;
    }

    public String getTotalEquityRatio() {
        return totalEquityRatio;
    }

    public void setTotalEquityRatio(String totalEquityRatio) {
        this.totalEquityRatio = totalEquityRatio;
    }

    public String getTotalShare() {
        return totalShare;
    }

    public void setTotalShare(String totalShare) {
        this.totalShare = totalShare;
    }

    public String getTotalShareRatio() {
        return totalShareRatio;
    }

    public void setTotalShareRatio(String totalShareRatio) {
        this.totalShareRatio = totalShareRatio;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAnnouncementDate() {
        return announcementDate;
    }

    public void setAnnouncementDate(String announcementDate) {
        this.announcementDate = announcementDate;
    }
}
