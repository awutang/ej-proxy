package com.ej.proxy.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
* 必须要实现java.lang.reflect.InvocationHandler
* @author: Evan·Jiang
* @date: 2020/1/8 15:11
*/
public class JdkProxyHandler<T> implements InvocationHandler {

    private T target;

    public JdkProxyHandler(T target) {
        this.target = target;
    }

    public T getTarget() {
        return target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = null;
        try {
            System.out.println("执行目标方法前我可以干点啥呢？？？");
            invoke = method.invoke(this.target, args);
        } finally {
            System.out.println("执行目标方法后我还可以干点啥呢？？？\n");
        }
        return invoke;
    }
}
