<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%
JavaBeans product = (JavaBeans) request.getAttribute("produto");
%>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="UTF-8">
<title>Editar produto</title>
<link rel="icon" href="images/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar produto</h1>
	<form name="form-produto" class="form-produto" action="insert">

		<input type="text" name="id" disabled placeholder=<%= product.getId() %>> 
		<input type="text" name="nome" value="<%=product.getNome()%>"> 
		<input type="text" name="codigo" value="<%=product.getCodigo()%>">
		<input type="text" name="preco" value="<%=product.getPreco()%>">

		<button class="btn1 btn-form">Salvar</button>
	</form>

	<script src="scripts/valida.js"></script>
</body>
</html>