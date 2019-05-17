/*
Navicat MySQL Data Transfer

Source Server         : oushuai
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : animal

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-05-17 19:21:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for album
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `album_name` varchar(255) NOT NULL,
  `album_url` varchar(255) DEFAULT NULL,
  `cate_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `photo_count` int(11) DEFAULT NULL,
  `sort_no` tinyint(4) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of album
-- ----------------------------
INSERT INTO `album` VALUES ('1', '柴犬', 'https://f10.baidu.com/it/u=898425405,2068998455&fm=72', null, null, null, null, null, '2019-05-13 22:17:50', '2019-05-13 22:17:50');
INSERT INTO `album` VALUES ('2', '哈士奇', 'https://f10.baidu.com/it/u=898425405,2068998455&fm=72', null, null, null, null, null, '2019-05-13 19:32:55', '2019-05-13 19:32:55');
INSERT INTO `album` VALUES ('3', '金毛', 'https://f10.baidu.com/it/u=898425405,2068998455&fm=72', null, null, null, null, null, '2019-05-13 19:32:58', '2019-05-13 19:32:58');
INSERT INTO `album` VALUES ('4', '萨摩耶', 'https://f10.baidu.com/it/u=898425405,2068998455&fm=72', null, null, null, null, null, '2019-05-13 19:33:02', '2019-05-13 19:33:02');
INSERT INTO `album` VALUES ('5', '边牧', 'https://f10.baidu.com/it/u=898425405,2068998455&fm=72', null, null, null, null, null, '2019-05-17 14:46:21', '2019-05-17 14:46:21');
INSERT INTO `album` VALUES ('6', '德牧', 'https://f10.baidu.com/it/u=898425405,2068998455&fm=72', null, null, null, null, null, '2019-05-17 14:46:35', '2019-05-17 14:46:35');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cate_id` int(11) NOT NULL AUTO_INCREMENT,
  `cate_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '小狗');
INSERT INTO `category` VALUES ('3', '小猫');
INSERT INTO `category` VALUES ('4', '仓鼠');
INSERT INTO `category` VALUES ('5', '鸭子');
INSERT INTO `category` VALUES ('6', '水獭');
INSERT INTO `category` VALUES ('7', '鹦鹉');
INSERT INTO `category` VALUES ('9', '鸭子');
INSERT INTO `category` VALUES ('11', '狮子');
INSERT INTO `category` VALUES ('12', '222');
INSERT INTO `category` VALUES ('13', '333');

-- ----------------------------
-- Table structure for new
-- ----------------------------
DROP TABLE IF EXISTS `new`;
CREATE TABLE `new` (
  `new_id` int(11) NOT NULL AUTO_INCREMENT,
  `new_title` varchar(255) DEFAULT NULL,
  `new_content` varchar(1200) DEFAULT NULL,
  `new_photo_id1` varchar(255) DEFAULT NULL,
  `new_photo_id2` varchar(255) DEFAULT NULL,
  `new_photo_id3` varchar(255) DEFAULT NULL,
  `new_key_words` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`new_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of new
-- ----------------------------

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `photo_id` int(255) NOT NULL AUTO_INCREMENT,
  `photo_url` varchar(255) DEFAULT NULL,
  `album_id` int(255) DEFAULT NULL,
  `photo_name` varchar(255) DEFAULT NULL,
  `photo_date` datetime DEFAULT NULL,
  `is_recommend` tinyint(4) DEFAULT '0',
  `read_times` int(11) DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`photo_id`),
  KEY `fk_photo_album` (`album_id`),
  CONSTRAINT `fk_photo_album` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of photo
-- ----------------------------
INSERT INTO `photo` VALUES ('102', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3004199139,1571874005&fm=26&gp=0.jpg', '3', '杨幂', '2019-04-19 01:26:03', '1', '100', null, null, null);
INSERT INTO `photo` VALUES ('103', 'https://f11.baidu.com/it/u=941395880,868059849&fm=72', '3', '刘诗诗', '2019-05-04 18:25:21', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('105', 'https://f12.baidu.com/it/u=1521685551,1734585371&fm=72', '3', '杨幂照片', '2019-04-19 01:01:54', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('107', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3013539570,50567393&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 14:32:14', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('110', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2388116892,1239478659&fm=26&gp=0.jpg', '4', '11', '2019-05-11 03:54:18', '0', null, null, null, null);
INSERT INTO `photo` VALUES ('111', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3184510818,39967754&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 14:32:17', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('112', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=915593634,1630526971&fm=26&gp=0.jpg', '2', '杨幂', '2019-04-27 00:46:06', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('114', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3159231281,4076954723&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 18:25:22', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('115', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2252724258,4287780990&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 14:32:18', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('116', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1806415508,1740939273&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 18:25:22', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('117', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=114727517,1463461560&fm=26&gp=0.jpg', '2', '杨幂', '2019-04-27 00:46:05', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('118', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3850738088,295094939&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 18:25:21', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('119', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2612452737,2915717732&fm=26&gp=0.jpg', '3', '杨幂', '2019-04-28 21:36:21', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('120', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3017357401,2950676368&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 14:32:17', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('121', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=743214970,2719272104&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 14:32:17', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('122', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3081714141,2906554875&fm=26&gp=0.jpg', '4', '杨幂', '2019-04-27 00:48:24', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('123', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1663259481,4061765665&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 18:25:21', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('124', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2086360679,3738734580&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 18:25:17', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('127', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2086360679,3738734580&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 18:25:22', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('128', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1273525349,2390529593&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 14:32:16', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('129', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=4252584244,527190917&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 18:25:22', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('130', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=41596655,3377727327&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 18:25:22', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('131', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1831543756,2219597148&fm=26&gp=0.jpg', '2', '杨幂', '2019-04-27 00:48:22', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('132', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1831543756,2219597148&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 14:32:17', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('133', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1831543756,2219597148&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 18:25:20', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('134', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1831543756,2219597148&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 14:32:17', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('135', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1831543756,2219597148&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 14:32:17', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('136', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1831543756,2219597148&fm=26&gp=0.jpg', '2', '杨幂', '2019-04-27 00:48:24', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('137', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1831543756,2219597148&fm=26&gp=0.jpg', '3', '刘诗诗', '2019-05-04 14:32:18', '0', '100', null, null, null);
INSERT INTO `photo` VALUES ('141', 'http://localhost:8080/images/7fe0274c-5594-46b8-a44a-f3117ce1ad3b_file.jpg', '1', '342', '2019-05-17 14:20:14', '1', null, null, '2019-05-17 14:20:02', null);
INSERT INTO `photo` VALUES ('142', 'http://localhost:8080/images/156bc5ec-d16c-4039-b627-5d54ec25204f_file.jpg', '1', '23', '2019-05-17 14:31:34', '1', null, null, '2019-05-17 14:31:34', null);
INSERT INTO `photo` VALUES ('143', 'http://localhost:8080/images/34a889ae-5dd6-43a6-8d7a-ea75ac1da8cc_file.png', '1', '5', '2019-05-17 14:44:06', '1', null, null, '2019-05-17 14:44:06', null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `photo_url` varchar(255) DEFAULT NULL,
  `is_delete` tinyint(4) DEFAULT '0',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'oushuai', '123', 'oushuai', '1234235434534', null, '0', '2019-05-15 22:17:08', '2019-05-15 22:17:14');
INSERT INTO `sys_user` VALUES ('2', 'james', '123', null, null, null, '0', '2019-05-15 22:17:17', '2019-05-15 22:17:23');
INSERT INTO `sys_user` VALUES ('3', 'lx', '123', null, null, null, '0', '2019-05-15 22:18:11', '2019-05-15 22:18:11');
INSERT INTO `sys_user` VALUES ('4', 'longxi', '123', null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('5', 'dsfd', '22', null, null, null, null, '2019-05-15 22:22:34', '2019-05-15 22:22:34');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `video_id` int(11) NOT NULL AUTO_INCREMENT,
  `video_name` varchar(255) DEFAULT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  `album_id` int(11) DEFAULT NULL,
  `video_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `recommend` varchar(255) DEFAULT NULL,
  `read_times` int(11) DEFAULT NULL,
  PRIMARY KEY (`video_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of video
-- ----------------------------
