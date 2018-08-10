package com.web.service;

import java.util.List;

import com.web.pojo.CrawlerSharePledge;

public interface CrawlerSharePledgeService {
	List<CrawlerSharePledge> selectSharePledgeByParam(String code, String name);
}
