<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
</head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>
	<div class="container" style="margin-top: 50px;">
		<h1 style="margin-bottom: 20px">${product.name}</h1>
		<div class="d-flex" style="margin-bottom: 20px;">
			<a href="/products/new" style="margin-right:10px;">Create Product</a>
        	<a href="/categories/new">Create Category</a>
		</div>
		<div class="d-flex">
			<div style="width: 500px">
				<h3>Categories:</h3>
                <ul>
                	<c:forEach items="${product.categories}" var="category">
                		<li>${category.name}</li>
                	</c:forEach>
                </ul>
			</div>
			<div style="width: 500px">
				<h3>Add Category:</h3>
                <form action="/joinCategory/${product.id}" method="post">
                    <select name="selectCategory">
                        <c:forEach items="${allCategories}" var="category">
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Add">
                </form>
			</div>
		</div>
	</div>
</body>
</html>