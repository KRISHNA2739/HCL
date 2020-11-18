<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>

	<tr>
		<th>id</th>
		<th>isbn</th>
		<th>title</th>
		<th>author</th>
		<th>publish date</th>
		<th>price</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="book" items="${books}">
	
	<tr>
		<td>${book.id}</td>
		<td><c:out value="${book.isbn}"></c:out> </td>
		<td><c:out value="${book.title}"></c:out> </td>
		<td><c:out value="${book.author}"></c:out> </td>
		<td><fmt:formatDate pattern="dd/MM/yyyy" value="${book.pubDate }" /> </td>
		<td><c:out value="${book.price}"></c:out> </td>
		<c:if test="${user.profile == 'admin'}">
					<td><a href="BookController?action=update&id=<c:out value="${book.id }"/>">update</a><td>
					<td><a href="BookController?action=deletebook&id=<c:out value="${book.id }"/>">delete</a><td>
				</c:if>
	</tr>
	</c:forEach>
</table>

<br>
<c:if test="${user.profile == 'admin' || user.profile == 'mgr'}">
	<a href="BookController?action=addbook&id=0">add book</a>
	</c:if>
	<a href="LogOutController">logout</a>
</body>
</html>