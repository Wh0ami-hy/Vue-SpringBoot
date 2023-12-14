/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : 127.0.0.1:3306
 Source Schema         : online_exam

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 14/12/2023 18:47:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ex_answer
-- ----------------------------
DROP TABLE IF EXISTS `ex_answer`;
CREATE TABLE `ex_answer`  (
  `answer_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '员工id',
  `exam_info_id` int(11) NOT NULL COMMENT '考试id',
  `question_id` int(11) UNSIGNED NOT NULL COMMENT '题目id',
  `question_item_id` int(11) NOT NULL COMMENT '选项id',
  `answer` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '答案：主观题使用',
  `result_type` tinyint(1) NULL DEFAULT NULL COMMENT '结果类型：对、错、半错',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`answer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '考试作答结果' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ex_exam_info
-- ----------------------------
DROP TABLE IF EXISTS `ex_exam_info`;
CREATE TABLE `ex_exam_info`  (
  `exam_info_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '考试标题',
  `question_disorder` tinyint(1) NOT NULL DEFAULT 0 COMMENT '题目乱序',
  `option_disorder` tinyint(1) NOT NULL DEFAULT 0 COMMENT '选项乱序',
  `end_visible` tinyint(1) NOT NULL DEFAULT 1 COMMENT '批阅可见',
  `start_time` datetime(0) NOT NULL COMMENT '开始时间',
  `end_time` datetime(0) NOT NULL COMMENT '结束时间',
  `submit_time` datetime(0) NULL DEFAULT NULL COMMENT '提交时间',
  `is_monitor` tinyint(1) NULL DEFAULT 0 COMMENT '是否开启行为监控',
  `is_copy_paste` tinyint(1) NULL DEFAULT 0 COMMENT '是否允许复制',
  `dept_id` int(11) NOT NULL COMMENT '部门id',
  `paper_id` int(11) UNSIGNED NOT NULL COMMENT '试卷id',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`exam_info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '考试信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ex_exam_log
-- ----------------------------
DROP TABLE IF EXISTS `ex_exam_log`;
CREATE TABLE `ex_exam_log`  (
  `exam_log_id` int(11) NOT NULL AUTO_INCREMENT,
  `exam_info_id` int(11) NOT NULL COMMENT '考试id',
  `user_id` int(11) NOT NULL COMMENT '员工id',
  `dept_id` int(11) NULL DEFAULT NULL COMMENT '部门id',
  `status` tinyint(4) NOT NULL COMMENT '状态：0:开始、2：交卷',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`exam_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '考试作答日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ex_paper
-- ----------------------------
DROP TABLE IF EXISTS `ex_paper`;
CREATE TABLE `ex_paper`  (
  `paper_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '试卷id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '试卷标题',
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '试卷介绍',
  `dept_id` int(11) NOT NULL COMMENT '部门id',
  `paper_type` int(11) NOT NULL DEFAULT 0 COMMENT '试卷类型：0:手动组卷，1：自动组卷，2：作业',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`paper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '试卷信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ex_paper_item
-- ----------------------------
DROP TABLE IF EXISTS `ex_paper_item`;
CREATE TABLE `ex_paper_item`  (
  `paper_item_id` int(11) UNSIGNED NOT NULL,
  `paper_id` int(11) UNSIGNED NOT NULL COMMENT '试卷id',
  `question_id` int(11) UNSIGNED NOT NULL COMMENT '题目id',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`paper_item_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ex_question
-- ----------------------------
DROP TABLE IF EXISTS `ex_question`;
CREATE TABLE `ex_question`  (
  `question_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '题目名称',
  `type` tinyint(1) UNSIGNED NOT NULL COMMENT '题目类型：0：单选、1：多选、2：判断、3：填空、4：主观',
  `difficulty` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '题目难度',
  `score` float UNSIGNED NOT NULL COMMENT '题目分值',
  `question_tag_id` int(11) UNSIGNED NOT NULL COMMENT '题库类型标签',
  `del_flag` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`question_id`, `question_tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 85 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '题目信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ex_question
-- ----------------------------
INSERT INTO `ex_question` VALUES (80, '（4分）程序状态字寄存器 PSW 中的 AC=1,表示( )。', 0, 0, 4, 202, 0, '', NULL, '', NULL, NULL);
INSERT INTO `ex_question` VALUES (81, '（3分）程序状态字寄存器 PSW 中的 AC=1,表示( )。', 1, 0, 3, 202, 0, '', NULL, '', NULL, NULL);
INSERT INTO `ex_question` VALUES (82, '（2分）程序状态字寄存器 PSW 中的 AC=1,表示( )。', 2, 0, 2, 202, 0, '', NULL, '', NULL, NULL);
INSERT INTO `ex_question` VALUES (83, '（3分）总线路是用于传送信息的公共通信途径。总线可分为____、____和____。', 3, 0, 3, 202, 0, '', NULL, '', NULL, NULL);
INSERT INTO `ex_question` VALUES (84, '（5分）总线路是用于传送信息的公共通信途径。总线可分为', 4, 0, 5, 202, 0, '', NULL, '', NULL, NULL);

-- ----------------------------
-- Table structure for ex_question_item
-- ----------------------------
DROP TABLE IF EXISTS `ex_question_item`;
CREATE TABLE `ex_question_item`  (
  `question_item_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '选项内容\r\n选择性题目：为选项\r\n填空题/客观题：null\r\n文件题：为文件类型\r\n代码题：为语言类型\r\n',
  `answer` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '选项答案：\r\n选择性题目：非null就是正确答案\r\n填空题/客观题：为正确答案\r\n文件题：为文件答案\r\n代码题：为代码执行结果',
  `question_id` int(10) UNSIGNED NOT NULL COMMENT '题目id',
  `del_flag` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`question_item_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '题目选项表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ex_question_item
-- ----------------------------
INSERT INTO `ex_question_item` VALUES (9, '计算结果有进位', NULL, 80, 0, '', NULL, '', NULL, NULL);
INSERT INTO `ex_question_item` VALUES (10, '计算结果有溢出', NULL, 80, 0, '', NULL, '', NULL, NULL);
INSERT INTO `ex_question_item` VALUES (11, '累加器 A 中的数据有奇数个 1', NULL, 80, 0, '', NULL, '', NULL, NULL);
INSERT INTO `ex_question_item` VALUES (12, '计算结果低 4 位向高位进位', '1', 80, 0, '', NULL, '', NULL, NULL);
INSERT INTO `ex_question_item` VALUES (13, '计算结果有进位', NULL, 81, 0, '', NULL, '', NULL, NULL);
INSERT INTO `ex_question_item` VALUES (14, '计算结果有溢出', NULL, 81, 0, '', NULL, '', NULL, NULL);
INSERT INTO `ex_question_item` VALUES (15, '累加器 A 中的数据有奇数个 1', '1', 81, 0, '', NULL, '', NULL, NULL);
INSERT INTO `ex_question_item` VALUES (16, '计算结果低 4 位向高位进位', '1', 81, 0, '', NULL, '', NULL, NULL);
INSERT INTO `ex_question_item` VALUES (17, '对', '1', 82, 0, '', NULL, '', NULL, NULL);
INSERT INTO `ex_question_item` VALUES (18, '错', NULL, 82, 0, '', NULL, '', NULL, NULL);
INSERT INTO `ex_question_item` VALUES (19, NULL, '数据总线', 83, 0, '', NULL, '', NULL, NULL);
INSERT INTO `ex_question_item` VALUES (20, NULL, '地址总线', 83, 0, '', NULL, '', NULL, NULL);
INSERT INTO `ex_question_item` VALUES (21, NULL, '控制总线', 83, 0, '', NULL, '', NULL, NULL);
INSERT INTO `ex_question_item` VALUES (22, NULL, '数据总线', 84, 0, '', NULL, '', NULL, NULL);

-- ----------------------------
-- Table structure for ex_question_tag
-- ----------------------------
DROP TABLE IF EXISTS `ex_question_tag`;
CREATE TABLE `ex_question_tag`  (
  `question_tag_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '上级id',
  `ancestors` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `question_tag` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '题库类型标签',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`question_tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '题库类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ex_score
-- ----------------------------
DROP TABLE IF EXISTS `ex_score`;
CREATE TABLE `ex_score`  (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `exam_info_id` int(11) NOT NULL COMMENT '考试信息id',
  `dept_id` int(11) NULL DEFAULT NULL COMMENT '部门id',
  `question_id` int(11) UNSIGNED NOT NULL COMMENT '题目id',
  `score` float NOT NULL COMMENT '得分',
  `comment` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL COMMENT '评语',
  `result_type` tinyint(4) NULL DEFAULT NULL COMMENT '批阅结果',
  `review_type` tinyint(4) NULL DEFAULT NULL COMMENT '评阅类型',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`score_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '考试得分' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ex_user
-- ----------------------------
DROP TABLE IF EXISTS `ex_user`;
CREATE TABLE `ex_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户账号',
  `user_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '密码',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '考试员工信息表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
