/*
Navicat MySQL Data Transfer

Source Server         : first
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2015-01-02 23:30:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` varchar(10) NOT NULL,
  `bookname` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `sum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('s001', '平凡的世界', '文学', '0');
INSERT INTO `books` VALUES ('s002', '编译原理(龙书)', '计算机', '5');
INSERT INTO `books` VALUES ('s003', 'MySql数据库', '计算机', '5');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(20) DEFAULT NULL,
  `bookname` varchar(30) DEFAULT NULL,
  `bookid` varchar(10) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  `say` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('3', '201290514136', '平凡的世界', 's001', '2014年11月30日 16时17分33秒', '借书');
INSERT INTO `record` VALUES ('15', '201290514136', '编译原理(龙书)', 's002', '2014年11月30日 20时00分07秒', '借书');
INSERT INTO `record` VALUES ('17', '201290514136', '编译原理(龙书)', 's002', '2014年12月11日 21时05分08秒', '借书');
INSERT INTO `record` VALUES ('19', '201290514136', '编译原理(龙书)', 's002', '2014年12月15日 17时01分28秒', '借书');
INSERT INTO `record` VALUES ('20', '201290514136', '编译原理(龙书)', 's002', '2014年12月15日 17时01分33秒', '还书');
INSERT INTO `record` VALUES ('21', '201290514136', 'MySql数据库', 's003', '2014年12月15日 17时01分57秒', '借书');
INSERT INTO `record` VALUES ('22', '201290514136', '编译原理(龙书)', 's002', '2014年12月15日 17时01分59秒', '借书');
INSERT INTO `record` VALUES ('23', '201290514136', '平凡的世界', 's001', '2014年12月15日 17时02分02秒', '借书');
INSERT INTO `record` VALUES ('24', '201290514136', 'MySql数据库', 's003', '2014年12月15日 17时02分21秒', '还书');
INSERT INTO `record` VALUES ('25', '201290514136', '编译原理(龙书)', 's002', '2014年12月15日 17时02分23秒', '还书');

-- ----------------------------
-- Table structure for stubook
-- ----------------------------
DROP TABLE IF EXISTS `stubook`;
CREATE TABLE `stubook` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(20) DEFAULT NULL,
  `bookname` varchar(30) DEFAULT NULL,
  `bookid` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of stubook
-- ----------------------------
INSERT INTO `stubook` VALUES ('4', '201290514136', '平凡的世界', 's001');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `number` varchar(20) NOT NULL,
  `name` varchar(10) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `classes` varchar(15) DEFAULT NULL,
  `dept` varchar(20) DEFAULT NULL,
  `sum` int(11) DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('201290514116', '孙开增', 'M', '文计121-1', '电子系', '0');
INSERT INTO `student` VALUES ('201290514136', '张家东', 'M', '文计121-1', '电子系', '1');
