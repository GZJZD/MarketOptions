package com.web.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.pojo.CrawlerBasicIndex;
import com.web.pojo.CrawlerCompanyAnnouncement;
import com.web.pojo.CrawlerCompanyNews;
import com.web.pojo.CrawlerFinancialDisclosure;
import com.web.pojo.CrawlerMainInflux;
import com.web.pojo.CrawlerRestrictedCirculation;
import com.web.pojo.CrawlerShareBuyback;
import com.web.pojo.CrawlerSharePledge;
import com.web.pojo.CrawlerShareholders;
import com.web.service.CrawlerBasicIndexService;
import com.web.service.CrawlerCompanyAnnouncementService;
import com.web.service.CrawlerCompanyNewsService;
import com.web.service.CrawlerFinancialDisclosureService;
import com.web.service.CrawlerMainInfluxService;
import com.web.service.CrawlerRestrictedCirculationService;
import com.web.service.CrawlerShareBuybackService;
import com.web.service.CrawlerSharePledgeService;
import com.web.service.CrawlerShareholdersService;


@Controller
@RequestMapping("/search")
public class CompanyInfoController{
	@Autowired
	private CrawlerBasicIndexService crawlerBaisicIndexService;
	@Autowired
	private CrawlerCompanyAnnouncementService crawlerCompanyAnnouncementService;
	@Autowired
	private CrawlerCompanyNewsService crawlerCompanyNewsService;
	@Autowired
	private CrawlerFinancialDisclosureService crawlerFinancialDisclosureService;
	@Autowired
	private CrawlerMainInfluxService crawlerMainInfluxService;
	@Autowired
	private CrawlerRestrictedCirculationService crawlerRestrictedCirculationService;
	@Autowired
	private CrawlerShareBuybackService crawlerShareBuybackService;
	@Autowired
	private CrawlerShareholdersService crawlerShareholdersService;
	@Autowired
	private CrawlerSharePledgeService crawlerSharePledgeService;

	//基本指标
    @RequestMapping("getBasicIndex.Action")
    @ResponseBody
    public CrawlerBasicIndex getBasicIndex(String param){
    	if(param!=null && !"".equals(param)) {
    		String code = null;
        	String name = null;
        	try {
    			Integer.parseInt(param);
    			code = param+"";
    		} catch (Exception e) {
    			name = param;
    		}
        	List<CrawlerBasicIndex> crawlerBaisicIndexList = crawlerBaisicIndexService.selectBasicIndexByParam(code, name);
        	CrawlerBasicIndex crawlerBaisicIndex = new CrawlerBasicIndex();
        	if(!crawlerBaisicIndexList.isEmpty()) {
        		crawlerBaisicIndex = crawlerBaisicIndexList.get(0);
        	}
        	return crawlerBaisicIndex;
    	}
    	return null;
    }
    
