package com.web.service;

import java.util.List;

import com.web.pojo.CrawlerRestrictedCirculation;

public interface CrawlerRestrictedCirculationService {
	List<CrawlerRestrictedCirculation> selectRestrictedCirculationByParam(String code, String name);
}
