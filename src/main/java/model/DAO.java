package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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

	// Create
	public void insertProduct(JavaBeans produto) {
		String create = "insert into tb_produto(nome, codigo, preco) values (?, ?, ?);";
		try {
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(create);
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getCodigo());
			ps.setDouble(3, produto.getPreco());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
