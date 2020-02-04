package com.min.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")


public class ConnectionPoolTest {
	@Autowired
	//DataSource dataSource = new dataSource();
	private DataSource datasource;
	
	@Autowired
	//DataSource dataSource = new dataSource();
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() {
		try (
				
			SqlSession session = sqlSessionFactory.openSession();
			Connection con = datasource.getConnection();
			){
			System.out.println("session="+session);
			System.out.println("con="+con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
