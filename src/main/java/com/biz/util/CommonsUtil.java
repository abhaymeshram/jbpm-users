package com.biz.util;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.stereotype.Service;

@Service
public class CommonsUtil {

	/*@Autowired
	BasicDataSource dataSource;
*/
	public Connection getConnection() {
		Connection conn = null;
		try {
			InitialContext context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:jboss/datasources/jbpmDS");
			conn = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
