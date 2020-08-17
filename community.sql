/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : community

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-08-10 12:45:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `id` int NOT NULL,
  `rid` int NOT NULL,
  `out_time` varchar(255) NOT NULL,
  `in_time` varchar(255) NOT NULL,
  `actual_out_time` varchar(255) DEFAULT NULL,
  `actual_in_time` varchar(255) DEFAULT NULL,
  `reason` varchar(255) NOT NULL,
  `statu` int DEFAULT NULL,
  `temperature` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  CONSTRAINT `application_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `resident` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of application
-- ----------------------------
INSERT INTO `application` VALUES ('5', '4', '2020-08-11 04:00:00', '2020-08-11 08:00:00', '0', '0', '出去玩', '1', '36.3');
INSERT INTO `application` VALUES ('6', '4', '2020-08-11 12:00:00', '2020-08-11 02:00:00', '2020-08-10 09:50:28', '2020-08-10 09:54:07', '买菜', '1', '36.2');
INSERT INTO `application` VALUES ('7', '4', '2020-08-09 07:00:00', '2020-08-09 11:00:00', '0', '0', '上班', '2', '36.3');
INSERT INTO `application` VALUES ('8', '8', '2020-08-10 05:00:00', '2020-08-10 07:00:00', '0', '0', '购物', '1', '36.5');
INSERT INTO `application` VALUES ('9', '8', '2020-08-12 08:00:00', '2020-08-12 06:00:00', '0', '0', '上班', '2', '35.8');
INSERT INTO `application` VALUES ('10', '6', '2020-08-11 07:00:00', '2020-08-11 09:00:00', '0', '0', '训练', '1', '35.9');
INSERT INTO `application` VALUES ('11', '6', '2020-08-13 02:00:00', '2020-08-13 04:00:00', '0', '0', '购物', '0', '36.5');
INSERT INTO `application` VALUES ('12', '4', '2020-08-10 07:00:00', '2020-08-10 09:00:00', '0', '0', '买菜', '0', '36.3');

-- ----------------------------
-- Table structure for resident
-- ----------------------------
DROP TABLE IF EXISTS `resident`;
CREATE TABLE `resident` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `sex` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `idcard` varchar(255) NOT NULL,
  `temperature` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of resident
-- ----------------------------
INSERT INTO `resident` VALUES ('4', '任豪', '男', '3栋1单元502', '13989985857', '520424199505201645', '35.9');
INSERT INTO `resident` VALUES ('5', '周震南', '男', '4栋1单元202', '18854652541', '522421199802145623', '35.3');
INSERT INTO `resident` VALUES ('6', '孟美岐', '女', '2栋2单元501', '15784566452', '521362199706132456', '36.1');
INSERT INTO `resident` VALUES ('7', '焉栩嘉', '男', '5栋2单元303', '18545752254', '521325199704125645', '36.3');
INSERT INTO `resident` VALUES ('8', '何洛洛', '男', '3栋1单元501', '15589654123', '523621199908264554', '36.5');
INSERT INTO `resident` VALUES ('9', '吴宣仪', '女', '1栋2单元303', '15875465243', '524426199704122526', '36.3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123', '审核者');
INSERT INTO `user` VALUES ('10', 'concierge', '123', '门卫');
INSERT INTO `user` VALUES ('11', '任豪', '1234', '住户');
INSERT INTO `user` VALUES ('12', '周震南', '123', '住户');
INSERT INTO `user` VALUES ('13', '孟美岐', '123', '住户');
INSERT INTO `user` VALUES ('14', '焉栩嘉', '123', '住户');
INSERT INTO `user` VALUES ('15', '何洛洛', '123', '住户');
INSERT INTO `user` VALUES ('16', '吴宣仪', '123', '住户');

-- ----------------------------
-- Table structure for visitor
-- ----------------------------
DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `idcard` varchar(255) DEFAULT NULL,
  `temperature` varchar(255) DEFAULT NULL,
  `out_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `in_time` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of visitor
-- ----------------------------
INSERT INTO `visitor` VALUES ('1', '何天', '13956458659', '522412198502164542', '36.3', '2020-08-06 20:24:43', '2020-08-06 15:25:13', '男', '探亲');
INSERT INTO `visitor` VALUES ('2', '林音', '15895896552', '520426199711042523', '35.7', '2020-08-10 09:42:47', '2020-08-07 15:25:13', '女', '探亲');
INSERT INTO `visitor` VALUES ('3', '张剑', '15545658895', '522426199505201656', '36.3', '2020-08-07 21:54:19', '2020-08-06 19:51:03', '男', '外卖');
INSERT INTO `visitor` VALUES ('4', '姚琛', '15785456254', '522412199806122233', '36.1', '2020-08-10 09:53:56', '2020-08-10 09:41:42', '男', '看望朋友');
INSERT INTO `visitor` VALUES ('5', '张颜齐', '18542659878', '522342199703185456', '36.3', '2020-08-10 09:42:53', '2020-08-10 09:42:22', '男', '看望朋友');
INSERT INTO `visitor` VALUES ('6', '赵让', '15545456253', '522424199911032526', '36.5', '0', '2020-08-10 09:53:30', '男', '看望朋友');
DROP TRIGGER IF EXISTS `addUserR`;
DELIMITER ;;
CREATE TRIGGER `addUserR` BEFORE INSERT ON `resident` FOR EACH ROW insert into user(username,password,role) values(new.name,"123","住户")
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `deleteUserR`;
DELIMITER ;;
CREATE TRIGGER `deleteUserR` BEFORE DELETE ON `resident` FOR EACH ROW delete from user where username=old.name
;;
DELIMITER ;
