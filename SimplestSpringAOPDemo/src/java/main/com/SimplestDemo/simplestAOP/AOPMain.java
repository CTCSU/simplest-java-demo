package com.SimplestDemo.simplestAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPMain {
    public static void main(String [] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:*.xml");
        DoSomething doSomething = (DoSomething) context.getBean("doSomething");
        doSomething.doSomething();
        }
}
