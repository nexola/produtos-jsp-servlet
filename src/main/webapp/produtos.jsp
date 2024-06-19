<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> list = (ArrayList<JavaBeans>) request.getAttribute("produtos");
%>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="UTF-8">
<title>Produtos</title>
<link rel="icon" href="images/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Lista de produtos</h1>
	<a href="novo.html" class="btn1">Novo produto</a>
	<table id="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Código</th>
				<th>Preço</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (JavaBeans product : list) {
			%>
			<tr>
				<td><%=product.getId()%></td>
				<td><%=product.getNome()%></td>
				<td><%=product.getCodigo()%></td>
				<td><%=product.getPreco()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>
