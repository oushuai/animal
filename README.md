# animal
/*
Navicat MySQL Data Transfer

Source Server         : oushuai
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : animal

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-05-06 23:32:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for album
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `album_id` int(255) NOT NULL AUTO_INCREMENT,
  `album_name` varchar(255) NOT NULL,
  `album_url` varchar(255) DEFAULT NULL,
  `cate_id` int(11) DEFAULT NULL,
  `photo_count` int(11) DEFAULT NULL,
  `album_create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `album_update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`album_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of album
-- ----------------------------
INSERT INTO `album` VALUES ('2', '小猫', 'www.baidu.com', null, null, null, null);
INSERT INTO `album` VALUES ('3', 'dog', '', null, null, null, null);
INSERT INTO `album` VALUES ('4', 'fish', '', null, null, null, null);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cate_id` int(11) NOT NULL,
  `cate_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `photo_id` varchar(255) NOT NULL,
  `photo_url` varchar(255) DEFAULT NULL,
  `album_id` int(255) DEFAULT NULL,
  `photo_name` varchar(255) DEFAULT NULL,
  `photo_date` datetime DEFAULT NULL,
  `recommend` varchar(255) DEFAULT NULL,
  `readTimes` int(11) DEFAULT NULL,
  PRIMARY KEY (`photo_id`),
  KEY `fk_photo_album` (`album_id`),
  CONSTRAINT `fk_photo_album` FOREIGN KEY (`album_id`) REFERENCES `album` (`album_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of photo
-- ----------------------------
INSERT INTO `photo` VALUES ('007cc', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 18:25:21', '10', '100');
INSERT INTO `photo` VALUES ('0c0ec', 'www.oppo.com', '2', '杨幂', '2019-04-27 00:48:24', '10', '100');
INSERT INTO `photo` VALUES ('1', 'www.wangyi.com', '3', '杨幂照片', '2019-04-19 01:01:54', '1', '100');
INSERT INTO `photo` VALUES ('17a29', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 14:32:14', '10', '100');
INSERT INTO `photo` VALUES ('2', '.wangyi.com', '3', '杨幂', '2019-04-19 01:26:03', '1', '100');
INSERT INTO `photo` VALUES ('2b2d9', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 14:32:17', '10', '100');
INSERT INTO `photo` VALUES ('3031d', 'www.sougou.com', '2', '杨幂', '2019-04-27 00:46:06', '10', '100');
INSERT INTO `photo` VALUES ('462e5', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 18:25:22', '10', '100');
INSERT INTO `photo` VALUES ('49514', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 14:32:18', '10', '100');
INSERT INTO `photo` VALUES ('4af27', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 18:25:22', '10', '100');
INSERT INTO `photo` VALUES ('5492c', 'www.weibo.com', '2', '杨幂', '2019-04-27 00:46:05', '10', '100');
INSERT INTO `photo` VALUES ('57da9', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 18:25:21', '10', '100');
INSERT INTO `photo` VALUES ('59149', 'www.aiqiyi.com', '3', '杨幂', '2019-04-28 21:36:21', '10', '100');
INSERT INTO `photo` VALUES ('61c61', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 14:32:17', '10', '100');
INSERT INTO `photo` VALUES ('655aa', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 14:32:17', '10', '100');
INSERT INTO `photo` VALUES ('675cc', '2', '4', '杨幂', '2019-04-27 00:48:24', '10', '100');
INSERT INTO `photo` VALUES ('87fd7', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 18:25:21', '10', '100');
INSERT INTO `photo` VALUES ('88436', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 18:25:17', '10', '100');
INSERT INTO `photo` VALUES ('9c6dc', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 18:25:22', '10', '100');
INSERT INTO `photo` VALUES ('a62d8', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 14:32:16', '10', '100');
INSERT INTO `photo` VALUES ('a8c1e', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 18:25:22', '10', '100');
INSERT INTO `photo` VALUES ('b555a', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 18:25:22', '10', '100');
INSERT INTO `photo` VALUES ('c2c7f', 'www.xiaomi.com', '2', '杨幂', '2019-04-27 00:48:22', '10', '100');
INSERT INTO `photo` VALUES ('c6a03', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 14:32:17', '10', '100');
INSERT INTO `photo` VALUES ('cb012', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 18:25:20', '10', '100');
INSERT INTO `photo` VALUES ('d833e', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 14:32:17', '10', '100');
INSERT INTO `photo` VALUES ('e7d8f', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 14:32:17', '10', '100');
INSERT INTO `photo` VALUES ('e7f3e', 'www.huawei.com', '2', '杨幂', '2019-04-27 00:48:24', '10', '100');
INSERT INTO `photo` VALUES ('fbb73', 'www.mangguo.tv', '3', '刘诗诗', '2019-05-04 14:32:18', '10', '100');
