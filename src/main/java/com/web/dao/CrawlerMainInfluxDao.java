package com.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.pojo.CrawlerMainInflux;

public interface CrawlerMainInfluxDao {
	List<CrawlerMainInflux> selectMainInfluxByParam(@Param("sharesCode") String code, @Param("sharesName") String name);
}
