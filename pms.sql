/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 8.0.15 : Database - pms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pms` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `pms`;

/*Table structure for table `applyaddfriends` */

DROP TABLE IF EXISTS `applyaddfriends`;

CREATE TABLE `applyaddfriends` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `senderId` int(11) NOT NULL,
  `friendId` int(11) NOT NULL,
  `status` tinyint(1) DEFAULT '1' COMMENT '请求当前状态（未读1，未读2，已同意3，拒绝4）',
  `message` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注消息',
  `sendTime` bigint(13) DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `applyjoingroups` */

DROP TABLE IF EXISTS `applyjoingroups`;

CREATE TABLE `applyjoingroups` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `senderId` int(11) NOT NULL COMMENT '发起申请的ID',
  `groupId` int(11) NOT NULL COMMENT '群组ID',
  `status` tinyint(1) DEFAULT '1' COMMENT '请求当前状态（未读1，未读2，已同意3，拒绝4）',
  `message` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注消息',
  `readBy` int(11) DEFAULT NULL COMMENT '消息处理人（管理员/群主之一）',
  `sendTime` bigint(13) DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `group_relations` */

DROP TABLE IF EXISTS `group_relations`;

CREATE TABLE `group_relations` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `groupId` int(11) NOT NULL COMMENT '群组ID',
  `userId` int(11) NOT NULL COMMENT '用户ID',
  `type` tinyint(1) DEFAULT '1' COMMENT '成员类型（普通成员1，管理员2，群主3）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `groups` */

DROP TABLE IF EXISTS `groups`;

CREATE TABLE `groups` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `groupName` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '群组名称',
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '群主很懒，没有说明这个群是干啥的。' COMMENT '群描述',
  `ownerId` int(11) NOT NULL COMMENT '群主ID',
  `createBy` int(11) NOT NULL COMMENT '创建人',
  `createTime` bigint(13) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `messages` */

DROP TABLE IF EXISTS `messages`;

CREATE TABLE `messages` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `senderId` int(11) NOT NULL COMMENT '发送者ID',
  `receiverId` int(11) NOT NULL COMMENT '接收者ID',
  `messageBody` blob COMMENT '消息体',
  `messageType` tinyint(1) DEFAULT '1' COMMENT '消息类型（文字1，图片2）',
  `sendTime` bigint(13) DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Table structure for table `pms_users` */

DROP TABLE IF EXISTS `pms_users`;

CREATE TABLE `pms_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userName` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `nickName` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户昵称',
  `phoneNo` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机号码',
  `password` varchar(40) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `solt` varchar(40) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码加密盐',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态，（0离线，1在线，2...）默认离线',
  `lastLoginIp` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '最后登录IP',
  `lastLoginTime` bigint(13) DEFAULT NULL COMMENT '最后登录时间',
  `createTime` bigint(13) DEFAULT NULL COMMENT '账号创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户表';

/*Table structure for table `user_relations` */

DROP TABLE IF EXISTS `user_relations`;

CREATE TABLE `user_relations` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ownerId` int(11) NOT NULL COMMENT '用户ID',
  `friendId` int(11) NOT NULL COMMENT '好友ID',
  `friendType` tinyint(1) NOT NULL DEFAULT '1' COMMENT '关系类型 (好友1，陌生人2，黑名单3，特别关心4)',
  `groupName` varchar(50) COLLATE utf8_unicode_ci DEFAULT '好友' COMMENT '分组名称',
  `createTime` bigint(13) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
