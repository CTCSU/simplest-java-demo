package com.SimplestDemo.simplestAOP;

public class DoSomething {
    //AOP对于已经切入过的方法,如果其内部仍有方法需要切入,不再切入
    public void doSomething() {
        sayHello();
    }

    public void sayHello(){
        System.out.println("HelloWo  World");
    }

    public DoSomething() {
    }
}
