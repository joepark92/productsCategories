<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
</head>
<body>
    <div class="container" style="margin-top: 50px;">
        <div style="display: flex;justify-content: space-between;">
            <h1>New Product</h1>
            <a href="/categories/new">Create Category</a>
        </div>
        <form:form action="/addProduct" method="post" modelAttribute="product">
                <div class="form-group row d-flex" style="margin-bottom: 10px;">
                    <form:label path="name">Name:</form:label>
                    <form:input path="name" type="text" style="width: 40%;"/>
                </div>
                <div class="form-group row d-flex" style="margin-bottom: 10px;">
                    <form:label path="description">Description:</form:label>
                    <form:textarea path="description" rows="3" style="width: 40%;"></form:textarea>
                </div>
                <div class="form-group row d-flex" style="margin-bottom: 10px;">
                    <form:label path="price">Price:</form:label>
                    <form:input path="price" type="text" style="width: 40%;"/>
                </div>
                <button type="submit" class="btn btn-primary">Create</button>
        </form:form>
    </div>
</body>
</html>