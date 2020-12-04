<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update account</title>
<style>
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
<form:form action="addaccount.do" method="post" modelAttribute="account">
	<form:hidden path="accountId"/>
	<table>
		<tr>
			<td>Enter name</td>
			<td><form:input path="name" readonly="true"/></td>
		</tr>
		<tr>
			<td>Enter balance</td>
			<td><form:input path="balance"/></td>
		</tr>
		<tr>
			<td>Enter address</td>
			<td><form:input path="address" readonly="true"/></td>
		</tr>
		<tr>
			<td>Enter phone</td>
			<td><form:input path="phone" readonly="true"/></td>
		</tr>
		<tr>
			<td>Enter email</td>
			<td><form:input path="email" readonly="true"/></td>
		</tr>
		<tr>
			<td>Enter aadharCard</td>
			<td><form:input path="aadharCard" readonly="true"/></td>
		</tr>
		
		<tr>
			<td>Enter birthDate</td>
			<td><form:input path="birthDate" readonly="true"/></td>
		</tr>
		<tr>
			<td>Enter panNumber</td>
			<td><form:input path="panNumber" readonly="true"/></td>
		</tr>
		<tr>
			<td>Select account Type</td>
			<td><form:select path="accountType" items="${accountTypes}" readonly="true"/></td>
		</tr>
		
		<tr>
			<td><input type="submit"></td>
		</tr>
	</table>

	<form:hidden path="username"/>
	<form:hidden path="password"/>
	<form:hidden path="accountno"/>
</form:form>
</div>
</body>
</html>