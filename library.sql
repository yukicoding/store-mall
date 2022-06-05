/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50554
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 50554
 File Encoding         : 65001

 Date: 01/06/2022 13:18:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) NULL DEFAULT NULL,
  `address` varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1, 1, '我在深夜里旅行', 'didi');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publish` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pages` int(255) NULL DEFAULT NULL,
  `price` float(10, 2) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bookcaseid` int(10) NULL DEFAULT NULL,
  `abled` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '《大盂鼎 金石名品》', '王双强', '浙江人民美术出版社', 100, 98.00, '大盂鼎，西周时代，现收藏于中国历史博物馆。大孟鼎上的铭文记述了西周康王二十三年在宗周对贵族盂的一次册命。腹内铭文19行，291字，铭文字体瑰丽雄齐，用笔方整，行款茂密，布局完满，是学习金文的极好范本。', 9, 1);
INSERT INTO `book` VALUES (2, '《简帛书法大系：敦煌马圈湾汉简书法》', '张德芳，王立翔', '上海书画出版社', 329, 26.00, '1979年“马圈湾汉简”的出土，除了其不可忽视的历史文献价值外，对研究书法的演变也提供了极为有价值的一手资料。其中包含了隶书、草隶、草书多种风格的样式，笔锋清晰俊逸，纤毫毕现，为研究临习者提供了不可多得的范本。', 1, 1);
INSERT INTO `book` VALUES (3, '《曾熙书画题跋录 》', '曾繁滌', '上海书画出版社', 300, 27.00, '本书由曾繁涤编辑整理，内容主要包括三个部分：张善孖、张大千手录的曾熙书画作品的诗文题跋以及这些题跋的释文。', 4, 1);
INSERT INTO `book` VALUES (4, '《沈鹏书法十九讲》', '沈鹏', '北京大学出版社', 225, 22.00, '该书由沈鹏先生有关书法的演讲汇集而成。作者从“书学”的概念入手 ，以其提出的书法学“宏扬原创，尊重个性，书内书外，艺道并进”十六字方针贯穿其中。', 1, 1);
INSERT INTO `book` VALUES (5, '《沈尹默中国古典文学读本题签》', '张一鸣', '浙江人民美术出版社', 330, 27.00, '沈尹默先生的题签，不但笔画圆润饱满，立体感强；而且在整体驾驭上又举重若轻，游刃有余。他的题签达到了“无色而具图画的灿烂、无声而具音乐的和谐”的境界。', 6, 1);
INSERT INTO `book` VALUES (6, '《笔下云烟》', '周维强', '浙江人民美术出版社', 89, 17.00, '书法大师沈尹默先生历年来为人民文学出版社、上海古籍出版社以及线装书封面所书题签时，与出版社、与作者、与图书编辑之间来往或信函的趣事，作者通过多个小故事描述了大师的德艺双磬。', 7, 1);
INSERT INTO `book` VALUES (7, '《词学入门十讲》', '王兆鹏 ', '北京大学出版社', 100, 100.00, '《词学入门十讲》是当代词学专家王兆鹏教授的词学方法概论，根据作者的课堂录音整理成书，介绍古代词籍和现代整理本的文献情况，引导读者找到词学研究的入门途径。', 6, 1);
INSERT INTO `book` VALUES (8, '《玄外之音——董其昌书画作品赏析》', '董其昌书画艺术博物馆', '上海书画出版社', 300, 50.00, '董其昌是明代著名的书画家、鉴藏家、书画理论家，是当时的艺坛领袖。他的艺术集古大成，又自出机杼，在书画创作和理论方面，引领了明清以来几百年中国文人书画的发展。', 1, 1);
INSERT INTO `book` VALUES (9, '《徐渭绘画名品》', '上海书画出版社', '上海书画出版社', 300, 50.00, '本书为《中国绘画名品》系列之《徐渭绘画名品》。徐渭是明代重要的画家之一，他以水墨表现丰富为个人特色。', 2, 1);
INSERT INTO `book` VALUES (10, '《清光鉴古》', '梁鉴', '上海书画出版社', 154, 74.00, '本书为梁鉴（玄鉴斋）收藏的100面先秦铜镜的整理与研究，也是玄鉴斋藏镜系列的首部图录，按照先秦铜镜的纹饰内容分为先商至战国早期、地纹及花叶纹、瑞兽纹、凌格及山字纹、夔龙及蟠螭纹五部分。', NULL, NULL);
INSERT INTO `book` VALUES (11, '《中华书法小故事》', '安轩', '新华出版社', 231, 45.00, '《中华书法小故事》采用“编年体”的形式，从中国汉字的起源开始，到汉字的演化发展；从甲骨文的发现到青铜器铭文、石鼓文；从李斯小篆到隶变，楷化，行书，草书的整个书法历程。', NULL, NULL);
INSERT INTO `book` VALUES (12, '《Spring Boot 开发教程》', '黑马程序员', '人民邮电出版社', 98, 56.00, '本书讲解当前Java EE企业级开发的热门框架Spring Boot，并结合实际开发场景，介绍如何使用Spring Boot整合第三方框架进行Web开发。希望读者通过项目实战，深刻体会使用Spring Boot框架开发Web应用的便捷之处。', NULL, NULL);
INSERT INTO `book` VALUES (13, '《NoSQL数据库技术与应用》', '黑马程序员', '清华大学出版社', 100, 80.00, '本书围绕NoSQL数据库技术与应用进行详细讲解，全书共10章，本书适合作为高等院校计算机相关专业的教材，也可作为广大编程爱好者的实践图书。', NULL, NULL);
INSERT INTO `book` VALUES (14, '《MySQL数据库原理及应用》', '王坚', '清华大学出版社', 50, 45.00, '本书基于MySQL重点介绍数据库系统的基本概念、基本原理和基本设计方法，以面向工作过程的教学方法为导向，合理安排各章节的内容。', NULL, NULL);
INSERT INTO `book` VALUES (15, '《Python机器学习》', '刘艳', '清华大学出版社', 80, 60.00, '本书将机器学习背后的基本理论与应用实践联系起来，通过这种方式让读者聚焦于如何正确地提出问题、解决问题。本书都是一个重要且不可错过的资源，它能帮助你了解如何使用Python解决数据中的关键问题。', NULL, NULL);
INSERT INTO `book` VALUES (17, '《四六级》', '阿斯顿', '人民出版社', 24, 20.00, '四六级考试在6月11日', NULL, NULL);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bId` int(11) NULL DEFAULT NULL,
  `comment` varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createdName` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 1, '真好啊', NULL);
INSERT INTO `comment` VALUES (3, 2, '不错啊', NULL);
INSERT INTO `comment` VALUES (4, 1, '买买买', NULL);
INSERT INTO `comment` VALUES (5, 1, '买他买他', NULL);

-- ----------------------------
-- Table structure for t_authority
-- ----------------------------
DROP TABLE IF EXISTS `t_authority`;
CREATE TABLE `t_authority`  (
  `id` int(30) NOT NULL,
  `authority` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_authority
-- ----------------------------
INSERT INTO `t_authority` VALUES (1, 'ROLE_admin');
INSERT INTO `t_authority` VALUES (2, 'ROLE_user');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `valid` tinyint(1) NOT NULL DEFAULT 1,
  `yz` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 63 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (60, 'admin', '$2a$10$7FIJwedRseNZYi4aFJVC3eDK1u7RvvhAa09iLIAXoDUK7jZNwsVkm', '2540488391@qq.com', NULL, 1, 7730);
INSERT INTO `t_user` VALUES (61, '1908010720', '$2a$10$p8jn0N0x26SU1J0f6JAb8OwArL2TJn0oCpoNWqLL1ZW65Bjs0udfi', '2540488391@qq.com', NULL, 1, 8124);
INSERT INTO `t_user` VALUES (62, '1908010721', '$2a$10$rc/E63Pv8NNezTDhlVog9ul3/ij.LQwK0ROFyKOOUyPOJ4FwonIuy', '2540488391@qq.com', NULL, 1, 9564);

SET FOREIGN_KEY_CHECKS = 1;
