package com.web.dao;

import java.util.List;

import com.web.pojo.CrawlerBasicIndex;

public interface CrawlerBasicIndexDao {
	List<CrawlerBasicIndex> selectBasicIndexByParam(String code, String name);
}
