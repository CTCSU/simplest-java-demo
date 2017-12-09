# 最简程序之SpringAOP
### aop简介   
aop是面向切面编程,是一组对象需要的同一功能的集合.  
SringAOP可以使用注解方式和xml配置方式来使用，通常来说，注解方式更常见。

### 如何运行本项目  
在eclipse或者Idea之类的编辑器中，通过导入Maven项目的方式导入本项目，同时注意请保证src/java/main
这一目录下的文件加入了编译目录，能被编译classes文件到项目的目录中；  
另外resources文件夹也需要添加到编译目录；
如果不使用maven进行导入，请保证项目中已经引入的相关的jar包；
本项目依赖jar包为：
Spring-aop；spring-aspects；spring-beans；spring-context；spring-core；spring-expression；
aspectjweaver；commons-logging 1.2；  
spring的jar包我用的使4.1.7版本，如果运行有问题，请确认jar包的版本是否符合要求

### 项目说明:
1.  pom.xml文件中只引用了两个依赖，分别是spring-context（核心依赖包）、Spring-aspects（aop包，不使用aop功能可以不添加）  
因为maven会将被引入jar包的依赖也引入项目中，所以写法上可以简单一些；当然也可以显式地将所有jar包都引入进来，但是要保证jar包地版本是一致的，否则可能会引入多个不同版本的jar包，引起不必要的麻烦；  
spring-context是spring容器的jar包，基本上每个spring项目都要引入；
spring-aspects是springAOP相关的jar包，不使用aop功能可以不引入；
2. SpringAOP的实现步骤：

    1. 引入jar包
    2. 编写被切面增强的类，本项目中是DoSomething
    3. 编写切面类，本项目中是DoAOP
    4. 编写配置文件，本项目中是spring-aop.xml  
    注意头文件的写法
    ```$xslt
    <?xml version="1.0" encoding="UTF-8" ?>
    <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:aop="http://www.springframework.org/schema/aop"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://www.springframework.org/schema/beans
                http://www.springframework.org/schema/beans/spring-beans-4.1.xsd
                http://www.springframework.org/schema/aop
                http://www.springframework.org/schema/aop/spring-aop-4.1.xsd
    ">
```
    接着分别将切面类和被增强类注册给SpringAOP托管  
    然后配置切面（通知+切入点）
    ```
    <aop:config>
            <aop:aspect ref="doAOP">
                <aop:before pointcut="execution(public* *.*(..))" method="doAOPThings" />
            </aop:aspect>
        </aop:config>
    ```

**小tip:** 在本项目运行过程中发现如果被增强的方法调用了本类中的另一个被同一切面增强的方法时，
被调用的方法不会触发通知，执行切面功能。
在本项目中体现为doSomething这个bean在方法doSomething时调用了同类中的方法sayHello()；这两个方法都被增强过，理应都调用切面的方法；
但是sayHello最后并没有触发切面方法  
原因是SpringAOP是使用动态代理来实现AOP的，调用的方法实际上是代理类中的方法，这个代理类的并没有注册到Spring容器托管，自然也就无法进行增强了，所以调用其中的方法是不会被增强的。



