package com.web.pojo;

/*
* 股票回购
* */
public class CrawlerShareBuyback {
    private Long id;
    private String sharesName; //股票名称
    private String sharesCode; //股票代码
    //回购价格区间
    private String buybackPriceRangeLeft;
    private String buybackPriceRangeRight; 
    private String closePrice; //公告日前一日收盘价
    //回购数量区间(股)
    private String buybackVolumnRangeLeft;
    private String buybackVolumnRangeRight;
    //占公告前一日流通股份比例(%)
    private String shareRatioLeft;
    private String shareRatioRight;
    //占公告前一日总股本比例(%)
    private String equityRatioLeft;
    private String equityRatioRight;
    //回购金额区间(元)
    private String buybackAmountRangeLeft;
    private String buybackAmountRangeRight;
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

    public String getBuybackPriceRangeLeft() {
		return buybackPriceRangeLeft;
	}

	public void setBuybackPriceRangeLeft(String buybackPriceRangeLeft) {
		this.buybackPriceRangeLeft = buybackPriceRangeLeft;
	}

	public String getBuybackPriceRangeRight() {
		return buybackPriceRangeRight;
	}

	public void setBuybackPriceRangeRight(String buybackPriceRangeRight) {
		this.buybackPriceRangeRight = buybackPriceRangeRight;
	}

	public String getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(String closePrice) {
        this.closePrice = closePrice;
    }

    public String getBuybackVolumnRangeLeft() {
		return buybackVolumnRangeLeft;
	}

	public void setBuybackVolumnRangeLeft(String buybackVolumnRangeLeft) {
		this.buybackVolumnRangeLeft = buybackVolumnRangeLeft;
	}

	public String getBuybackVolumnRangeRight() {
		return buybackVolumnRangeRight;
	}

	public void setBuybackVolumnRangeRight(String buybackVolumnRangeRight) {
		this.buybackVolumnRangeRight = buybackVolumnRangeRight;
	}

	public String getShareRatioLeft() {
		return shareRatioLeft;
	}

	public void setShareRatioLeft(String shareRatioLeft) {
		this.shareRatioLeft = shareRatioLeft;
	}

	public String getShareRatioRight() {
		return shareRatioRight;
	}

	public void setShareRatioRight(String shareRatioRight) {
		this.shareRatioRight = shareRatioRight;
	}

	public String getEquityRatioLeft() {
		return equityRatioLeft;
	}

	public void setEquityRatioLeft(String equityRatioLeft) {
		this.equityRatioLeft = equityRatioLeft;
	}

	public String getEquityRatioRight() {
		return equityRatioRight;
	}

	public void setEquityRatioRight(String equityRatioRight) {
		this.equityRatioRight = equityRatioRight;
	}

	public String getBuybackAmountRangeLeft() {
		return buybackAmountRangeLeft;
	}

	public void setBuybackAmountRangeLeft(String buybackAmountRangeLeft) {
		this.buybackAmountRangeLeft = buybackAmountRangeLeft;
	}

	public String getBuybackAmountRangeRight() {
		return buybackAmountRangeRight;
	}

	public void setBuybackAmountRangeRight(String buybackAmountRangeRight) {
		this.buybackAmountRangeRight = buybackAmountRangeRight;
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
