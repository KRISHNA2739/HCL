<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new book</title>
<style>
.error {
color: #EF1313;
font-style: italic;
}
</style>
</head>
<body>
<form:form action="adduser.do" method="post" modelAttribute="user">
	<form:hidden path="id" value="0"/>
	<table>
		<tr>
			<td>Enter username</td>
			<td><form:input path="username"/><form:errors path="username" class="error"/></td>
		</tr>
		<tr>
			<td>Enter password</td>
			<td><form:input path="password"/><form:errors path="password" class="error"/></td>
		</tr>
		
		<tr>
			<td>Select user type</td>
			<td><form:select path="userType" items="${userTypes}"/></td>
		</tr>
		
		<tr>
			<td><input type="submit"></td>
		</tr>
	</table>
</form:form>
</body>
</html>