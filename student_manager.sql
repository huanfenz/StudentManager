/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : student_manager

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 21/11/2021 18:27:51
*/

CREATE DATABASE student_manager;
USE student_manager;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for approval
-- ----------------------------
DROP TABLE IF EXISTS `approval`;
CREATE TABLE `approval`  (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NULL DEFAULT NULL,
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reason` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sDate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `eDate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `attName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `att` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `msg` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of approval
-- ----------------------------
INSERT INTO `approval` VALUES (1, 1, '张无忌要请假', '光明顶被围攻，急需回明教!', '请假', '2021-10-05', '2021-10-10', '等待审批', '张无忌的附件.docx', 'attachment/张无忌的附件.docx', '');
INSERT INTO `approval` VALUES (2, 5, '黄蓉要请假', '有考试需要参加，望老师批准', '请假', '2021-10-06', '2021-10-07', '等待审批', '黄蓉的附件.docx', 'attachment/黄蓉的附件.docx', '');
INSERT INTO `approval` VALUES (3, 7, '小龙女要休学', '身体原因，希望休学', '休学', '2021-10-07', '2022-09-01', '等待审批', '小龙女的附件.docx', 'attachment/小龙女的附件.docx', '');

-- ----------------------------
-- Table structure for arrange_course
-- ----------------------------
DROP TABLE IF EXISTS `arrange_course`;
CREATE TABLE `arrange_course`  (
  `ctid` int(11) NOT NULL AUTO_INCREMENT,
  `oid` int(11) NULL DEFAULT NULL,
  `rid` int(11) NULL DEFAULT NULL,
  `weekno` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `week` int(11) NULL DEFAULT NULL,
  `start` int(11) NULL DEFAULT NULL,
  `size` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ctid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of arrange_course
-- ----------------------------
INSERT INTO `arrange_course` VALUES (1, 1, 5, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 1, 1, 2);
INSERT INTO `arrange_course` VALUES (2, 2, 6, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 1, 3, 2);
INSERT INTO `arrange_course` VALUES (3, 4, 7, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 1, 5, 3);
INSERT INTO `arrange_course` VALUES (4, 3, 8, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 2, 1, 2);
INSERT INTO `arrange_course` VALUES (5, 6, 9, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 2, 5, 2);
INSERT INTO `arrange_course` VALUES (6, 7, 10, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 3, 1, 2);
INSERT INTO `arrange_course` VALUES (7, 1, 5, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 4, 3, 2);
INSERT INTO `arrange_course` VALUES (8, 2, 6, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 4, 9, 2);
INSERT INTO `arrange_course` VALUES (9, 3, 7, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 5, 3, 2);
INSERT INTO `arrange_course` VALUES (10, 6, 8, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 5, 5, 2);
INSERT INTO `arrange_course` VALUES (11, 8, 10, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 1, 3, 2);
INSERT INTO `arrange_course` VALUES (12, 9, 9, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 1, 1, 2);
INSERT INTO `arrange_course` VALUES (13, 11, 8, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 1, 5, 3);
INSERT INTO `arrange_course` VALUES (14, 10, 7, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 2, 3, 2);
INSERT INTO `arrange_course` VALUES (15, 13, 6, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 2, 6, 2);
INSERT INTO `arrange_course` VALUES (16, 14, 5, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 3, 3, 2);
INSERT INTO `arrange_course` VALUES (17, 8, 8, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 4, 5, 2);
INSERT INTO `arrange_course` VALUES (18, 9, 7, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 4, 7, 2);
INSERT INTO `arrange_course` VALUES (19, 10, 6, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 5, 1, 2);
INSERT INTO `arrange_course` VALUES (20, 13, 5, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16', 5, 7, 2);
INSERT INTO `arrange_course` VALUES (24, 1, 10, '1,3,5,7,9,11,13,15', 5, 7, 2);

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `people` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, '[教务处]江苏省2021年下半年中小学教师资格考试笔试报名公告', '叶孤城', '2021-10-01', 'article/1-江苏省2021年下半年中小学教师资格考试笔试报名公告.html');
INSERT INTO `article` VALUES (2, '[教务处]关于做好江苏第二师范学院2021届本科毕业设计（论文）抽检评优工作的通知', '花满楼', '2021-10-02', 'article/2-关于做好江苏第二师范学院2021届本科毕业设计（论文）抽检评优工作的通知.html');
INSERT INTO `article` VALUES (3, '[教务处]2021-2022学年校历', '楚留香', '2021-10-03', 'article/3-2021-2022学年校历.html');
INSERT INTO `article` VALUES (4, '[教务处]关于做好2020—2021学年第二学期期末考试工作的通知', '花无缺', '2021-10-04', 'article/4-关于做好2020—2021学年第二学期期末考试工作的通知.html');
INSERT INTO `article` VALUES (5, '[教务处]关于做好2021年秋季江苏省高等学校计算机等级考试报名的通知', '傅红雪', '2021-10-05', 'article/5-关于做好2021年秋季江苏省高等学校计算机等级考试报名的通知.html');
INSERT INTO `article` VALUES (6, '[教务处]江苏省2021年下半年中小学教师资格考试笔试报名公告', '叶孤城', '2021-10-06', 'article/6-江苏省2021年下半年中小学教师资格考试笔试报名公告.html');
INSERT INTO `article` VALUES (7, '[教务处]关于做好江苏第二师范学院2021届本科毕业设计（论文）抽检评优工作的通知', '花满楼', '2021-10-07', 'article/7-关于做好江苏第二师范学院2021届本科毕业设计（论文）抽检评优工作的通知.html');
INSERT INTO `article` VALUES (8, '[教务处]2021-2022学年校历', '楚留香', '2021-10-08', 'article/8-2021-2022学年校历.html');
INSERT INTO `article` VALUES (9, '[教务处]关于做好2020—2021学年第二学期期末考试工作的通知', '花无缺', '2021-10-09', 'article/9-关于做好2020—2021学年第二学期期末考试工作的通知.html');
INSERT INTO `article` VALUES (10, '[教务处]关于做好2021年秋季江苏省高等学校计算机等级考试报名的通知', '傅红雪', '2021-10-10', 'article/10-关于做好2021年秋季江苏省高等学校计算机等级考试报名的通知.html');
INSERT INTO `article` VALUES (11, '[教务处]江苏省2021年下半年中小学教师资格考试笔试报名公告', '叶孤城', '2021-10-11', 'article/11-江苏省2021年下半年中小学教师资格考试笔试报名公告.html');
INSERT INTO `article` VALUES (12, '[教务处]关于做好江苏第二师范学院2021届本科毕业设计（论文）抽检评优工作的通知', '花满楼', '2021-10-12', 'article/12-关于做好江苏第二师范学院2021届本科毕业设计（论文）抽检评优工作的通知.html');
INSERT INTO `article` VALUES (13, '[教务处]2021-2022学年校历', '楚留香', '2021-10-13', 'article/13-2021-2022学年校历.html');
INSERT INTO `article` VALUES (14, '[教务处]关于做好2020—2021学年第二学期期末考试工作的通知', '花无缺', '2021-10-14', 'article/14-关于做好2020—2021学年第二学期期末考试工作的通知.html');
INSERT INTO `article` VALUES (15, '[教务处]关于做好2021年秋季江苏省高等学校计算机等级考试报名的通知', '傅红雪', '2021-10-15', 'article/15-关于做好2021年秋季江苏省高等学校计算机等级考试报名的通知.html');
INSERT INTO `article` VALUES (16, '[教务处]江苏省2021年下半年中小学教师资格考试笔试报名公告', '叶孤城', '2021-10-16', 'article/16-江苏省2021年下半年中小学教师资格考试笔试报名公告.html');

-- ----------------------------
-- Table structure for clazz
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mid` int(11) NULL DEFAULT NULL,
  `cremark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES (1, '19小教1班', 1, '无');
INSERT INTO `clazz` VALUES (2, '20小教1班', 1, '无');
INSERT INTO `clazz` VALUES (3, '19学前1班', 3, '无');
INSERT INTO `clazz` VALUES (4, '20学前1班', 3, '无');
INSERT INTO `clazz` VALUES (5, '19计科1班', 4, '无');
INSERT INTO `clazz` VALUES (6, '19计科2班', 4, '无');
INSERT INTO `clazz` VALUES (7, '20计科1班', 4, '无');
INSERT INTO `clazz` VALUES (8, '20计科2班', 4, '无');
INSERT INTO `clazz` VALUES (9, '19数学1班', 5, '无');
INSERT INTO `clazz` VALUES (10, '19数学2班', 5, '无');
INSERT INTO `clazz` VALUES (11, '20数学1班', 5, '无');
INSERT INTO `clazz` VALUES (12, '19物联网1班', 6, '无');
INSERT INTO `clazz` VALUES (13, '20物联网1班', 6, '无');
INSERT INTO `clazz` VALUES (14, '19汉语言1班', 9, '无');
INSERT INTO `clazz` VALUES (15, '20汉语言1班', 9, '无');
INSERT INTO `clazz` VALUES (16, '20汉语言2班', 9, '无');
INSERT INTO `clazz` VALUES (17, '19英语1班', 11, '无');
INSERT INTO `clazz` VALUES (18, '20英语1班', 11, '无');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courseRemark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`courseId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '高等数学', '无');
INSERT INTO `course` VALUES (2, '线性代数', '无');
INSERT INTO `course` VALUES (3, '概率论与数理统计', '无');
INSERT INTO `course` VALUES (4, '离散数学', '无');
INSERT INTO `course` VALUES (5, '大学英语', '无');
INSERT INTO `course` VALUES (6, '形势与政策', '无');
INSERT INTO `course` VALUES (7, 'C程序设计', '无');
INSERT INTO `course` VALUES (8, '数据结构', '无');
INSERT INTO `course` VALUES (9, '操作系统', '无');
INSERT INTO `course` VALUES (10, '计算机组成原理', '无');
INSERT INTO `course` VALUES (11, '计算机网络', '无');
INSERT INTO `course` VALUES (12, 'Java程序设计', '无');
INSERT INTO `course` VALUES (13, '数据库原理及应用', '无');
INSERT INTO `course` VALUES (14, 'Python程序设计', '无');
INSERT INTO `course` VALUES (15, '人工智能', '无');

