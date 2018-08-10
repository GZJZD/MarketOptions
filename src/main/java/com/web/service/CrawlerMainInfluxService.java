package com.web.service;

import java.util.List;

import com.web.pojo.CrawlerMainInflux;

public interface CrawlerMainInfluxService {
	List<CrawlerMainInflux> selectMainInfluxByParam(String code, String name);
}
