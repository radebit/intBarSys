/*
 Navicat Premium Data Transfer

 Source Server         : localhost5.7-3306
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : intbarsys

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 14/11/2019 08:51:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for r_activity
-- ----------------------------
DROP TABLE IF EXISTS `r_activity`;
CREATE TABLE `r_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `title` varchar(300) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `category` int(11) NOT NULL DEFAULT '0' COMMENT '分类(0-赛事,1-新游体验)',
  `reg_method` int(11) NOT NULL DEFAULT '0' COMMENT '报名方式(0-个人赛,1-团队赛)',
  `format` int(11) DEFAULT NULL COMMENT '赛制',
  `contact` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系人',
  `phone` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `place` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地点',
  `reward_first` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '一等奖',
  `reward_second` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '二等奖',
  `reward_third` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '三等奖',
  `reward_other` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '其他奖励',
  `details` text COLLATE utf8mb4_unicode_ci COMMENT '详情',
  `attention` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '注意事项',
  `logo` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'logo',
  `banner` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'banner',
  `rules` varchar(3000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '赛事规则',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of r_activity
-- ----------------------------
BEGIN;
INSERT INTO `r_activity` VALUES (1, '测试比赛1', 1, 1, 1, '李四', '13908087878', '2019-10-19 10:24:40', '2019-12-19 10:24:40', '浙江杭州', '300', '200', '100', '无', '这是一场测试比赛', '没有什么注意事项', '', '', '没有什么比赛规则');
INSERT INTO `r_activity` VALUES (2, '测试比赛2', 1, 1, 1, '张三', '13908087878', '2019-10-19 10:24:40', '2019-12-19 10:24:40', '浙江杭州', '300', '200', '100', '无', '这是一场测试比赛', '没有什么注意事项', '', '', '没有什么比赛规则');
INSERT INTO `r_activity` VALUES (5, '测试比赛5', 1, 1, 1, '张三', '13908087878', '2019-10-19 10:24:40', '2019-12-19 10:24:40', '浙江杭州', '300', '200', '100', '无', '这是一场测试比赛', '没有什么注意事项', '', '', '没有什么比赛规则');
INSERT INTO `r_activity` VALUES (6, '测试编辑比赛', 1, 1, 1, '张三', '13908087878', '2019-10-19 10:24:40', '2019-12-19 10:24:40', '浙江杭州', '300', '200', '100', '无', '这是一场测试比赛', '没有什么注意事项', '', '', '没有什么比赛规则');
INSERT INTO `r_activity` VALUES (7, '测试比赛11', 1, 1, 1, '张三', '13908087878', '2019-10-19 10:24:40', '2019-12-19 10:24:40', '浙江杭州', '300', '200', '100', '无', '这是一场测试比赛', '没有什么注意事项', '', '', '没有什么比赛规则');
COMMIT;

-- ----------------------------
-- Table structure for r_admin
-- ----------------------------
DROP TABLE IF EXISTS `r_admin`;
CREATE TABLE `r_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '管理员账号',
  `password` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '管理员密码',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `last_login_ip` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '上次登录IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of r_admin
-- ----------------------------
BEGIN;
INSERT INTO `r_admin` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '2019-11-04 10:33:43', '0:0:0:0:0:0:0:1');
INSERT INTO `r_admin` VALUES (3, 'test', 'e10adc3949ba59abbe56e057f20f883e', '2019-10-11 08:47:18', '0:0:0:0:0:0:0:1');
INSERT INTO `r_admin` VALUES (4, 'test01', '123123', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for r_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `r_dictionary`;
CREATE TABLE `r_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `dic_key` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '键',
  `dic_value` varchar(4000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '值',
  `dic_attach` varchar(4000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '附加属性',
  `dic_note` varchar(2000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '注释',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of r_dictionary
-- ----------------------------
BEGIN;
INSERT INTO `r_dictionary` VALUES (1, 'website_name', 'Go人OS赛事平台', '1', '网站名称');
INSERT INTO `r_dictionary` VALUES (2, 'website_url', 'http://localhost/', NULL, '平台网址');
INSERT INTO `r_dictionary` VALUES (3, 'website_phone', '400-8820-9080', NULL, '联系电话');
INSERT INTO `r_dictionary` VALUES (4, 'website_address', '浙江省杭州市', NULL, '平台地址');
INSERT INTO `r_dictionary` VALUES (5, 'website_icp', '浙ICP备:18820399', NULL, '网站备案号');
INSERT INTO `r_dictionary` VALUES (6, 'website_email', '123456@qq.com', NULL, '管理员邮箱');
COMMIT;

-- ----------------------------
-- Table structure for r_diyform
-- ----------------------------
DROP TABLE IF EXISTS `r_diyform`;
CREATE TABLE `r_diyform` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `diy_key` varchar(5000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '自定义字段',
  `diy_value` varchar(5000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '自定义值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for r_intbarinfo
-- ----------------------------
DROP TABLE IF EXISTS `r_intbarinfo`;
CREATE TABLE `r_intbarinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `name` varchar(300) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '网吧名称',
  `account` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '网关账号',
  `password` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '网关密码',
  `ip` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'IP地址',
  `place` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '网吧地址',
  `contact` varchar(300) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系人',
  `phone` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系号码',
  `remarks` varchar(5000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for r_judgment
-- ----------------------------
DROP TABLE IF EXISTS `r_judgment`;
CREATE TABLE `r_judgment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `username` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '账号',
  `password` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `real_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `id_number` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `reg_time` datetime DEFAULT NULL COMMENT '开通时间',
  `state` int(11) DEFAULT '1' COMMENT '状态',
  `sms_num` varchar(10000) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '短信数量',
  `power` int(11) DEFAULT '0' COMMENT '裁判权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for r_team
-- ----------------------------
DROP TABLE IF EXISTS `r_team`;
CREATE TABLE `r_team` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `team_name` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '战队名称',
  `captain` varchar(2000) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '队长',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for r_users
-- ----------------------------
DROP TABLE IF EXISTS `r_users`;
CREATE TABLE `r_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `username` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `openid` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'openid',
  `real_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `id_number` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `wechat` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信号',
  `qq` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'QQ号',
  `phone` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `gender` int(11) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `email` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `address` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `portrait` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '头像',
  `introduction` varchar(1000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

SET FOREIGN_KEY_CHECKS = 1;