-- ----------------------------
-- Table structure for course_grade
-- ----------------------------
DROP TABLE IF EXISTS `course_grade`;
CREATE TABLE `course_grade`  (
  `cgid` int(11) NOT NULL AUTO_INCREMENT,
  `oid` int(11) NULL DEFAULT NULL,
  `sid` int(11) NULL DEFAULT NULL,
  `score` decimal(10, 1) NULL DEFAULT NULL,
  PRIMARY KEY (`cgid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of course_grade
-- ----------------------------
INSERT INTO `course_grade` VALUES (1, 1, 1, 85.0);
INSERT INTO `course_grade` VALUES (2, 1, 2, 87.0);
INSERT INTO `course_grade` VALUES (3, 1, 3, 59.5);
INSERT INTO `course_grade` VALUES (4, 8, 7, 95.5);
INSERT INTO `course_grade` VALUES (5, 8, 8, 87.0);
INSERT INTO `course_grade` VALUES (6, 8, 9, 59.5);
INSERT INTO `course_grade` VALUES (18, 1, 4, 92.0);
INSERT INTO `course_grade` VALUES (19, 1, 5, 85.0);
INSERT INTO `course_grade` VALUES (20, 1, 6, 77.0);
INSERT INTO `course_grade` VALUES (21, 8, 10, 55.0);
INSERT INTO `course_grade` VALUES (22, 8, 11, 44.0);
INSERT INTO `course_grade` VALUES (23, 8, 12, 99.0);
INSERT INTO `course_grade` VALUES (24, 2, 1, 86.0);
INSERT INTO `course_grade` VALUES (25, 2, 2, 75.0);
INSERT INTO `course_grade` VALUES (26, 2, 3, 33.0);
INSERT INTO `course_grade` VALUES (27, 2, 4, 60.0);
INSERT INTO `course_grade` VALUES (28, 2, 5, 95.0);
INSERT INTO `course_grade` VALUES (29, 2, 6, 71.0);
INSERT INTO `course_grade` VALUES (30, 3, 1, 78.0);
INSERT INTO `course_grade` VALUES (31, 3, 2, 64.0);
INSERT INTO `course_grade` VALUES (32, 3, 3, 99.0);
INSERT INTO `course_grade` VALUES (33, 3, 4, 51.0);
INSERT INTO `course_grade` VALUES (34, 3, 5, 77.0);
INSERT INTO `course_grade` VALUES (35, 3, 6, 85.0);

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `mname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mdept` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mremark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES (1, '小学教育', '教育科学学院', '无');
INSERT INTO `major` VALUES (2, '教育技术学', '教育科学学院', '无');
INSERT INTO `major` VALUES (3, '学前教育', '学前教育学院', '无');
INSERT INTO `major` VALUES (4, '计算机科学与技术', '数学与信息技术学院', '无');
INSERT INTO `major` VALUES (5, '数学与应用数学', '数学与信息技术学院', '无');
INSERT INTO `major` VALUES (6, '物联网工程', '数学与信息技术学院', '无');
INSERT INTO `major` VALUES (7, '物理学', '物理与电子工程学院', '无');
INSERT INTO `major` VALUES (8, '电子信息工程', '物理与电子工程学院', '无');
INSERT INTO `major` VALUES (9, '汉语言文学', '文学院', '无');
INSERT INTO `major` VALUES (10, '秘书学', '文学院', '无');
INSERT INTO `major` VALUES (11, '英语', '外国语学院', '无');
INSERT INTO `major` VALUES (13, '生物科学', '生命科学与化学化工学院', '无');
INSERT INTO `major` VALUES (14, '化学', '生命科学与化学化工学院', '无');
INSERT INTO `major` VALUES (15, '财务管理', '商学院', '无');
INSERT INTO `major` VALUES (16, '音乐学', '音乐学院', '无');
INSERT INTO `major` VALUES (19, '美术学', '美术学院', '无');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (1, 'admin', 'admin', '王鹏', '管理员');
INSERT INTO `manager` VALUES (6, 'ygc', 'ygc', '叶孤城', '教务处');
INSERT INTO `manager` VALUES (7, 'fhx', 'fhx', '傅红雪', '教务处');
INSERT INTO `manager` VALUES (8, 'hwq', 'hwq', '花无缺', '教务处');
INSERT INTO `manager` VALUES (9, 'clx', 'clx', '楚留香', '教务处');
INSERT INTO `manager` VALUES (10, 'hml', 'hml', '花满楼', '教务处');

-- ----------------------------
-- Table structure for open_course
-- ----------------------------
DROP TABLE IF EXISTS `open_course`;
CREATE TABLE `open_course`  (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `term` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cid` int(11) NULL DEFAULT NULL,
  `tid` int(11) NULL DEFAULT NULL,
  `courseId` int(11) NULL DEFAULT NULL,
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of open_course
-- ----------------------------
INSERT INTO `open_course` VALUES (1, '2021-2022学年', '第一学期', 7, 1, 1, '基础课');
INSERT INTO `open_course` VALUES (2, '2021-2022学年', '第一学期', 7, 2, 2, '基础课');
INSERT INTO `open_course` VALUES (3, '2021-2022学年', '第一学期', 7, 3, 4, '基础课');
INSERT INTO `open_course` VALUES (4, '2021-2022学年', '第一学期', 7, 4, 5, '专业课');
INSERT INTO `open_course` VALUES (5, '2021-2022学年', '第一学期', 7, 5, 6, '专业课');
INSERT INTO `open_course` VALUES (6, '2021-2022学年', '第一学期', 7, 6, 7, '专业课');
INSERT INTO `open_course` VALUES (7, '2021-2022学年', '第一学期', 7, 7, 10, '专业课');
INSERT INTO `open_course` VALUES (8, '2021-2022学年', '第一学期', 8, 1, 1, '基础课');
INSERT INTO `open_course` VALUES (9, '2021-2022学年', '第一学期', 8, 2, 2, '基础课');
INSERT INTO `open_course` VALUES (10, '2021-2022学年', '第一学期', 8, 3, 4, '基础课');
INSERT INTO `open_course` VALUES (11, '2021-2022学年', '第一学期', 8, 4, 5, '专业课');
INSERT INTO `open_course` VALUES (12, '2021-2022学年', '第一学期', 8, 5, 6, '专业课');
INSERT INTO `open_course` VALUES (13, '2021-2022学年', '第一学期', 8, 6, 7, '专业课');
INSERT INTO `open_course` VALUES (14, '2021-2022学年', '第一学期', 8, 7, 10, '专业课');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `capacity` int(11) NULL DEFAULT NULL,
  `remark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (1, '博1-101', 200, '阶梯教室');
INSERT INTO `room` VALUES (2, '博1-102', 200, '阶梯教室');
INSERT INTO `room` VALUES (3, '博1-201', 200, '阶梯教室');
INSERT INTO `room` VALUES (4, '博1-202', 200, '阶梯教室');
INSERT INTO `room` VALUES (5, '博2-101', 70, '普通教室');
INSERT INTO `room` VALUES (6, '博2-102', 70, '普通教室');
INSERT INTO `room` VALUES (7, '博2-201', 70, '普通教室');
INSERT INTO `room` VALUES (8, '博2-202', 70, '普通教室');
INSERT INTO `room` VALUES (9, '博2-301', 150, '普通教室');
INSERT INTO `room` VALUES (10, '博2-302', 150, '普通教室');
INSERT INTO `room` VALUES (11, '明1-301', 70, '实验室1');
INSERT INTO `room` VALUES (12, '明1-302', 70, '实验室1');
INSERT INTO `room` VALUES (13, '明1-401', 150, '实验室2');
INSERT INTO `room` VALUES (14, '崇1-301', 140, '普通教室');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `snum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ssex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sage` int(11) NULL DEFAULT NULL,
  `cid` int(11) NULL DEFAULT NULL,
  `sstatus` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sremark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `idcard` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `entime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pswd` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '张无忌', '2020710001', '男', 20, 7, '正常', '无', '320282200012121234', '18698765432', '湖北省十堰市丹江口市武当山', '2019-09-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211009223024.jpg');
INSERT INTO `student` VALUES (2, '周芷若', '2020710002', '女', 17, 7, '正常', '无', '320282200012121234', '18698765432', '四川省乐山市峨眉山市峨眉山', '2019-09-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211009223040.jpg');
INSERT INTO `student` VALUES (3, '赵敏', '2020710003', '女', 16, 7, '正常', '无', '320282200012121234', '18698765432', '北京市东城区汝阳王府', '2019-09-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211009223054.jpg');
INSERT INTO `student` VALUES (4, '郭靖', '2020710004', '男', 18, 7, '正常', '无', '320282200012121234', '18698765432', '浙江省杭州市牛家村', '2019-09-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211009223118.jpg');
INSERT INTO `student` VALUES (5, '黄蓉', '2020710005', '女', 16, 7, '正常', '无', '320282200012121234', '18698765432', '浙江省舟山市桃花岛', '2019-09-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211009223136.jpg');
INSERT INTO `student` VALUES (6, '杨过', '2020710006', '男', 17, 7, '正常', '无', '320282200012121234', '18698765432', '陕西省西安市终南山', '2019-09-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211009223155.jpg');
INSERT INTO `student` VALUES (7, '小龙女', '2020710007', '女', 16, 8, '正常', '无', '320282200012121234', '18698765432', '陕西省西安市终南山', '2019-09-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211009223208.jpg');
INSERT INTO `student` VALUES (8, '段誉', '2020710008', '男', 20, 8, '正常', '无', '320282200012121234', '18698765432', '云南省大理市大理皇宫', '2019-09-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211009223226.jpg');
INSERT INTO `student` VALUES (9, '乔峰', '2020710009', '男', 23, 8, '正常', '无', '320282200012121234', '18698765432', '内蒙古赤峰市南院大王府', '2019-09-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211009223246.jpg');
INSERT INTO `student` VALUES (10, '虚竹', '2020710010', '男', 21, 8, '正常', '无', '320282200012121234', '18698765432', '河南省郑州市登封市少林寺', '2019-09-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211009223300.jpg');
INSERT INTO `student` VALUES (11, '王语嫣', '2020710011', '女', 17, 8, '正常', '无', '320282200012121234', '18698765432', '江苏省苏州市吴中区金庭镇曼陀山庄', '2019-09-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211009223320.jpg');
INSERT INTO `student` VALUES (12, '陆冠英', '2020710012', '男', 18, 1, '正常', '无', '320282200012121234', '18698765432', '江苏省无锡市宜兴市周铁镇归云庄', '2019-09-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211009223357.jpg');
INSERT INTO `student` VALUES (13, '贾宝玉', '2020710013', '男', 15, 2, '正常', '无', '320282200012121234', '18698765432', '江苏省南京市秦淮区荣国公府', '2019-09-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211009223448.jpg');
INSERT INTO `student` VALUES (14, '林黛玉', '2020710014', '女', 13, 2, '正常', '无', '320282200012121234', '18698765432', '江苏省苏州市姑苏区林府', '2019-09-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211009223500.jpg');
INSERT INTO `student` VALUES (15, '薛宝钗', '2020710015', '女', 16, 2, '正常', '无', '320282200012121234', '18698765432', '江苏省南京市秦淮区薛府', '2019-09-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211009223516.jpg');
INSERT INTO `student` VALUES (16, '贾探春', '2020710016', '女', 14, 2, '正常', '无', '320282200012121234', '18698765432', '江苏省南京市秦淮区荣国公府', '2019-09-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211009223516.jpg');
INSERT INTO `student` VALUES (17, '王熙凤', '2020710017', '女', 23, 2, '正常', '无', '320282200012121234', '18698765432', '江苏省南京市秦淮区王府', '2019-09-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211009223530.jpg');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tnum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tsex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tage` int(11) NULL DEFAULT NULL,
  `tstatus` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tremark` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `idcard` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `entime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pswd` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pic` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '张三丰', '15001', '男', 121, '正常', '无', '320282190002011234', '13952776288', '湖北省十堰市丹江口市武当山', '2017-07-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211010194556.jpg');
INSERT INTO `teacher` VALUES (2, '王重阳', '15002', '男', 110, '正常', '无', '320282190002011234', '13952776288', '陕西省西安市终南山', '2017-07-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211010193355.jpg');
INSERT INTO `teacher` VALUES (3, '马钰', '15003', '男', 64, '正常', '无', '320282190002011234', '13952776288', '陕西省西安市终南山', '2017-07-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211010193432.jpg');
INSERT INTO `teacher` VALUES (4, '洪七公', '15004', '男', 62, '正常', '无', '320282190002011234', '13952776288', '河南省开封市丐帮总舵', '2017-07-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211010193453.jpg');
INSERT INTO `teacher` VALUES (5, '黄药师', '15005', '男', 57, '正常', '无', '320282190002011234', '13952776288', '浙江省舟山市桃花岛', '2017-07-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211010193516.jpg');
INSERT INTO `teacher` VALUES (6, '柯镇恶', '15006', '男', 53, '正常', '无', '320282190002011234', '13952776288', '浙江省嘉兴市南湖区南湖', '2017-07-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211010193535.jpg');
INSERT INTO `teacher` VALUES (7, '独孤求败', '15007', '男', 120, '正常', '无', '320282190002011234', '13952776288', '湖北省襄阳市城郊', '2017-07-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211010193546.jpg');
INSERT INTO `teacher` VALUES (8, '风清扬', '15008', '男', 115, '正常', '无', '320282190002011234', '13952776288', '陕西省渭南市华阴市华山', '2017-07-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211010193609.jpg');
INSERT INTO `teacher` VALUES (9, '宁中则', '15009', '女', 32, '正常', '无', '320282190002011234', '13952776288', '陕西省渭南市华阴市华山', '2017-07-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211010193633.jpg');
INSERT INTO `teacher` VALUES (10, '岳不群', '15010', '男', 41, '正常', '无', '320282190002011234', '13952776288', '陕西省渭南市华阴市华山', '2017-07-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211010193703.jpg');
INSERT INTO `teacher` VALUES (11, '天山童姥', '15011', '女', 76, '正常', '无', '320282190002011234', '13952776288', '新疆省乌鲁木齐市天山灵鹫宫', '2017-07-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211010193726.jpg');
INSERT INTO `teacher` VALUES (12, '穆人清', '15012', '男', 69, '正常', '无', '320282190002011234', '13952776288', '陕西省渭南市华阴市华山', '2017-07-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211010193801.jpg');
INSERT INTO `teacher` VALUES (13, '陈近南', '15013', '男', 35, '正常', '无', '320282190002011234', '13952776288', '福建省漳州府龙溪县石美村', '2017-07-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211010193823.jpg');
INSERT INTO `teacher` VALUES (14, '九难', '15014', '女', 25, '正常', '无', '320282190002011234', '13952776288', '北京市东城区紫禁城', '2017-07-01', '123456', 'http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/20211010194016.jpg');

SET FOREIGN_KEY_CHECKS = 1;
