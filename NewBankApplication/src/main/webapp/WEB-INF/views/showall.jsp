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

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>

</head>
<body>
	<c:if test="${user.userType == 'ADMIN'}">
		<h1>this is shown if ur admin</h1>
	</c:if>

	Welcome user ${user.username } | ${user.userType }
	<br />


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
				<th>update</th>
				<th>delete</th>
				<th>transactions</th>
				<th>Account Status</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${accounts}" var="account">
				<tr>
					<td>${account.accountId}</td>
					<td>${account.name}</td>
					<td>${account.balance}</td>
					<td>${account.address}</td>
					<td>${account.phone}</td>
					<td>${account.email}</td>
					<td>${account.aadharCard}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy"
							value="${account.birthDate}" /></td>
					<td>${account.panNumber}</td>
					<td>${account.accountType}</td>
					<c:if test="${user.userType == 'ADMIN'}">
						<td><a href="updateaccount.do?accountId=${account.accountId}">update account</a></td>
						<td><a href="deleteaccount.do?accountId=${account.accountId}">delete account</a></td>
						<td><a href="transaction.do?accountId=${account.accountId}">account transactions</a></td>
					</c:if>
					<td>${account.accountStatus}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${user.userType == 'ADMIN' || user.userType == 'EMPLOYEE'}">
		<a href="addaccount.do">add account</a>
		
	</c:if>
	<c:if test="${user.userType == 'ADMIN'}">
		<a href="adduser.do">add user</a>
		
		<a href="deposit.do">deposit</a>
		<a href="transactions.do">transactions</a>
	</c:if>
</body>
</html>
