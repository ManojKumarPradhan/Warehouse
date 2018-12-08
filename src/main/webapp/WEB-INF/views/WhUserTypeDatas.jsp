<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Data</title>
</head>
<body>
	<div align="center">
		<table style="width: 90%;" border="1">
			<caption>
				<font size="8"> ALL WAREHOUSE USER DATA </font>
			</caption>
			<tr bgcolor="#00FF7F">
				<td colspan="11"><a href="excel" style="">Export Excel</a>
					&nbsp;&nbsp; | &nbsp;&nbsp;<a href="pdf">PDF Export</a></td>
			</tr>
			<tr style="height: 30px">
				<th style="width: 3%">ID</th>
				<th style="width: 10%">User Type</th>
				<th style="width: 12%">User Code</th>
				<th style="width: 10%">User ForType</th>
				<th style="width: 17%">User Email</th>
				<th style="width: 10%">User Contact</th>
				<th style="width: 8%">User ID Type</th>
				<th style="width: 10%">Other ID</th>
				<th style="width: 12%">ID Number</th>
				<th colspan="2" style="width: 10%">Operation</th>
			</tr>
			<c:forEach items="${whUserTypes }" var="user">
				<tr style="height: 40px" align="center">
					<td><c:out value="${user.id }"></c:out></td>
					<td><c:out value="${user.type }"></c:out></td>
					<td><c:out value="${user.code }"></c:out></td>
					<td><c:out value="${user.forType }"></c:out></td>
					<td><c:out value="${user.email }"></c:out></td>
					<td><c:out value="${user.contact }"></c:out></td>
					<td><c:out value="${user.idType }"></c:out></td>
					<td><c:out value="${user.ifOther }"></c:out></td>
					<td><c:out value="${user.idNum }"></c:out></td>
					<td><a href="delete?id=${user.id }"> <input type="button"
							value="Delete">
					</a></td>
					<td><a href="edit?id=${user.id }"> <input type="button"
							value="Update">
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<br>
	<div align="center">
		<font size="6" color="red">${message }</font>
	</div>
</body>
</html>