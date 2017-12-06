# Spring IOC示例程序
### 一、文档说明
本项目使用是intellij idea编写的maven项目，最简单的运行方式是作为idea项目导入idea编写。  
如果您不使用idea，使用其他IDE进行java开发，
那么运行本案例你需要保证在项目的lib包中包含本项目需要的所有jar包（用maven方式引入最为方便）；
同时还要求您将resource文件夹加入build目录，使程序运行时，文件夹下的所有内容能够写入到classes文件夹中，用来被主程序读取。

---

### 二、案例说明
 
1. maven依赖只需要引入spring-context包即可，因为context也依赖了core、beans等模块，所以maven会自动下载这几个jar，不是说不需要！
2. 本项目使用ClassPathApplication加载配置文件，其实也可以使用其他的加载器加载配置文件，详细内容可查阅相关文档；
3. 本项目中采用xml配置的方式使用了Spring容器，体现了IOC的一部分功能。另外也可以使用注解和javaConfig的方式实现；

深入了解推荐书籍：《Spring实战》

