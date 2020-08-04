package com.bjpowernode.util;

public class serviceFactory {
//这个类模拟了一个service工厂(Factory),用于返回一个代理类的实例
    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();
    }

}
//serviceFactory.getService(new StudentServiceImpl());