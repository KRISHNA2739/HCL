<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer</title>

</head>
<body>
<h3>Welcome</h3>
	<form:form action="withdraw.do?accountId=${accountuser.accountId}" method="post" modelAttribute="withdrawBean">
		<table>
			
			
			<tr>
				<td>Enter amount to be withdraw:</td>
				<td><input type="text" name="amount"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="withdraw amount"></td>
			</tr>
			
		
		</table>
	
	</form:form>

</body>
</html>