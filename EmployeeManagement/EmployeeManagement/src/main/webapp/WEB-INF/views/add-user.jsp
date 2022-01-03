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
      
<title>User Form</title>
</head>
<body>
<div class="container">
    
    <p class="h4 mb-4">Enter User Details</p>
    <form action="/api/users/saveUser" method="POST">
        
        <input type="hidden" name="id" value="${Users.id}"/>
        <div class="form-inline">
            <input type="text" name="username" value="${Users.username}" class="form-control mb-4 col-4" placeholder="Username"/>
        </div>
        <div class="form-inline">
            <input type="text" name="password" value="${Users.password}" class="form-control mb-4 col-4" placeholder="Password">
        </div>
        
        <button type="submit" class="btn btn-info col-2">Save</button>
    </form>
   
</div>
</body>
</html>