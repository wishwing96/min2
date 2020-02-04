package com.min.controller;

import java.sql.DriverManager;
import java.sql.Connection;

import org.junit.Test;

public class jdbcTest {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = " jdbc:mysql://localhost:3306/min?serverTimezone=Asia/Seoul";
	private static final String USER = "root";
	private static final String PW = "1234";
	
	@Test
	public void testConnection() throws Exception{
	
		Class.forName(DRIVER);
		try(Connection con = DriverManager.getConnection(URL, USER, PW)){
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
}
	
	
}
