package com.web.service;

import java.util.List;

import com.web.pojo.CrawlerShareholders;

public interface CrawlerShareholdersService {
	List<CrawlerShareholders> selectShareholdersByParam(String code, String name);
}
