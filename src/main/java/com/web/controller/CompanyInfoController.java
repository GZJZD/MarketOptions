package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.web.pojo.CrawlerBasicIndex;
import com.web.service.CrawlerBasicIndexService;
import com.web.util.json.JSONResult;

@Controller
@RequestMapping("/search")
public class CompanyInfoController{

	@Autowired
	private CrawlerBasicIndexService crawlerBaisicIndexService;

    @RequestMapping("companyInfo.Action")
    public String getList(String param,ModelMap model){
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
    	}else {
    		model.addAttribute("error","没有该公司数据");
    		return "Options_Function_Companys";
    	}
    	model.addAttribute("crawlerBaisicIndex",crawlerBaisicIndex);
    	return "Options_Function_CompanysInfos";
    }

}
