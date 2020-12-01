<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update book</title>
</head>
<body>
<form:form action="addbook" method="post" modelAttribute="book">
	<form:hidden path="id"/>
	<table>
		<tr>
			<td>Enter isbn</td>
			<td><form:input path="isbn" readonly="true"/></td>
		</tr>
		<tr>
			<td>Enter title</td>
			<td><form:input path="title" readonly="true"/></td>
		</tr>
		<tr>
			<td>Enter author</td>
			<td><form:input path="author" readonly="true"/> </td>
		</tr>
		<tr>
			<td>Enter pub Date</td>
			<td><form:input path="pubDate" readonly="true"/></td>
		</tr>
		<tr>
			<td>Enter price</td>
			<td><form:input path="price"/></td>
		</tr>
		<tr>
			<td>Select book type</td>
			<td><form:select path="bookType" items="${booktypes}"/></td>
		</tr>
		<tr>
			<td><input type="submit"></td>
		</tr>
	</table>
</form:form>
</body>
</html>