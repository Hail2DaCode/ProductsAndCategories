<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Page</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class = "super">
		<h1><c:out value = "${ category.name }"/></h1>
		<p><a href = "/">Home</a></p>
		<div>
			<h3>Products:</h3>
			<ul>
				<c:forEach var = "product" items = "${category.products}">
					<li><c:out value = "${ product.name }"/></li>
				</c:forEach>
			</ul>
		</div>
		<div>
			<h2>Add Product:</h2>
			<form action = "/categories/${category.id}/add"  method = "get" >
				<select name = "product">
					<c:forEach var = "oneProduct" items = "${ products }">
						<option value = "${ oneProduct.id }" >
							<c:out value = "${ oneProduct.name }"/>
						</option>
					</c:forEach>
				</select>
				<input class="btn" id ="submit" type = "submit" value="Add"/>
			</form>
		</div>
	</div>
</body>
</html>