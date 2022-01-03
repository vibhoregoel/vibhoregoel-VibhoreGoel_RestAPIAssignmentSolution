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
      
<title>Employee List</title>
</head>
<body>
<div class="container">
    <h3>Employee Directory</h3>
    <hr>
    <form action="/api/employees/search" class="form-inline">
        <a href="/api/employees/showFormForAdd" class="btn btn-primary btn-sm mb-3" style="margin-left: 5vw">Add Employee</a>
       
            <input type="search" name="firstName" placeholder="FirstName" class="form-control-sm mr-2 mb-3" style="margin-left: 5vw"/>
        
            <button type="submit" class="btn btn-success btn-sm mb-3">Search</button>
       
        
            <a href="/api/employees/sort" class="btn btn-primary btn-sm mb-3" style="margin-left: 5vw">Sort Employee</a>
       
            <a href="/api/logout" class="btn btn-primary btn-sm mb-3 mx-auto" style="margin-left: 5vw">Logout</a>
        
    </form>
    
    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
            <tr>
                <th>Id</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
            </tr>
        </thead> 
        <tbody>
            <c:forEach items="${Employees}" var="temp">
                <tr>
                    <td><c:out value="${temp.firstName}" /></td>
                    <td><c:out value="${temp.lastName}" /></td>
                    <td><c:out value="${temp.email}" /></td>
                    <td>
                        <a href="/api/employees/showFormForUpdate?id=${temp.id}" class="btn btn-info btn-sm">Update</a>
                        <a href="/api/employees/delete?id=${temp.id}" class="btn btn-danger btn-sm"
                         onclick="if (!(confirm('Are you sure you want to delete this employee record?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>   
    </table>
</div>
</body>
</html>