    //主力流入
    @RequestMapping("getMainInflux.Action")
    @ResponseBody
    public List<CrawlerMainInflux> getMainInflux(String param) {
    	 DecimalFormat df = new DecimalFormat("#0.00");
    	if(param!=null && !"".equals(param)) {
    		String code = null;
        	String name = null;
        	try {
        		Integer.parseInt(param);
    			code = param+"";
    		} catch
        	(Exception e) {
    			name = param;
    		}
        	Double mainInfluxPrice = 0.0;Double mainInfluxPriceTotal = 0.0;
        	Double hugeInfluxPrice = 0.0;Double hugeInfluxPriceTotal = 0.0;
        	Double largeInfluxPrice = 0.0;Double largeInfluxPriceTotal = 0.0;
        	Double middleInfluxPrice = 0.0;Double middleInfluxPriceTotal = 0.0;
        	Double smallInfluxPrice = 0.0;Double smallInfluxPriceTotal = 0.0;
        	List<CrawlerMainInflux> crawlerMainInfluxList = crawlerMainInfluxService.selectMainInfluxByParam(code, name);
        	for(int i=0; i<crawlerMainInfluxList.size(); i++) {
        		if(i==30) {
        			break;
        		}
        		//主力流入净值
        		mainInfluxPrice=mainInfluxPrice+Double.parseDouble(crawlerMainInfluxList.get(i).getMainInfluxPrice());
        		if(!crawlerMainInfluxList.get(i).getMainInfluxRatio().equals("-") && !crawlerMainInfluxList.get(i).getMainInfluxRatio().equals("0%")) {
        			mainInfluxPriceTotal=mainInfluxPriceTotal+Double.parseDouble(crawlerMainInfluxList.get(i).getMainInfluxPrice())/Double.parseDouble(crawlerMainInfluxList.get(i).getMainInfluxRatio().substring(0,crawlerMainInfluxList.get(i).getMainInfluxRatio().length()-1))*100;
        		}
        		//超大单流入净值
        		hugeInfluxPrice=hugeInfluxPrice+Double.parseDouble(crawlerMainInfluxList.get(i).getHugeInfluxPrice());
        		if(!crawlerMainInfluxList.get(i).getHugeInfluxRatio().equals("-") && !crawlerMainInfluxList.get(i).getHugeInfluxRatio().equals("0%")) {
        			hugeInfluxPriceTotal=hugeInfluxPriceTotal+Double.parseDouble(crawlerMainInfluxList.get(i).getHugeInfluxPrice())/Double.parseDouble(crawlerMainInfluxList.get(i).getHugeInfluxRatio().substring(0,crawlerMainInfluxList.get(i).getHugeInfluxRatio().length()-1))*100;
        		}
        		//大单流入净值
        		largeInfluxPrice=largeInfluxPrice+Double.parseDouble(crawlerMainInfluxList.get(i).getLargeInfluxPrice());
        		if(!crawlerMainInfluxList.get(i).getLargeInfluxRatio().equals("-") && !crawlerMainInfluxList.get(i).getLargeInfluxRatio().equals("0%")) {
        			largeInfluxPriceTotal=largeInfluxPriceTotal+Double.parseDouble(crawlerMainInfluxList.get(i).getLargeInfluxPrice())/Double.parseDouble(crawlerMainInfluxList.get(i).getLargeInfluxRatio().substring(0,crawlerMainInfluxList.get(i).getLargeInfluxRatio().length()-1))*100;
        		}
        		//中单流入净值
        		middleInfluxPrice=middleInfluxPrice+Double.parseDouble(crawlerMainInfluxList.get(i).getMiddleInfluxPrice());
        		if(!crawlerMainInfluxList.get(i).getMiddleInfluxRatio().equals("-") && !crawlerMainInfluxList.get(i).getMiddleInfluxRatio().equals("0%")) {
        			middleInfluxPriceTotal=middleInfluxPriceTotal+Double.parseDouble(crawlerMainInfluxList.get(i).getMiddleInfluxPrice())/Double.parseDouble(crawlerMainInfluxList.get(i).getMiddleInfluxRatio().substring(0,crawlerMainInfluxList.get(i).getMiddleInfluxRatio().length()-1))*100;
        		}
        		//小单流入净值
        		smallInfluxPrice=smallInfluxPrice+Double.parseDouble(crawlerMainInfluxList.get(i).getSmallInfluxPrice());
        		if(!crawlerMainInfluxList.get(i).getSmallInfluxRatio().equals("-") && !crawlerMainInfluxList.get(i).getSmallInfluxRatio().equals("0%")) {
        			smallInfluxPriceTotal=smallInfluxPriceTotal+Double.parseDouble(crawlerMainInfluxList.get(i).getSmallInfluxPrice())/Double.parseDouble(crawlerMainInfluxList.get(i).getSmallInfluxRatio().substring(0,crawlerMainInfluxList.get(i).getSmallInfluxRatio().length()-1))*100;
        		}
        	}
        	CrawlerMainInflux crawlerMainInflux = new CrawlerMainInflux();
        	crawlerMainInflux.setDate("合计");
        	crawlerMainInflux.setMainInfluxPrice(df.format(mainInfluxPrice));
        	crawlerMainInflux.setMainInfluxRatio(df.format(mainInfluxPrice/mainInfluxPriceTotal*100)+"%");
        	crawlerMainInflux.setHugeInfluxPrice(df.format(hugeInfluxPrice));
        	crawlerMainInflux.setHugeInfluxRatio(df.format(hugeInfluxPrice/hugeInfluxPriceTotal*100)+"%");
        	crawlerMainInflux.setLargeInfluxPrice(df.format(largeInfluxPrice));
        	crawlerMainInflux.setLargeInfluxRatio(df.format(largeInfluxPrice/largeInfluxPriceTotal*100)+"%");
        	crawlerMainInflux.setMiddleInfluxPrice(df.format(middleInfluxPrice));
        	crawlerMainInflux.setMiddleInfluxRatio(df.format(middleInfluxPrice/middleInfluxPriceTotal*100)+"%");
        	crawlerMainInflux.setSmallInfluxPrice(df.format(smallInfluxPrice));
        	crawlerMainInflux.setSmallInfluxRatio(df.format(smallInfluxPrice/smallInfluxPriceTotal*100)+"%");
        	crawlerMainInfluxList.add(0, crawlerMainInflux);
        	crawlerMainInfluxList = crawlerMainInfluxList.subList(0, 30);
        	return crawlerMainInfluxList;
    	}
    	return null;
    }
    
