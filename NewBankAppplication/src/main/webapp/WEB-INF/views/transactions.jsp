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
			<th>txId</th>
				<th>fromaccountId</th>
				<th>toaccountId</th>
				
				<th>txInfo</th>
				<th>timestamp</th>
				<th>amount</th>
				<th>txType</th>
				

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${transactions}" var="transaction">
				<tr>
					
					<td>${transaction.txId}</td>
					<td>${transaction.fromaccountId.accountId}</td>
					<td>${transaction.toaccountId.accountId}</td>
					<td>${transaction.txInfo}</td>

					<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm"
							value="${transaction.timestamp}" /></td>
					<td>${transaction.amount}</td>
					<td>${transaction.txType}</td>


				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${user.userType == 'ADMIN' || user.userType == 'EMPLOYEE'}">
		<a href="addaccount">add account</a>
	</c:if>
	<c:if test="${user.userType == 'ADMIN'}">
		<a href="adduser">add user</a>
		<a href="home">transfer</a>
		<a href="accountdetails">MAIN HOME</a>

	</c:if>
</body>
</html>