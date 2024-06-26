<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.util.Locale"%>
<%
ArrayList<JavaBeans> list = (ArrayList<JavaBeans>) request.getAttribute("produtos");
%>

<%! public static String formatCurrency(String value) {
    double number = Double.parseDouble(value);
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    return currencyFormatter.format(number);
} %>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="UTF-8">
<title>Produtos</title>
<link rel="icon" href="images/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body id="lista">
	<h1>Lista de produtos</h1>
	
	<% if (list.isEmpty()) { %>
	<p>Comece adicionando algum item a lista!</p>
	<% } else { %>
	
	<table id="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Código</th>
				<th>Preço</th>
				<th style="text-align:center">Opções</th>
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
				<td><%=formatCurrency(String.valueOf(product.getPreco()))%></td>
				<td class="options"><a href="select?id=<%=product.getId()%>" class="btn-edit btn-option">Editar</a>
					<a href="javascript: confirmDeletion(<%=product.getId()%>)" class="btn-delete btn-option">Excluir</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	
	<% } %>
	
	<a href="novo.html" class="btn1">Novo produto</a>
	
	<script src="scripts/excluir.js"></script>
</body>
</html>
