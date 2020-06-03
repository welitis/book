/*
 Navicat Premium Data Transfer

 Source Server         : localhost2
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : book_db

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 03/06/2020 10:01:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书名',
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者',
  `price` decimal(11, 2) NOT NULL COMMENT '价格',
  `sales` int(11) NOT NULL COMMENT '销量',
  `stock` int(11) NOT NULL COMMENT '库存',
  `img_path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书的图片路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (1, 'java从入门到放弃', '国哥', 80.00, 9999, 9, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (2, '数据结构与算法', '严敏君', 78.50, 9, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (3, '怎样拐跑别人的媳妇', '龙伍', 68.00, 100005, 46, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (4, '木虚肉盖饭', '小胖', 16.00, 1000, 50, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (5, 'C++编程思想', '刚哥', 45.50, 14, 95, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (6, '蛋炒饭', '周星星', 9.90, 12, 53, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (7, '赌神', '龙伍', 66.50, 125, 535, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (8, 'Java编程思想', '阳哥', 99.50, 47, 36, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (9, 'JavaScript从入门到精通', '婷姐', 9.90, 85, 95, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (10, 'cocos2d-x游戏编程入门', '国哥', 49.00, 52, 62, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (11, 'C语言程序设计', '谭浩强', 28.00, 52, 74, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (12, 'Lua语言程序设计', '雷丰阳', 51.50, 48, 82, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (13, '西游记', '罗贯中', 12.00, 19, 9999, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (14, '水浒传', '华仔', 33.05, 22, 88, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (15, '操作系统原理', '刘优', 133.05, 122, 188, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (16, '数据结构 java版', '封大神', 173.15, 22, 81, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (17, 'UNIX高级环境编程', '乐天', 99.15, 210, 810, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (18, 'javaScript高级编程', '国哥', 21.00, 210, 810, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (19, '大话设计模式', '国哥', 89.15, 20, 10, 'static/img/default.jpg');
INSERT INTO `t_book` VALUES (20, '人月神话', '刚哥', 88.15, 20, 80, 'static/img/default.jpg');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `total_money` decimal(11, 2) NOT NULL,
  `status` int(11) NOT NULL DEFAULT 0,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('158529931762381', '2020-03-27 00:00:00', 214.50, 1, 1);
INSERT INTO `t_order` VALUES ('158529934225861', '2020-03-27 00:00:00', 225.00, 1, 1);
INSERT INTO `t_order` VALUES ('158536075744121', '2020-03-28 00:00:00', 214.50, 1, 1);
INSERT INTO `t_order` VALUES ('158536078285261', '2020-03-28 00:00:00', 78.50, 0, 1);
INSERT INTO `t_order` VALUES ('158537666281001', '2020-03-28 00:00:00', 136.00, 0, 1);
INSERT INTO `t_order` VALUES ('158538089829501', '2020-03-28 00:00:00', 214.50, 0, 1);

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(11, 2) NULL DEFAULT NULL,
  `total_money` decimal(11, 2) NULL DEFAULT NULL,
  `count` int(11) NOT NULL,
  `order_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------
INSERT INTO `t_order_item` VALUES (1, '怎样拐跑别人的媳妇', 68.00, 136.00, 2, '158529931762381');
INSERT INTO `t_order_item` VALUES (2, '数据结构与算法', 78.50, 78.50, 1, '158529931762381');
INSERT INTO `t_order_item` VALUES (3, '怎样拐跑别人的媳妇', 68.00, 68.00, 1, '158529934225861');
INSERT INTO `t_order_item` VALUES (4, '数据结构与算法', 78.50, 157.00, 2, '158529934225861');
INSERT INTO `t_order_item` VALUES (5, '怎样拐跑别人的媳妇', 68.00, 136.00, 2, '158536075744121');
INSERT INTO `t_order_item` VALUES (6, '数据结构与算法', 78.50, 78.50, 1, '158536075744121');
INSERT INTO `t_order_item` VALUES (7, '数据结构与算法', 78.50, 78.50, 1, '158536078285261');
INSERT INTO `t_order_item` VALUES (8, '怎样拐跑别人的媳妇', 68.00, 136.00, 2, '158537666281001');
INSERT INTO `t_order_item` VALUES (9, '怎样拐跑别人的媳妇', 68.00, 136.00, 2, '158538089829501');
INSERT INTO `t_order_item` VALUES (10, '数据结构与算法', 78.50, 78.50, 1, '158538089829501');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', 'admin', 'admin@atguigu.com');
INSERT INTO `t_user` VALUES (2, '张安', '123123', 'zan@qq.com');
INSERT INTO `t_user` VALUES (3, 'wangwu', '1123', 'ww@qq.com');
INSERT INTO `t_user` VALUES (4, 'asdas', 'asdasd', 'asdasd');
INSERT INTO `t_user` VALUES (5, 'admain', 'adsam', 'adsaf');
INSERT INTO `t_user` VALUES (6, 'aa', 'aa', 'aa');
INSERT INTO `t_user` VALUES (7, 'aac', 'abc', 'asda');
INSERT INTO `t_user` VALUES (8, 'admini', 'adsas', 'asdfasd');
INSERT INTO `t_user` VALUES (9, 'admin11', 'asd', '123');
INSERT INTO `t_user` VALUES (10, 'asdasfa', 'adaf', 'adsfas');
INSERT INTO `t_user` VALUES (11, 'aasdfa', 'adfadfad', 'adfa');

SET FOREIGN_KEY_CHECKS = 1;
