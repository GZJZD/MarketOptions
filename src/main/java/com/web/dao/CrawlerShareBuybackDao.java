package com.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.pojo.CrawlerShareBuyback;

public interface CrawlerShareBuybackDao {
	List<CrawlerShareBuyback> selectShareBuybackByParam(@Param("sharesCode") String code, @Param("sharesName") String name);
}
