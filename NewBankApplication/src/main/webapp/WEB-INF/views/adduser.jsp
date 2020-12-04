<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new user</title>
<style>
.error {
color: #EF1313;
font-style: italic;
}

input, select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
</head>
<body>
<div>
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
</div>
</body>
</html>