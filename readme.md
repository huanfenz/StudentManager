# 学生管理系统（Student Management System, Created by SSM framework）

[![我的博客](https://img.shields.io/badge/%E6%88%91%E7%9A%84%E5%8D%9A%E5%AE%A2-huanfenz.top-brightgreen)](http://huanfenz.top)	[![演示地址](https://img.shields.io/badge/%E6%BC%94%E7%A4%BA%E5%9C%B0%E5%9D%80-%E7%82%B9%E5%87%BB%E6%9F%A5%E7%9C%8B-blue)](https://github.com/huanfenz/StudentManager#演示地址)	[![联系方式](https://img.shields.io/badge/%E8%81%94%E7%B3%BB%E6%96%B9%E5%BC%8F-%E7%82%B9%E5%87%BB%E6%9F%A5%E7%9C%8B-green)](https://github.com/huanfenz/StudentManager#联系方式)

## 项目介绍

学生管理系统是我从自己学校的综合信息平台得到灵感，于是使用学习过的Spring、SpringMVC、Mybatis框架+LayUI完成了这么一套系统。

项目整体难度不大，部署简单，界面友好，代码结构清晰。系统以CRUD为主，还有一些例如图片上传，附件上传，课表展示等一些小功能也有一些趣味。非常适合初学者学习和练习。

## 环境介绍

| 名称      | 描述                                     |
| --------- | ---------------------------------------- |
| Java版本  | JDK 1.8.0                                |
| IDE工具   | IntelliJ IDEA 2021.2.1(Ultimate Edition) |
| 构建工具  | Maven 3.3.9                              |
| Web服务器 | Tomcat 8.5                               |
| 数据库    | MySQL 5.7                                |

## 搭建步骤

1、数据库导入，新建数据库student_manager，将`student_manager.sql`文件导入并运行。

2、打开项目，使用idea打开项目，在`src/main/resources/jdbc.properties`中修改数据库配置文件

3、运行项目

## 项目截图

登录界面

![image-20211121180252003](http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/202111211802657.png)

管理员首页

![image-20211121180252004](http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/202111211802098.png)

学生管理

![image-20211121180318460](http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/202111211803542.png)

课表展示

![image-20211121180402768](http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/202111211804850.png)

教师录入成绩

![image-20211121180750387](http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/202111211807469.png)

学生查看成绩

![image-20211121180835738](http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/202111211808823.png)

更多功能就在演示地址自己看吧！:smile:

## 演示地址

项目演示地址：http://47.97.104.230:8098/StudentManager/

> 服务器换了JDK11，可能暂时不能使用。

**管理员演示账号**

| 用户名 | 密码  |
| ------ | ----- |
| admin  | admin |

**学生演示账号**

| 学号       | 密码   |
| ---------- | ------ |
| 2020710001 | 123456 |
| 2020710002 | 123456 |

**教师演示账号**

| 职工号 | 密码   |
| ------ | ------ |
| 15001  | 123456 |
| 15002  | 123456 |

>   注意：请试用时尽量不要影响到原有的记录。

## 项目描述

### 数据库结构

![image-20211121190533286](http://wangpeng-imgsubmit.oss-cn-hangzhou.aliyuncs.com/img/202111211905354.png)

## 联系方式

我的博客地址：[个人博客](http://huanfenz.top)，[CSDN博客](https://blog.csdn.net/qq_34245098?spm=1000.2115.3001.5343)。欢迎大家来踩。

我的联系方式，欢迎联系我：

*   邮箱：`huanfenz@qq.com`
*   QQ：`894176237`





