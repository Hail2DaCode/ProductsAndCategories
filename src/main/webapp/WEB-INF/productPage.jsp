<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class = "super">
		<h1><c:out value = "${ product.name }"/></h1>
		<p><a href = "/">Home</a></p>
		<div>
			<h3>Categories:</h3>
			<ul>
				<c:forEach var = "category" items = "${product.categories}">
					<li><c:out value = "${ category.name }"/></li>
				</c:forEach>
			</ul>
		</div>
		<div>
			<h2>Add Category:</h2>
			<form action = "/products/${product.id}/add"  method = "get" >
				<select name = "category">
					<c:forEach var = "oneCategory" items = "${ categories }">
						<option value = "${ oneCategory.id }" >
							<c:out value = "${ oneCategory.name }"/>
						</option>
					</c:forEach>
				</select>
				<input class="btn" id ="submit" type = "submit" value="Add"/>
			</form>
		</div>
	</div>
</body>
</html>