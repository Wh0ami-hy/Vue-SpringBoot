-- MySQL dump 10.13  Distrib 5.7.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: online_exam
-- ------------------------------------------------------
-- Server version	5.7.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ex_answer`
--

DROP TABLE IF EXISTS `ex_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ex_answer` (
  `answer_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '员工id',
  `exam_info_id` int(11) NOT NULL COMMENT '考试id',
  `question_id` int(11) unsigned NOT NULL COMMENT '题目id',
  `question_item_id` int(11) NOT NULL COMMENT '选项id',
  `answer` text COLLATE utf8_unicode_ci NOT NULL COMMENT '答案：主观题使用',
  `result_type` tinyint(1) DEFAULT NULL COMMENT '结果类型：对、错、半错',
  `del_flag` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`answer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='考试作答结果';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ex_answer`
--

LOCK TABLES `ex_answer` WRITE;
/*!40000 ALTER TABLE `ex_answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `ex_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ex_exam_info`
--

DROP TABLE IF EXISTS `ex_exam_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ex_exam_info` (
  `exam_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '考试标题',
  `question_disorder` tinyint(1) NOT NULL DEFAULT '0' COMMENT '题目乱序',
  `option_disorder` tinyint(1) NOT NULL DEFAULT '0' COMMENT '选项乱序',
  `end_visible` tinyint(1) NOT NULL DEFAULT '1' COMMENT '批阅可见',
  `start_time` datetime NOT NULL COMMENT '开始时间',
  `end_time` datetime NOT NULL COMMENT '结束时间',
  `submit_time` datetime DEFAULT NULL COMMENT '提交时间',
  `is_monitor` tinyint(1) DEFAULT '0' COMMENT '是否开启行为监控',
  `is_copy_paste` tinyint(1) DEFAULT '0' COMMENT '是否允许复制',
  `dept_id` int(11) NOT NULL COMMENT '部门id',
  `paper_id` int(11) unsigned NOT NULL COMMENT '试卷id',
  `del_flag` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`exam_info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='考试信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ex_exam_info`
--

LOCK TABLES `ex_exam_info` WRITE;
/*!40000 ALTER TABLE `ex_exam_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `ex_exam_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ex_exam_log`
--

DROP TABLE IF EXISTS `ex_exam_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ex_exam_log` (
  `exam_log_id` int(11) NOT NULL AUTO_INCREMENT,
  `exam_info_id` int(11) NOT NULL COMMENT '考试id',
  `user_id` int(11) NOT NULL COMMENT '员工id',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门id',
  `status` tinyint(4) NOT NULL COMMENT '状态：0:开始、2：交卷',
  `del_flag` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`exam_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='考试作答日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ex_exam_log`
--

LOCK TABLES `ex_exam_log` WRITE;
/*!40000 ALTER TABLE `ex_exam_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `ex_exam_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ex_paper`
--

DROP TABLE IF EXISTS `ex_paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ex_paper` (
  `paper_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '试卷id',
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '试卷标题',
  `introduce` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '试卷介绍',
  `dept_id` int(11) NOT NULL COMMENT '部门id',
  `paper_type` int(11) NOT NULL DEFAULT '0' COMMENT '试卷类型：0:手动组卷，1：自动组卷，2：作业',
  `del_flag` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`paper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='试卷信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ex_paper`
--

LOCK TABLES `ex_paper` WRITE;
/*!40000 ALTER TABLE `ex_paper` DISABLE KEYS */;
/*!40000 ALTER TABLE `ex_paper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ex_paper_item`
--

DROP TABLE IF EXISTS `ex_paper_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ex_paper_item` (
  `paper_item_id` int(11) unsigned NOT NULL,
  `paper_id` int(11) unsigned NOT NULL COMMENT '试卷id',
  `question_id` int(11) unsigned NOT NULL COMMENT '题目id',
  `del_flag` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`paper_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ex_paper_item`
--

LOCK TABLES `ex_paper_item` WRITE;
/*!40000 ALTER TABLE `ex_paper_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `ex_paper_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ex_question`
--

DROP TABLE IF EXISTS `ex_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ex_question` (
  `question_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `content` text COLLATE utf8_unicode_ci NOT NULL COMMENT '题目名称',
  `type` char(1) COLLATE utf8_unicode_ci NOT NULL COMMENT '题目类型：0：单选、1：多选、2：判断、3：填空、4：主观',
  `difficulty` tinyint(3) NOT NULL DEFAULT '2' COMMENT '题目难度',
  `score` float NOT NULL DEFAULT '5' COMMENT '题目分值',
  `question_tag_id` int(11) NOT NULL COMMENT '题库类型标签',
  `dept_id` int(10) unsigned NOT NULL COMMENT '部门id',
  `del_flag` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`question_id`,`question_tag_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='题目信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ex_question`
--

LOCK TABLES `ex_question` WRITE;
/*!40000 ALTER TABLE `ex_question` DISABLE KEYS */;
/*!40000 ALTER TABLE `ex_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ex_question_item`
--

DROP TABLE IF EXISTS `ex_question_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ex_question_item` (
  `question_item_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `content` text COLLATE utf8_unicode_ci COMMENT '选项内容\r\n选择性题目：为选项\r\n填空题/客观题：null\r\n文件题：为文件类型\r\n代码题：为语言类型\r\n',
  `answer` text COLLATE utf8_unicode_ci COMMENT '选项答案：\r\n选择性题目：非null就是正确答案\r\n填空题/客观题：为正确答案\r\n文件题：为文件答案\r\n代码题：为代码执行结果',
  `question_id` int(10) unsigned NOT NULL COMMENT '题目id',
  `del_flag` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`question_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='题目选项表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ex_question_item`
--

LOCK TABLES `ex_question_item` WRITE;
/*!40000 ALTER TABLE `ex_question_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `ex_question_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ex_question_tag`
--

DROP TABLE IF EXISTS `ex_question_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ex_question_tag` (
  `question_tag_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '上级id',
  `ancestors` varchar(100) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '祖级列表',
  `question_tag` varchar(30) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '题库类型标签',
  `del_flag` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`question_tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='题库类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ex_question_tag`
--

LOCK TABLES `ex_question_tag` WRITE;
/*!40000 ALTER TABLE `ex_question_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `ex_question_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ex_score`
--

DROP TABLE IF EXISTS `ex_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ex_score` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `exam_info_id` int(11) NOT NULL COMMENT '考试信息id',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门id',
  `question_id` int(11) unsigned NOT NULL COMMENT '题目id',
  `score` float NOT NULL COMMENT '得分',
  `comment` text COLLATE utf8_unicode_ci COMMENT '评语',
  `result_type` tinyint(4) DEFAULT NULL COMMENT '批阅结果',
  `review_type` tinyint(4) DEFAULT NULL COMMENT '评阅类型',
  `del_flag` char(1) COLLATE utf8_unicode_ci DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='考试得分';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ex_score`
--

LOCK TABLES `ex_score` WRITE;
/*!40000 ALTER TABLE `ex_score` DISABLE KEYS */;
/*!40000 ALTER TABLE `ex_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ex_user`
--

DROP TABLE IF EXISTS `ex_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ex_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) NOT NULL COMMENT '用户账号',
  `user_type` varchar(2) DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `sex` char(1) DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  `status` char(1) DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='考试员工信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ex_user`
--

LOCK TABLES `ex_user` WRITE;
/*!40000 ALTER TABLE `ex_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `ex_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'online_exam'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-10 15:44:36
