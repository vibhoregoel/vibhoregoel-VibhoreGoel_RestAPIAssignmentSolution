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
      
<title>Index</title>
</head>
<body>
<br>
<div class="container">
    <div> 
        <a href="/api/employees/list" class="btn btn-primary btn-sm mb-3">Employee List</a>
         <a href="/api/roles/showFormForAdd" class="btn btn-primary btn-sm mb-3">Add Role</a>
          <a href="/api/users/showFormForAdd" class="btn btn-primary btn-sm mb-3">Add User</a>
    </div>
</div>
</body>
</html>