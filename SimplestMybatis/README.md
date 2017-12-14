## 最简程序之Mybatis
### 程序说明:
#### 1:相关jar包  
- mysql-connector-java 5.1.35
- org.mybatis 3.3.0  

#### 2:运行说明:
本项目使用的是mysql数据库,在sql文件夹下的sql文件,使之在mysql中执行,创建了一个Message表,插入了一条
id为1,meesage字段为"Hello Word!"的记录,本项目就要从该表中使用mybatis框架读出这个字段.

### 编写步骤:
- 将相关jar包引入,这里用的是maven方式
- 编辑配置文件,这里是configuration.xml  
  - 配置environments(主要是数据源的获取)
  - 配置mapper文件,即执行的sql文件
```
<configuration>
    <environments default="dev">
        <environment id="dev">
            <transactionManager type="JDBC"></transactionManager>
            <!--配置dotasource的属性-->
            <dataSource type="UNPOOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"></property>
                <property name="url" value="jdbc:mysql://127.0.0.1:3306/SimplestMybatisDemo"></property>
                <property name="username" value="root"></property>
                <property name="password" value="123456"></property>
            </dataSource>
        </environment>
    </environments>

    <mappers>
        <mapper resource="HelloDaoSql.xml"/>
    </mappers>
    
</configuration>
```
- 编辑Sql.xml文件  
文件头:
```<?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE mapper
           PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
```
maper根节点:
```
<!--namespace自己指定也可以,但是如果想要使用接口式编程,
就必须要和接口的全名对应,mysql根据这个找到对应的接口说明,
并且生成一个代理类-->
<mapper namespace="com.chentao.SimplestMybatisDemo.HelloDao">
    <select id="selectMessage" resultType="String">
        select message from Message where id = 1;
    </select>
</mapper>
```

### 其他说明:
关于mybatis的接口式编程,代码里已经说的很明白了;
关键在于创建接口,并且让sql配置文件里的namespace于接口全名对应.sql语句的id语句与接口的方法对应;  
Mybatis使用动态代理的方式生成一个代理类,返回给调用者.  
sqlSession.getMapper(***.class)这样的方式;