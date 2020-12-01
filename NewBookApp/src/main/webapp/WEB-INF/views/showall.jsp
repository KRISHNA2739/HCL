<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hcl bookstore app</title>
<style type="text/css">
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>

</head>
<body>
<c:if test="${user.userType == 'ADMIN'}">
   <h1>this is shown if ur admin</h1> 
</c:if>

Welcome user ${user.username } | ${user.userType }<br/>


<a href="logout">logout</a>
<table>
    <thead>
        <tr>
            <th>id</th>
            <th>isbn</th>
            <th>title</th>
            <th>author</th>
            <th>pub date</th>
            <th>price</th>
            <th>book type</th>
            <th>update</th>
            <th>delete</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.isbn}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td><fmt:formatDate  pattern="dd/MM/yyyy" value="${book.pubDate}"/></td>
                <td>${book.price}</td>
                 <td>${book.bookType}</td>
                <c:if test="${user.userType == 'ADMIN'}">
                <td><a href="updatebook?id=${book.id}">update book</a></td>
                <td><a href="deletebook?id=${book.id}">delete book</a></td>
                </c:if>
            </tr>
        </c:forEach>
    </tbody>
</table>
<c:if test="${user.userType == 'ADMIN' || user.userType == 'EMPLOYEE'}">
<a href="addbook">addbook</a>
   </c:if>
    <c:if test="${user.userType == 'ADMIN'}">
 <a href="adduser">adduser</a>
   </c:if>
</body>
</html>