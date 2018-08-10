package com.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.pojo.CrawlerRestrictedCirculation;

public interface CrawlerRestrictedCirculationDao {
	List<CrawlerRestrictedCirculation> selectRestrictedCirculationByParam(@Param("sharesCode") String code, @Param("sharesName") String name);
}
