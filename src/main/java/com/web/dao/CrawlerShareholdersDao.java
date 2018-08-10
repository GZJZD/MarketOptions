package com.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.pojo.CrawlerShareholders;

public interface CrawlerShareholdersDao {
	List<CrawlerShareholders> selectShareholdersByParam(@Param("sharesCode") String code, @Param("sharesName") String name);
}
