package com.web.pojo;

/*
* 股权质押
* */
public class CrawlerSharePledge {

    private Long id;
    private String sharesName; //股票名称
    private String sharesCode; //股票代码
    private String shareholdersName;//股东名称
    private String pledgeNumber;//最新质押笔数
    private String pledgeVolumn;//剩余质押股数(股)
    private String pledgePrice;//剩余质押股份市值(元)
    private String shareRatio;//占所持股份比例(%)
    private String equityDatio;//占总股本比例(%)
    private String closePositionRange;//平仓线区间(预估)
    private String warningPositionRange;//预警线区间(预估)
    private String updateDate;//更新日期



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

    public String getPledgeNumber() {
        return pledgeNumber;
    }

    public void setPledgeNumber(String pledgeNumber) {
        this.pledgeNumber = pledgeNumber;
    }

    public String getPledgeVolumn() {
        return pledgeVolumn;
    }

    public void setPledgeVolumn(String pledgeVolumn) {
        this.pledgeVolumn = pledgeVolumn;
    }

    public String getPledgePrice() {
        return pledgePrice;
    }

    public void setPledgePrice(String pledgePrice) {
        this.pledgePrice = pledgePrice;
    }

    public String getShareRatio() {
        return shareRatio;
    }

    public void setShareRatio(String shareRatio) {
        this.shareRatio = shareRatio;
    }

    public String getEquityDatio() {
        return equityDatio;
    }

    public void setEquityDatio(String equityDatio) {
        this.equityDatio = equityDatio;
    }

    public String getClosePositionRange() {
        return closePositionRange;
    }

    public void setClosePositionRange(String closePositionRange) {
        this.closePositionRange = closePositionRange;
    }

    public String getWarningPositionRange() {
        return warningPositionRange;
    }

    public void setWarningPositionRange(String warningPositionRange) {
        this.warningPositionRange = warningPositionRange;
    }
    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
