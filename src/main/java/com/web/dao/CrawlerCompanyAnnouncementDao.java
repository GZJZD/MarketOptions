package com.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.pojo.CrawlerCompanyAnnouncement;

public interface CrawlerCompanyAnnouncementDao {
	List<CrawlerCompanyAnnouncement> selectCompanyAnnounceByParam(@Param("sharesCode") String code, @Param("sharesName") String name);
}
