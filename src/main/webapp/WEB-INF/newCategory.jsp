<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class = "super">
		<h2>New Category</h2>
		<p><a href = "/">Home</a></p>
		<form:form class="form" action="/new/category" method = "post" modelAttribute="category">
		<div class="add" id = "add1">
			<form:label path="name">Name:</form:label>
			<form:errors class="error" path = "name"/>
			<form:input path="name"/>
		</div>
		<div class = "add" id = "add5">
			<input class="btn" id ="submit" type = "submit" value="Submit"/>
		</div>
	</form:form>
	</div>
</body>
</html>