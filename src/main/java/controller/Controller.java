package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DAO dao = new DAO();
	private JavaBeans produto = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		
		
		if (action.equals("/main")) {
			products(request, response);
		}
		else if (action.equals("/insert")) {
			newProduct(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Listar produtos
	protected void products(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("produtos.jsp");
	}

	// Novo produto
	protected void newProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		produto.setNome(request.getParameter("nome"));
		produto.setCodigo(request.getParameter("codigo"));
		produto.setPreco(Double.valueOf(request.getParameter("preco")));
		dao.insertProduct(produto);
		response.sendRedirect("main");
	}

}
