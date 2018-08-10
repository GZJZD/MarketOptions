package com.web.controller;

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
    	if(param!=null && !"".equals(param)) {
    		String code = null;
        	String name = null;
        	try {
        		Integer.parseInt(param);
    			code = param+"";
    		} catch (Exception e) {
    			name = param;
    		}
        	List<CrawlerMainInflux> crawlerMainInfluxList = crawlerMainInfluxService.selectMainInfluxByParam(code, name);
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
