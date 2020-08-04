package com.bjpowernode.util;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


//这个类主要是为了创建代理类，代理类对增删改 功能进行了加强:自动提交事务，
//由于查询类不需要提交事务，所有对查询类并没有实质的增强，只不过在开发过程中，
//统一走代理流程。
public class TransactionInvocationHandler implements InvocationHandler {

    private Object target;

    public TransactionInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        SqlSession session = null;
        Object obj = null;

        try{
            session = sqlSessionUtil.createSession();//这行有必要写吗？在StudentDaoImpl中已经获取了一个session呀?
            obj = method.invoke(target,args);   //target 的方法

            session.commit();            //target的增强
        }catch (Exception e){
            e.getStackTrace();
        }

        return obj;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
