# 最简SpringMVC：
### 1.运行前说明：
本项目使用maven进行搭建，如果您的IDE中集成了maven，请直接导入maven即可，并将项目所依赖的jar包下载到仓库中；
如果您还未使用MAVEN，请保证在项目中有运行本项目需要的相关jar包，以下为jar包列表，spring的版本为4.1.7
  
  - servlet-api-4.0;
  - servlet-jstl:1.2
  - spring-context;
  - spring-core;
  - spring-web;
  - spring-webmvc;

### 2.SpringMVC搭建的最简单步骤：

| 序号 | 步骤 | 说明 |
| --- | :---------------------------- | : ------------- |
|1|创建目录：src/web-app/WEB-INF|这个目录是用来存放web.xml配置文件的,web容器一般会从这个目录下寻找web的配置文件|
|2|创建jsp页面,一般放在WEB-INF下的jsp子文件夹中|本项目中为hello.jsp||3|创建jsp页面,一般放在WEB-INF下的jsp子文件夹中|本项目中为hello.jsp|
|3|创建Controller(在bean上加上Controller注解并且指定具体方法的RequestMapping)||
|4|创建spring-mvc配置文件:共分四步,不赘述了,具体可以看spring-mvc怎么配置的,其中有注释进行说明.|本项目中为spring-mvc.xml|
|5|创建web.xml文件:①定义dispatcher;②定义spring配置文件的加载路径,一般上使用classPath:这样的方式,这种方式要注意保证spring配置文件所在的目录被编译(复制)到了classes目录下;③定义servlet-mapping|web.xml定义的dispatcher实际上就是一个servlet,负责处理浏览器传过来的请求,具体的配置就是contextConfigLocation所定义的所有文件|  


### 3 SpringMVC说明
**tips**:  
一般来说程序中的**加载顺序**：
web.xml --> spring配置文件 --> 文件中定义的各种包中的java文件;  
一次请求的**执行流程**：


请求 --> servlet-mapping定义的拦截器 -->spring拦截器的配置中通过reqeustMapping找到controller -->Controller执行后，返回一个字符串，由spring配置文件中定义的viewResolver来拼接成对应的地址-->通过链接地址找到相应的页面资源返回给浏览器；  
所以如果前台没有正确返回，应该就是这其中某一个环节出了问题，依次排查即可。




