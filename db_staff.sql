/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : db_staff

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2019-09-26 15:19:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for s_admin
-- ----------------------------
DROP TABLE IF EXISTS `s_admin`;
CREATE TABLE `s_admin` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createDate` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_admin
-- ----------------------------
INSERT INTO `s_admin` VALUES ('1', 'yoona', '900530', '2019-09-05 02:05:05');
INSERT INTO `s_admin` VALUES ('2', 'admin', '000', '2019-09-05 23:58:55');

-- ----------------------------
-- Table structure for s_class
-- ----------------------------
DROP TABLE IF EXISTS `s_class`;
CREATE TABLE `s_class` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `cname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `info` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_class
-- ----------------------------
INSERT INTO `s_class` VALUES ('1', '财务部', '资金管理');
INSERT INTO `s_class` VALUES ('2', '人事部', '规划，建立、执行招聘、培训、考勤、劳动纪律等人事程序或规章制度');
INSERT INTO `s_class` VALUES ('3', '后勤部', '后勤保障');
INSERT INTO `s_class` VALUES ('4', '市场部', '市场调研，市场策略研究 ');
INSERT INTO `s_class` VALUES ('5', '技术部', '解决生产中疑难问题');
INSERT INTO `s_class` VALUES ('6', '生产部', '负责把客户的订单按计划物控（PMC）部门的生产任务单，分解到车间、工位、工序，把图纸变成产品的生产部门，根据企业的不同，划分到不同的车间、生产线、班组；');
INSERT INTO `s_class` VALUES ('7', '行政部', '建立和完善工作程序、岗位职责等 ');
INSERT INTO `s_class` VALUES ('13', '外勤部', '觉得好看打开');

-- ----------------------------
-- Table structure for s_signin
-- ----------------------------
DROP TABLE IF EXISTS `s_signin`;
CREATE TABLE `s_signin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  `signin_date` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `staff_signin_foreign` (`staff_id`),
  KEY `class_signin_foreign` (`class_id`),
  CONSTRAINT `class_signin_foreign` FOREIGN KEY (`class_id`) REFERENCES `s_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `staff_signin_foreign` FOREIGN KEY (`staff_id`) REFERENCES `s_staff` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_signin
-- ----------------------------
INSERT INTO `s_signin` VALUES ('15', '6', '4', '2019-08-25');
INSERT INTO `s_signin` VALUES ('18', '1', '6', '2019-08-25');
INSERT INTO `s_signin` VALUES ('20', '7', '7', '2019-09-25');
INSERT INTO `s_signin` VALUES ('22', '3', '1', '2019-09-25');
INSERT INTO `s_signin` VALUES ('23', '2', '2', '2019-09-25');
INSERT INTO `s_signin` VALUES ('24', '1', '6', '2019-09-20');
INSERT INTO `s_signin` VALUES ('25', '2', '2', '2019-09-26');
INSERT INTO `s_signin` VALUES ('26', '7', '7', '2019-09-26');
INSERT INTO `s_signin` VALUES ('27', '3', '1', '2019-09-23');
INSERT INTO `s_signin` VALUES ('28', '9', '3', '2019-09-26');
INSERT INTO `s_signin` VALUES ('31', '3', '1', '2019-09-26');
INSERT INTO `s_signin` VALUES ('32', '1', '6', '2019-09-26');

-- ----------------------------
-- Table structure for s_staff
-- ----------------------------
DROP TABLE IF EXISTS `s_staff`;
CREATE TABLE `s_staff` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `classId` int(5) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `class_foreign` (`classId`),
  CONSTRAINT `class_foreign` FOREIGN KEY (`classId`) REFERENCES `s_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_staff
-- ----------------------------
INSERT INTO `s_staff` VALUES ('1', '马志气', '女', '15', '6', '000');
INSERT INTO `s_staff` VALUES ('2', '严作昊', '女', '20', '2', '000');
INSERT INTO `s_staff` VALUES ('3', '岳原址', '女', '38', '1', '000');
INSERT INTO `s_staff` VALUES ('6', '张狱中', '男', '22', '4', '000');
INSERT INTO `s_staff` VALUES ('7', '董建华', '女', '15', '7', '000');
INSERT INTO `s_staff` VALUES ('8', '张宇钟', '男', '20', '6', '000');
INSERT INTO `s_staff` VALUES ('9', '昭雪送', '女', '20', '3', '000');
INSERT INTO `s_staff` VALUES ('10', '李新华', '男', '15', '5', '000');