    //财报披露
    @RequestMapping("getFinancialDisclosure.Action")
    @ResponseBody
    public List<CrawlerFinancialDisclosure> getFinancialDisclosure(String param) {
    	if(param!=null && !"".equals(param)) {
    		String code = null;
        	String name = null;
        	try {
        		Integer.parseInt(param);
    			code = param+"";
    		} catch (Exception e) {
    			name = param;
    		}
        	List<CrawlerFinancialDisclosure> crawlerFinancialDisclosureList = crawlerFinancialDisclosureService.selectFinancialDisclosureByParam(code, name);
        	return crawlerFinancialDisclosureList;
    	}
    	return null;
    }
    
    //股东增减持
    @RequestMapping("getShareholders.Action")
    @ResponseBody
    public List<CrawlerShareholders> getShareholders(String param) {
    	if(param!=null && !"".equals(param)) {
    		String code = null;
        	String name = null;
        	try {
        		Integer.parseInt(param);
    			code = param+"";
    		} catch (Exception e) {
    			name = param;
    		}
        	List<CrawlerShareholders> crawlerShareholdersList = crawlerShareholdersService.selectShareholdersByParam(code, name);
        	return crawlerShareholdersList;
    	}
    	return null;
    }

    //股票回购
    @RequestMapping("getShareBuyback.Action")
    @ResponseBody
    public List<CrawlerShareBuyback> getShareBuyback(String param) {
    	if(param!=null && !"".equals(param)) {
    		String code = null;
        	String name = null;
        	try {
        		Integer.parseInt(param);
    			code = param+"";
    		} catch (Exception e) {
    			name = param;
    		}
        	List<CrawlerShareBuyback> crawlerShareBuybackList = crawlerShareBuybackService.selectShareBuybackByParam(code, name);
        	return crawlerShareBuybackList;
    	}
    	return null;
    }
    
    //股权质押
    @RequestMapping("getSharePledge.Action")
    @ResponseBody
    public List<CrawlerSharePledge> getSharePledge(String param) {
    	if(param!=null && !"".equals(param)) {
    		String code = null;
        	String name = null;
        	try {
        		Integer.parseInt(param);
    			code = param+"";
    		} catch (Exception e) {
    			name = param;
    		}
        	List<CrawlerSharePledge> crawlerSharePledgeList = crawlerSharePledgeService.selectSharePledgeByParam(code, name);
        	return crawlerSharePledgeList;
    	}
    	return null;
    }
    
    //限售解禁
    @RequestMapping("getRestrictedCirculation.Action")
    @ResponseBody
    public List<CrawlerRestrictedCirculation> getRestrictedCirculation(String param) {
    	if(param!=null && !"".equals(param)) {
    		String code = null;
        	String name = null;
        	try {
        		Integer.parseInt(param);
    			code = param+"";
    		} catch (Exception e) {
    			name = param;
    		}
        	List<CrawlerRestrictedCirculation> crawlerRestrictedCirculationList = crawlerRestrictedCirculationService.selectRestrictedCirculationByParam(code, name);
        	return crawlerRestrictedCirculationList;
    	}
    	return null;
    }
    
    //公司公告
    @RequestMapping("getCompanyAnnounce.Action")
    @ResponseBody
    public List<CrawlerCompanyAnnouncement> getCompanyAnnounce(String param) {
    	if(param!=null && !"".equals(param)) {
    		String code = null;
        	String name = null;
        	try {
        		Integer.parseInt(param);
    			code = param+"";
    		} catch (Exception e) {
    			name = param;
    		}
        	List<CrawlerCompanyAnnouncement> crawlerCompanyAnnounceList = crawlerCompanyAnnouncementService.selectCompanyAnnounceByParam(code, name);
        	return crawlerCompanyAnnounceList;
    	}
    	return null;
    }
    
    //公司新闻
    @RequestMapping("getCompanyNews.Action")
    @ResponseBody
    public List<CrawlerCompanyNews> getCompanyNews(String param) {
    	if(param!=null && !"".equals(param)) {
    		String code = null;
        	String name = null;
        	try {
        		Integer.parseInt(param);
    			code = param+"";
    		} catch (Exception e) {
    			name = param;
    		}
        	List<CrawlerCompanyNews> crawlerCompanyNewsList = crawlerCompanyNewsService.selectCompanyNewsByParam(code, name);
        	return crawlerCompanyNewsList;
    	}
    	return null;
    }

}
