package com.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.pojo.CrawlerFinancialDisclosure;

public interface CrawlerFinancialDisclosureDao {
	List<CrawlerFinancialDisclosure> selectFinancialDisclosureByParam(@Param("sharesCode") String code, @Param("sharesName") String name);
}
