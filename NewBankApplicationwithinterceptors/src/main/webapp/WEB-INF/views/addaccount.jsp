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
<form:form action="addaccount.do" method="post" modelAttribute="account">
	<form:hidden path="accountId" value="0"/>
	<table>
		<tr>
			<td>Enter name</td>
			<td><form:input path="name"/><form:errors path="name" class="error"/></td>
		</tr>
		<tr>
			<td>Enter balance</td>
			<td><form:input path="balance"/><form:errors path="balance" class="error"/></td>
		</tr>
		<tr>
			<td>Enter address</td>
			<td><form:input path="address"/><form:errors path="address" class="error"/></td>
		</tr>
		<tr>
			<td>Enter phone</td>
			<td><form:input path="phone"/><form:errors path="phone" class="error"/></td>
		</tr>
		<tr>
			<td>Enter email</td>
			<td><form:input path="email"/><form:errors path="email" class="error"/></td>
		</tr>
		<tr>
			<td>Enter aadharCard</td>
			<td><form:input path="aadharCard"/><form:errors path="aadharCard" class="error"/></td>
		</tr>
		
		<tr>
			<td>Enter birthDate</td>
			<td><form:input path="birthDate"/><form:errors path="birthDate" class="error"/></td>
		</tr>
		<tr>
			<td>Enter panNumber</td>
			<td><form:input path="panNumber"/><form:errors path="panNumber" class="error"/></td>
		</tr>
		<tr>
			<td>Select account Type</td>
			<td><form:select path="accountType" items="${accountTypes}"/></td>
		</tr>
		
		<tr>
			<td><input type="submit"></td>
		</tr>
	</table>
</form:form>
</body>
</html>