## 最简JAVA程序之最简SpringBoot
### 1.运行前说明: 
本项目使用maven进行搭建，如果您的IDE中集成了maven，请直接导入maven项目;

### 2.最简SpringBoot程序的搭建步骤:  
 1. 最为关键的是使用maven来构建程序.创建pom.xml文件,引入相应的starter模块,即可将spring相关的jar包引进来,具体到
 本项目:    
    1. 定义parent,这个会限定spring的版本:  
    2. 引入相应的模块,在本项目中包括:
             
          | 模块 | 作用 |
          |------------|-------------|
          |spring-boot-starter-web|引入web相关的springboot模块|
          |spring-boot-starter-jdbc|引入数据库访问的springboot模块|  
                 
    3. 引入其他的相关技术:包括thymeleaf(用来构建前台页面)和h2Database(用来创建一个运行在内存中的数据库)
     
  2. 按照模块的**约定**创建主体的程序:  
  - Controller:使用@Controller注解标注,使用@RequestMapping映射访问路径(和SpringMVC的用法一致)
  - Repository:对本项目来说,使用jdbc,只需要在相应类中注入JDBCTemplate,使用JDBCTemplate执行sql语句即可.
  - 前台页面相关:Controller返回的string会默认配置在templates目录下,所以将相应的html文件放到这个目录下,
  springBoot将自动去这个目录下寻找资源;
  - 静态资源:默认在static等目录下,所以放在这几个目录下即可.
  
  3. Application的创建:  
  启动SpringBoot需要创建一个带main方法的类启动,并且需要@ComponentScan和@EnableAutoConfiguration开启自动配置,
  然后SpringBoot将会自动所有包中的文件,启动.  
  ```
  package chentao.project;
  
  import org.springframework.boot.SpringApplication;
  import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
  import org.springframework.context.annotation.ComponentScan;
  
  @ComponentScan
  @EnableAutoConfiguration
  public class Application {
      public static void main(String [] args){
          SpringApplication.run(Application.class,args);
      }
  }


   ```
### 3 更多说明:
1. SpringBoot使用约定的方式进行项目的管理,会根据项目中引入的模块自动的开启相关的配置,比如说引入了Jdbc模块,就会根据项目中属性配置
去自动创建Connection,JDBCTemplate的相应的依赖,或者进行注册,简化了XML的配置.
2. SpringBoot中集成了Tomcat模块,所以启动SpringBoot很简单,不需要额外通过IDE配置.