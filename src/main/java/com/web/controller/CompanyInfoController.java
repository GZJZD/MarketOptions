package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.pojo.CrawlerBasicIndex;
import com.web.service.CrawlerBasicIndexService;


@Controller
@RequestMapping("/search")
public class CompanyInfoController{

	@Autowired
	private CrawlerBasicIndexService crawlerBaisicIndexService;

    @RequestMapping("getBasicIndex.Action")
    @ResponseBody
    public CrawlerBasicIndex getBasicIndex(String param){
    	if(param!=null && !"".equals(param)) {
    		String code = null;
        	String name = null;
        	try {
    			int num = Integer.parseInt(param);
    			code = num+"";
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
    
    
    
}
