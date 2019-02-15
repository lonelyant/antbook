/*
Navicat MySQL Data Transfer

Source Server         : MySQL_localtest
Source Server Version : 50170
Source Host           : localhost:3306
Source Database       : antbook

Target Server Type    : MYSQL
Target Server Version : 50170
File Encoding         : 65001

Date: 2019-02-15 19:29:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for balance
-- ----------------------------
DROP TABLE IF EXISTS `balance`;
CREATE TABLE `balance` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) NOT NULL,
  `book_id` int(5) NOT NULL,
  `balance` double(10,2) NOT NULL,
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) NOT NULL,
  `descript` varchar(255) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `creater` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for invite_msg
-- ----------------------------
DROP TABLE IF EXISTS `invite_msg`;
CREATE TABLE `invite_msg` (
  `invite_id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `from` varchar(32) DEFAULT NULL,
  `from_name` varchar(255) DEFAULT NULL,
  `owner` varchar(32) DEFAULT NULL,
  `owner_name` varchar(255) DEFAULT NULL,
  `book_id` int(5) DEFAULT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '0-等待处理 1-已接受 2-已拒绝',
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`invite_id`)
) ENGINE=MyISAM AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `record_id` int(8) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `book_id` int(5) DEFAULT NULL COMMENT '该记录所属的账本',
  `status` int(1) DEFAULT NULL COMMENT '1-待其他人确认 2-所有人已确认 3-被拒绝 4-已删除',
  `pname` varchar(255) DEFAULT NULL COMMENT '商品名',
  `price` double(10,2) DEFAULT NULL,
  `category` int(2) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  `creater` varchar(32) NOT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `confirmtime` timestamp NULL DEFAULT NULL,
  `deletetime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for record_confirm_detail
-- ----------------------------
DROP TABLE IF EXISTS `record_confirm_detail`;
CREATE TABLE `record_confirm_detail` (
  `record_id` int(8) NOT NULL,
  `confirm_user` varchar(255) DEFAULT NULL,
  `refuse_user` varchar(255) DEFAULT NULL,
  `include_user` varchar(500) NOT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for record_confirm_msg
-- ----------------------------
DROP TABLE IF EXISTS `record_confirm_msg`;
CREATE TABLE `record_confirm_msg` (
  `confirm_id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `from` varchar(32) DEFAULT NULL,
  `owner` varchar(32) NOT NULL,
  `record_id` int(8) NOT NULL,
  `status` int(1) DEFAULT NULL COMMENT '0-待处理 1-已确认 2-已拒绝',
  PRIMARY KEY (`confirm_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` varchar(32) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_book
-- ----------------------------
DROP TABLE IF EXISTS `user_book`;
CREATE TABLE `user_book` (
  `book_id` int(5) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`book_id`,`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
