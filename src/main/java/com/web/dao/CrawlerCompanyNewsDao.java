package com.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.pojo.CrawlerCompanyNews;

public interface CrawlerCompanyNewsDao {
	List<CrawlerCompanyNews> selectCompanyNewsByParam(@Param("sharesCode") String code, @Param("sharesName") String name);
}
