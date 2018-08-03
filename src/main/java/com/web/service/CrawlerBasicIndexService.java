package com.web.service;

import java.util.List;

import com.web.pojo.CrawlerBasicIndex;

public interface CrawlerBasicIndexService {
	List<CrawlerBasicIndex> selectBasicIndexByParam(String code, String name);
}
