   新年第一篇 Springboot 技术文诞生。泥瓦匠准备写写 Springboot 相关最佳实践。一方面总结下一些 Springboot 相关，一方面和大家交流交流 Springboot 框架。
   现在业界互联网流行的数据操作层框架 Mybatis，下面详解下 Springboot 如何整合 Mybatis ，这边没有使用 Mybatis Annotation 这种，是使用 xml 配置 SQL。因为我觉得 SQL 和业务代码应该隔离，方便和 DBA 校对 SQL。二者 XML 对较长的 SQL 比较清晰。
#### 一、运行 springboot-mybatis 工程
it clone 下载工程 springboot-learning-example ，项目地址见 GitHub 。下面开始运行工程步骤（Quick Start）：
1. 数据库准备
a.创建数据库 springbootdb：
```sql
CREATE DATABASE springbootdb;
```
b.创建表 city ：(因为我喜欢徒步)
````sql
DROP TABLE IF EXISTS  `city`;
CREATE TABLE `city` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市编号',
  `province_id` int(10) unsigned  NOT NULL COMMENT '省份编号',
  `city_name` varchar(25) DEFAULT NULL COMMENT '城市名称',
  `description` varchar(25) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
````
c.插入数据
```sql
INSERT city VALUES (1 ,1,'温岭市','BYSocket 的家在温岭。');
```
2.项目结构介绍
项目结构如下图所示：
![](pictures/76ec0560266f4997bb2f31fe3e678833.png)
org.spring.springboot.controller – Controller 层

org.spring.springboot.dao – 数据操作层 DAO

org.spring.springboot.domain – 实体类

org.spring.springboot.service – 业务逻辑层

Application – 应用启动类

application.properties – 应用配置文件，应用启动会自动读取配置

3.改数据库配置

打开 application.properties 文件， 修改相应的数据源配置，比如数据源地址、账号、密码等。（如果不是用 MySQL，自行添加连接驱动 pom，然后修改驱动名配置。）

4.编译工程

在项目根目录 springboot-learning-example，运行 maven 指令：
```
mvn clean install
```
5.运行工程

右键运行 Application 应用启动类的 main 函数，然后在浏览器访问：
```
http://localhost:8080/api/city?cityName=温岭市
```
可以看到返回的 JSON 结果：
```
{
    "id": 1,
    "provinceId": 1,
    "cityName": "温岭市",
    "description": "我的家在温岭。"
}
```
