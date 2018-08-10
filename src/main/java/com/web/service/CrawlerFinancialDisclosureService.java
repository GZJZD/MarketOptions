package com.web.service;

import java.util.List;

import com.web.pojo.CrawlerFinancialDisclosure;

public interface CrawlerFinancialDisclosureService {
	List<CrawlerFinancialDisclosure> selectFinancialDisclosureByParam(String code, String name);
}
