package cn.leave.util;

import java.io.IOException;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
 
	private static SqlSessionFactory factory;
	
	static {
		String configFile="mybatis-config.xml";
		
		try {
			InputStream is= Resources.getResourceAsStream(configFile);
			
			factory=new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	
	//创建sqlSession对象和关闭
	public static SqlSession createSqlSession() {
		return factory.openSession(false);
	}
	
	
	//关闭
	public static void closeSqlSession(SqlSession session) {
		if(session!=null) {
			session.close();
		}
	}
	
}
