<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
</head>
<body>
	<div class="container" style="margin-top: 50px;">
		<h1 style="margin-bottom: 20px">${category.name}</h1>
		<div class="d-flex" style="margin-bottom: 20px;">
			<a href="/products/new" style="margin-right:10px;">Create Product</a>
        	<a href="/categories/new">Create Category</a>
		</div>
		<div class="d-flex">
			<div style="width: 500px">
				<h3>Products:</h3>
                <ul>
                	<c:forEach items="${category.products}" var="product">
                		<li>${product.name}</li>
                	</c:forEach>
                </ul>
			</div>
			<div style="width: 500px">
				<h3>Add Product:</h3>
                <form action="/joinProduct/${category.id}" method="post">
                    <select name="selectProduct">
                        <c:forEach items="${allProducts}" var="product">
                            <option value="${product.id}">${product.name}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Add">
                </form>
			</div>
		</div>
	</div>
</body>
</html>