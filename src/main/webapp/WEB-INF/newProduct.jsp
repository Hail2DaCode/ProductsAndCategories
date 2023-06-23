<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class = "super">
		<h2>New Product</h2>
		<p><a href = "/">Home</a></p>
		<form:form class="form" action="/new/product" method = "post" modelAttribute="product">
		<div class="add" id = "add1">
			<form:label path="name">Name:</form:label>
			<form:errors class="error" path = "name"/>
			<form:input path="name"/>
		</div>
		<div class="add" id = "add2">
			<form:label path="description">Description:</form:label>
			<form:errors class="error" path = "description"/>
			<form:input path="description"/>
		</div>
		<div class="add" id = "add3">
			<form:label path="price">Price:</form:label>
			<form:errors class="error" path = "price"/>
			<form:input path="price" type = "number" step = "0.01"/>
		</div>
		<div class = "add" id = "add5">
			<input class="btn" id ="submit" type = "submit" value="Submit"/>
		</div>
	</form:form>
	</div>
</body>
</html>