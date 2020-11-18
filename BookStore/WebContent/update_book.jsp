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
<form action="BookController" method="post">
	<input type="hidden" name="id" value="<c:out value="${book.id }" />" readonly/><br/>
  Enter isbn:<input type="text" name="isbn" value="<c:out value="${book.isbn }" />"readonly/><br/>
  Enter title:<input type="text" name="title" value="<c:out value="${book.title }" />"readonly/><br/>
  Enter author:<input type="text" name="author" value="<c:out value="${book.author }" />"readonly/><br/>
  Enter price:<input type="text" name="price" value="<c:out value="${book.price }"/>"/><br/>
  Enter pubDate:<input type="text" name="pubDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${book.pubDate }" />"readonly/><br/>
  <input type="submit"/>
  
</form>
</body>
</html>