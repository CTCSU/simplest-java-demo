package com.chentao.SimplestMybatisDemo;

import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class MybatisMain {
    public static void main(String [] args){
        DBAcess db = new DBAcess();
        SqlSession session = null;
        try {
            session = db.getSqlSession();

            /*
            *   查询有两种方法,一是接口式编程,就是这种,
            *   必须写一个HelloDao借口,然后在相应的sql.xml文件中制定其namespace与类的全名一致
            */
            HelloDao helloDao = session.getMapper(HelloDao.class);
            String result = helloDao.selectMessage();


            /*这种方式不用创建接口
             */
//            String result = session.selectOne("com.chentao.SimplestMybatisDemo.HelloDao.selectMessage");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
