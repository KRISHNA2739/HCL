<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hcl Bank app</title>
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

tr {
	background-color: green;
	
}
</style>

</head>
<body>
	

	<a href="logout">logout</a>
	<table>
		<thead>
			<tr>
				<th>accountId</th>
				<th>name</th>
				<th>balance</th>
				<th>address</th>
				<th>phone</th>
				<th>email</th>
				<th>aadharCard</th>
				<th>birthDate</th>
				<th>panNumber</th>
				<th>accountType</th>
				
			</tr>
		</thead>
		<tbody>
			
				<tr>
					<td>${accountuser.accountId}</td>
					<td>${accountuser.name}</td>
					<td>${accountuser.balance}</td>
					<td>${accountuser.address}</td>
					<td>${accountuser.phone}</td>
					<td>${accountuser.email}</td>
					<td>${accountuser.aadharCard}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy"
							value="${accountuser.birthDate}" /></td>
					<td>${accountuser.panNumber}</td>
					<td>${accountuser.accountType}</td>
					
				</tr>
			
		</tbody>
	</table>
	
	
		
	
		<a href="transfer.bo">transfer</a>
		<a href="withdraw.bo">withdraw</a>
		<a href="transactionper.bo">transactions</a>
	
</body>
</html>