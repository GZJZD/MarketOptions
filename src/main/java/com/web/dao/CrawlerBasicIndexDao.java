package com.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.pojo.CrawlerBasicIndex;

public interface CrawlerBasicIndexDao {
	List<CrawlerBasicIndex> selectBasicIndexByParam(@Param("sharesCode") String code, @Param("sharesName") String name);
}
