package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
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
		} else if (action.equals("/insert")) {
			newProduct(request, response);
		} else if (action.equals("/select")) {
			listProduct(request, response);
		} else if (action.equals("/update")) {
			updateProduct(request, response);
		} else if (action.equals("/delete")) {
			deleteProduct(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	// Listar produtos
	protected void products(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> list = dao.listProducts();
		request.setAttribute("produtos", list);
		RequestDispatcher rd = request.getRequestDispatcher("produtos.jsp");
		rd.forward(request, response);
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
	
	// Editar contato
	protected void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		produto.setId(Long.valueOf(id));
		dao.selectProduct(produto);
		request.setAttribute("produto", produto);
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}
	
	protected void updateProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		produto.setId(Long.valueOf(request.getParameter("id")));
		produto.setNome(request.getParameter("nome"));
		produto.setCodigo(request.getParameter("codigo"));
		produto.setPreco(Double.valueOf(request.getParameter("preco")));
		dao.updateProduct(produto);
		response.sendRedirect("main");
	}
	
	protected void deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		produto.setId(Long.valueOf(id));
		dao.deleteProduct(produto.getId());
		response.sendRedirect("main");
	}

}
