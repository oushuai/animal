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
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cate_id` int(11) NOT NULL,
  `cate_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `album_name` varchar(64) NOT NULL DEFAULT '' COMMENT '相册名称',
  `album_url` varchar(64) NOT NULL DEFAULT '' COMMENT '相册URl',
  `cate_id` INT(11) NOT NULL DEFAULT 0 COMMENT '分类ID',
  `user_id` INT(11) NOT NULL DEFAULT 0 COMMENT '用户ID（这个相册属于哪个用户）',
  `photo_count` INT(11) NOT NULL DEFAULT 0 COMMENT '照片数量',
  `sort_no` tinyint(4) unsigned DEFAULT 0 COMMENT '展示顺序',
  `status` tinyint(4) unsigned DEFAULT 1 COMMENT '状态；0 禁用；1可用',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='相册表';


DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `photo_name` varchar(64) NOT NULL DEFAULT '' COMMENT '照片名称',
  `photo_url` varchar(64) NOT NULL DEFAULT '' COMMENT '照片URl',
  `album_id` INT(11) NOT NULL DEFAULT 0 COMMENT '相册ID',
  `photo_date` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '照片拍摄时间',
  `readTimes` int(11) unsigned DEFAULT 0 COMMENT '预览次数',
  `is_recommend` tinyint(4) unsigned DEFAULT 1 COMMENT '是否推荐 0 否，1是',
  `is_delete` tinyint(4) unsigned DEFAULT 1 COMMENT '是否删除；0 删除；1可用',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='照片信息表';


CREATE TABLE `sys_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) NOT NULL COMMENT '账号',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `real_name` varchar(32) NOT NULL COMMENT '真实姓名',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号',
  `photo_url` varchar(128) NOT NULL DEFAULT '' COMMENT '照片链接',
  `is_delete` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除：0不删除，1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8 COMMENT='用户表';



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
