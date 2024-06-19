package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://dpg-cpplcllds78s73eauvd0-a.oregon-postgres.render.com:5432/db_produto?user=postgresql&password=RcewdXjSTnrcdsG5E4cxVcykcVm6gtVa";
	private String user = "postgresql";
	private String password = "RcewdXjSTnrcdsG5E4cxVcykcVm6gtVa";

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

	// Read
	public ArrayList<JavaBeans> listProducts() {
		String read = "select * from tb_produto order by nome;";

		try {
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(read);
			ResultSet rs = ps.executeQuery();
			ArrayList<JavaBeans> list = new ArrayList<>();
			while (rs.next()) {
				Long id = rs.getLong(1);
				String nome = rs.getString(2);
				String codigo = rs.getString(3);
				Double preco = rs.getDouble(4);
				JavaBeans produto = new JavaBeans(id, nome, codigo, preco);
				list.add(produto);
			}
			conn.close();
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	// Update
	public void selectProduct(JavaBeans product) {
		String select = "select * from tb_produto where id = ?;";
		try {
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(select);
			ps.setLong(1, product.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product.setId(rs.getLong(1));
				product.setCodigo(rs.getString(2));
				product.setNome(rs.getString(3));
				product.setPreco(rs.getDouble(4));
			}	
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateProduct(JavaBeans product) {
		String update = "update tb_produto set nome = ?, codigo = ?, preco = ? where id = ?;";
		try {
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(update);
			ps.setString(1, product.getNome());
			ps.setString(2, product.getCodigo());
			ps.setDouble(3, product.getPreco());
			ps.setLong(4, product.getId());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Delete
	public void deleteProduct(Long id) {
		String delete = "delete from tb_produto where id = ?";
		
		try {
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement(delete);
			ps.setLong(1, id);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
