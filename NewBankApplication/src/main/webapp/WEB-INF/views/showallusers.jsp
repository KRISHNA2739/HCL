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
				<th>id</th>
				<th>username</th>
				<th>password</th>
				<th>userType</th>
				<th>update</th>
				<th>delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="userr">
				<tr>
					<td>${userr.id}</td>
					<td>${userr.username}</td>
					<td>${userr.password}</td>
					<td>${userr.userType}</td>
					<c:if test="${user.userType == 'ADMIN'}">
						<td><a href="updateuser.do?id=${userr.id}">update user</a></td>
						<td><a href="deleteuser.do?id=${userr.id}">delete user</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${user.userType == 'ADMIN' || user.userType == 'EMPLOYEE'}">
		<a href="addaccount.do">add account</a>
	</c:if>
	<c:if test="${user.userType == 'ADMIN'}">
		<a href="adduser.do">add user</a>
		<a href="updateuser.do">update user</a>
		<a href="transactions.do">transactions</a>
		<a href="accountdetails.do">account details</a>
	</c:if>
</body>
</html>