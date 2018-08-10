package com.web.service;

import java.util.List;

import com.web.pojo.CrawlerShareBuyback;

public interface CrawlerShareBuybackService {
	List<CrawlerShareBuyback> selectShareBuybackByParam(String code, String name);
}
