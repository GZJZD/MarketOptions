/*
Navicat MySQL Data Transfer

Source Server         : 47.52.77.50
Source Server Version : 50639
Source Host           : 47.52.77.50:3306
Source Database       : options

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-09-04 14:42:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for crawler_basic_index
-- ----------------------------
DROP TABLE IF EXISTS `crawler_basic_index`;
CREATE TABLE `crawler_basic_index` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shares_name` varchar(45) DEFAULT NULL COMMENT '股票名字',
  `shares_code` varchar(45) CHARACTER SET latin1 NOT NULL COMMENT '股票代码',
  `shares_type` varchar(8) DEFAULT NULL COMMENT '股票机构类型',
  `latest_price` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '最新价',
  `rise_fall_ratio` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '涨跌幅',
  `rise_fall_price` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '涨跌额',
  `volumn` varchar(45) DEFAULT NULL COMMENT '成交量（手）',
  `price` varchar(45) DEFAULT NULL COMMENT '成交额',
  `max_price` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '最高价',
  `min_pirce` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '最低价',
  `open_price` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '今开价',
  `close_price` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '昨收价',
  `change_volumn` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '换手',
  `quantity_ratio` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '量比',
  `pe_ratio` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '市盈率',
  `pb_ratio` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '市净率',
  `date` varchar(45) NOT NULL COMMENT '时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shares_code` (`shares_code`,`date`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=5891293 DEFAULT CHARSET=utf8 COMMENT='基本指标';

-- ----------------------------
-- Table structure for crawler_company_announcement
-- ----------------------------
DROP TABLE IF EXISTS `crawler_company_announcement`;
CREATE TABLE `crawler_company_announcement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shares_name` varchar(45) DEFAULT NULL COMMENT '股票名称',
  `shares_code` varchar(45) DEFAULT NULL COMMENT '股票代码',
  `announce_title` text COMMENT '公告标题',
  `announce_url` text COMMENT '公告地址',
  `announce_type` varchar(45) DEFAULT NULL COMMENT '公告类型',
  `announce_date` varchar(45) DEFAULT NULL COMMENT '公告日期',
  `announce_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `shares_code` (`shares_code`,`announce_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6531709 DEFAULT CHARSET=utf8 COMMENT='公司公告';

-- ----------------------------
-- Table structure for crawler_company_news
-- ----------------------------
DROP TABLE IF EXISTS `crawler_company_news`;
CREATE TABLE `crawler_company_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shares_name` varchar(45) DEFAULT NULL COMMENT '股票名称',
  `shares_code` varchar(45) DEFAULT NULL COMMENT '股票代码',
  `news_title` text COMMENT '新闻标题',
  `news_url` text COMMENT '新闻地址',
  `news_id` int(11) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shares_code` (`shares_code`,`news_id`)
) ENGINE=InnoDB AUTO_INCREMENT=134605 DEFAULT CHARSET=utf8 COMMENT='公司新闻';

-- ----------------------------
-- Table structure for crawler_financial_disclosure
-- ----------------------------
DROP TABLE IF EXISTS `crawler_financial_disclosure`;
CREATE TABLE `crawler_financial_disclosure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shares_code` varchar(48) DEFAULT NULL,
  `shares_name` varchar(48) DEFAULT NULL,
  `performance_change` text,
  `expected_net_profit_left` varchar(48) DEFAULT NULL,
  `expected_net_profit_right` varchar(48) DEFAULT NULL,
  `performance_change_ratio_left` text,
  `performance_change_ratio_right` varchar(48) DEFAULT NULL,
  `performance_change_reason` text,
  `preview_type` varchar(48) DEFAULT NULL,
  `previous_year_profit` varchar(48) DEFAULT NULL,
  `announcement_date` varchar(48) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `shares_code` (`shares_code`,`announcement_date`)
) ENGINE=InnoDB AUTO_INCREMENT=64455 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for crawler_main_influx
-- ----------------------------
DROP TABLE IF EXISTS `crawler_main_influx`;
CREATE TABLE `crawler_main_influx` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shares_name` varchar(45) DEFAULT NULL COMMENT '股票名称',
  `shares_code` varchar(45) NOT NULL COMMENT '股票代码',
  `main_influx_price` varchar(45) DEFAULT NULL COMMENT '主力净流入净额',
  `main_influx_ratio` varchar(45) DEFAULT NULL COMMENT '主力净流入净占比',
  `huge_influx_price` varchar(45) DEFAULT NULL COMMENT '超大单净流入净额',
  `huge_influx_ratio` varchar(45) DEFAULT NULL COMMENT '超大单净流入净占比',
  `large_influx_price` varchar(45) DEFAULT NULL COMMENT '大单净流入净额',
  `large_influx_ratio` varchar(45) DEFAULT NULL COMMENT '大单净流入净占比',
  `middle_influx_price` varchar(45) DEFAULT NULL COMMENT '中单净流入净额',
  `middle_influx_ratio` varchar(45) DEFAULT NULL COMMENT '中单净流入净占比',
  `small_influx_price` varchar(45) DEFAULT NULL COMMENT '小单净流入净额',
  `small_influx_ratio` varchar(45) DEFAULT NULL COMMENT '小单净流入净占比',
  `date` varchar(45) NOT NULL COMMENT '日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shares_code` (`shares_code`,`date`)
) ENGINE=InnoDB AUTO_INCREMENT=98034049 DEFAULT CHARSET=utf8 COMMENT='主力流入';

-- ----------------------------
-- Table structure for crawler_restricted_circulation
-- ----------------------------
DROP TABLE IF EXISTS `crawler_restricted_circulation`;
CREATE TABLE `crawler_restricted_circulation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shares_name` varchar(45) DEFAULT NULL COMMENT '股票名字',
  `shares_code` varchar(45) DEFAULT NULL COMMENT '股票代码',
  `circulation_date` varchar(45) DEFAULT NULL COMMENT '解禁时间',
  `shareholders_num` varchar(45) DEFAULT NULL COMMENT '解禁股东数',
  `share_num` varchar(45) DEFAULT NULL COMMENT '解禁数量(股)',
  `real_share_num` varchar(45) DEFAULT NULL COMMENT '实际解禁数量(股)',
  `non_share_num` varchar(45) DEFAULT NULL COMMENT '未解禁数量(股)',
  `real_share_price` varchar(45) DEFAULT NULL COMMENT '实际解禁市值(元)	',
  `equity_ratio` varchar(45) DEFAULT NULL COMMENT '占总市值比例(%)',
  `share_ratio` varchar(45) DEFAULT NULL COMMENT '占流通市值比例(%)',
  `close_price` varchar(45) DEFAULT NULL COMMENT '解禁前一日收盘价(元)',
  `share_type` varchar(45) DEFAULT NULL COMMENT '限售股类型',
  `before_range` varchar(45) DEFAULT NULL COMMENT '解禁前20日涨跌幅(%)',
  `after_range` varchar(45) DEFAULT NULL COMMENT '解禁后20日涨跌幅(%)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shares_code` (`shares_code`,`circulation_date`)
) ENGINE=InnoDB AUTO_INCREMENT=2158888 DEFAULT CHARSET=utf8 COMMENT='限售解禁';

-- ----------------------------
-- Table structure for crawler_share_buyback
-- ----------------------------
DROP TABLE IF EXISTS `crawler_share_buyback`;
CREATE TABLE `crawler_share_buyback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shares_name` varchar(45) DEFAULT NULL COMMENT '股票名称',
  `shares_code` varchar(45) DEFAULT NULL COMMENT '股票代码',
  `buyback_price_range_left` varchar(45) DEFAULT NULL COMMENT '回购价格区间',
  `buyback_price_range_right` varchar(45) DEFAULT NULL,
  `close_price` varchar(45) DEFAULT NULL COMMENT '公告日前一日收盘价',
  `buyback_volumn_range_left` varchar(45) DEFAULT NULL COMMENT '回购数量区间(股)',
  `buyback_volumn_range_right` varchar(45) DEFAULT NULL,
  `share_ratio_left` varchar(45) DEFAULT NULL COMMENT '占公告前一日流通股份比例(%)',
  `share_ratio_right` varchar(45) DEFAULT NULL,
  `equity_ratio_left` varchar(45) DEFAULT NULL COMMENT '占公告前一日总股本比例(%)',
  `equity_ratio_right` varchar(45) DEFAULT NULL,
  `buyback_amount_range_left` varchar(45) DEFAULT NULL COMMENT '回购金额区间(元)',
  `buyback_amount_range_right` varchar(45) DEFAULT NULL,
  `begin_date` varchar(45) DEFAULT NULL COMMENT '回购起始时间',
  `impl_progress` varchar(45) DEFAULT NULL COMMENT '实施进度',
  `announcement_date` varchar(45) NOT NULL COMMENT '公告日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shares_code` (`shares_code`,`announcement_date`)
) ENGINE=InnoDB AUTO_INCREMENT=73372 DEFAULT CHARSET=utf8 COMMENT='股票回购';

-- ----------------------------
-- Table structure for crawler_share_pledge
-- ----------------------------
DROP TABLE IF EXISTS `crawler_share_pledge`;
CREATE TABLE `crawler_share_pledge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shares_name` varchar(45) DEFAULT NULL COMMENT '股票名称',
  `shares_code` varchar(45) DEFAULT NULL COMMENT '股票代码',
  `shareholders_name` varchar(45) DEFAULT NULL COMMENT '股东名称',
  `pledge_number` varchar(45) DEFAULT NULL COMMENT '最新质押笔数',
  `pledge_volumn` varchar(45) DEFAULT NULL COMMENT '剩余质押股数(股)',
  `pledge_price` varchar(45) DEFAULT NULL COMMENT '剩余质押股份市值(元)',
  `share_ratio` varchar(45) DEFAULT NULL COMMENT '占所持股份比例(%)',
  `equity_datio` varchar(45) DEFAULT NULL COMMENT '占总股本比例(%)',
  `close_position_range_left` varchar(45) DEFAULT NULL COMMENT '平仓线区间(预估)	',
  `close_position_range_right` varchar(45) DEFAULT NULL,
  `warning_position_range_left` varchar(45) DEFAULT NULL COMMENT '预警线区间(预估)',
  `warning_position_range_right` varchar(45) DEFAULT NULL,
  `update_date` varchar(45) DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shares_code` (`shares_code`,`update_date`)
) ENGINE=InnoDB AUTO_INCREMENT=620949 DEFAULT CHARSET=utf8 COMMENT='股权质押';

-- ----------------------------
-- Table structure for crawler_shareholders
-- ----------------------------
DROP TABLE IF EXISTS `crawler_shareholders`;
CREATE TABLE `crawler_shareholders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shares_name` varchar(45) DEFAULT NULL COMMENT '股票名称',
  `shares_code` varchar(45) NOT NULL COMMENT '股票代码',
  `shareholders_name` varchar(1024) DEFAULT NULL COMMENT '股东名称',
  `change_type` varchar(45) DEFAULT NULL COMMENT '增减',
  `change_share` varchar(45) DEFAULT NULL COMMENT '变动数量(万股)',
  `change_equity_ratio` varchar(45) DEFAULT NULL COMMENT '变动占总股本比例(%)',
  `change_share_ratio` varchar(45) DEFAULT NULL COMMENT '变动占流通股比例(%)',
  `total_hold` varchar(45) DEFAULT NULL COMMENT '持股总数(万股)',
  `total_equity_ratio` varchar(45) DEFAULT NULL COMMENT '占总股本比例(%)',
  `total_share` varchar(45) DEFAULT NULL COMMENT '持流通股数(万股)',
  `total_share_ratio` varchar(45) DEFAULT NULL COMMENT '占流通股比例(%)',
  `begin_date` varchar(45) DEFAULT NULL COMMENT '变动开始日',
  `end_date` varchar(45) DEFAULT NULL COMMENT '变动截止日',
  `announcement_date` varchar(45) NOT NULL COMMENT '公告日期',
  PRIMARY KEY (`id`),
  UNIQUE KEY `shares_code` (`shares_code`,`announcement_date`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5163708 DEFAULT CHARSET=utf8 COMMENT='股东增减持';
