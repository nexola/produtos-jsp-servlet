package model;

import java.sql.Connection;
import java.sql.DriverManager;


public class DAO {
	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://127.0.0.1:5432/db_produto?useTimezone=true&serverTimezone=UTC";
	private String user = "postgres";
	private String password = "1234";
	
	private Connection connect() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
