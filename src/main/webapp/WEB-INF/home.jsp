<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class = "super">
	<h1>Home Page</h1>
		<div class = "row">
		<p><a href = "/products/new">New Product</a></p>
		<p><a href = "/categories/new">New Category</a></p>
		</div>
		<div class = "main">
			<div class = "section">
				<h2>Products</h2>
				<ul>
					<c:forEach var = "product" items = "${products}">
						<li><a href = "/products/${ product.id }"><c:out value = "${ product.name }"/></a></li>
					</c:forEach>
				</ul>
			</div>
			<div class = "section">
				<h2>Categories</h2>
				<ul>
					<c:forEach var = "category" items = "${categories}">
						<li><a href = "/categories/${category.id }"><c:out value = "${ category.name }"/></a></li>
					</c:forEach>
				</ul>
			</div>
			</div>
		</div>
</body>
</html>