package com.bjpowernode.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


//这个工具类有两个方法
// 方法一：负责创建一个SqlSession
// 方法二：关闭一个SqlSession
public class sqlSessionUtil {

    private sqlSessionUtil() {
    } //由于此类中都是静态方法，不需要创建实例，为避免实例，把构造方法声明为私有，在其他类中无法调用，鸡贼啊

    private static SqlSessionFactory sqlFactorySession = null;

    static{
        String resource = "mybatis-config.xml";
        InputStream inputStream  = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlFactorySession = new SqlSessionFactoryBuilder().build(inputStream);
    }

    private static ThreadLocal<SqlSession> t = new ThreadLocal<SqlSession>();

    public static SqlSession createSession(){
        SqlSession session=t.get();
        //第一次如果ThreadLocal中没有session，就创建一个
        //只有的每一次，TL中都有session，就使用TL中的， 确保每次使用的都是同一个session
        if (session == null){session = sqlFactorySession.openSession();
        t.set(session);
        }
        return session;
    }  //创建一个SqlSession

    public static void myclose(SqlSession session){
        if(session != null){
            session.close();
            t.remove();
        }
    }
}
