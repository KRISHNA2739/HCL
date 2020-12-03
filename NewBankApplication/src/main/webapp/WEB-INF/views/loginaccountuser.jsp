<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form action="loginaccountuser" method="post" modelAttribute="accountuser">

	<table>
		<tr>
			<td>Enter username</td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td>Enter password</td>
			<td><form:input path="password" type="password"/></td>
		</tr>
	
		<tr>
			<td><input type="submit"></td>
		</tr>
	</table>
</form:form>

</body>
</html>