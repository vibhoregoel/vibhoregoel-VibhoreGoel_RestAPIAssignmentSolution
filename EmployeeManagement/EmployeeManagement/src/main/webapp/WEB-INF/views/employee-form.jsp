<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
      integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
      crossorigin="anonymous">
      
<title>Employee Form</title>
</head>
<body>
<div class="container">
    <h3>Employee Directory</h3>
    <hr>
    <p class="h4 mb-4">Enter Employee Details</p>
    <form action="/api/employees/saveEmployee" method="POST">
        
        <input type="hidden" name="id" value="${Employee.id}"/>
        <div class="form-inline">
            <input type="text" name="firstName" value="${Employee.firstName}" class="form-control mb-4 col-4" placeholder="FirstName"/>
        </div>
        <div class="form-inline">
            <input type="text" name="lastName" value="${Employee.lastName}" class="form-control mb-4 col-4" placeholder="LastName">
        </div>
        <div class="form-inline">
            <input type="text" name="email" value="${Employee.email}" class="form-control mb-4 col-4" placeholder="Email">
        </div>
        
        <button type="submit" class="btn btn-info col-2">Save</button>
    </form>
    <hr>
    <a href="/api/employees/list"> Back to Employees list</a>
</div>
</body>
</html>