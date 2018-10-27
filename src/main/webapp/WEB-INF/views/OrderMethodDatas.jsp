<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Uoms Data</title>
</head>
<body>
	<div align="center">
		<table style="width: 75%; " border="1" >
			<caption style="background-color: aqua;">
				<font size="8" color="green">
					ALL ORDER METHOD DATA </font>
			</caption>
			<tr style="height: 30px">
				<th style="width: 3%">ID</th>
				<th style="width: 12%">Order Mode</th>
				<th style="width: 12%">Order Code</th>
				<th style="width: 12%">Order Method</th>
				<th style="width: 15%">Order Accept</th>
				<th style="width: 36%">DESCRIPTION</th>
				<th colspan="2" style="width: 10%">Operation</th>
			</tr>
			<c:forEach items="${orders }" var="order">
				<tr style="height: 40px" align="center">
					<td><c:out value="${order.id }"></c:out></td>
					<td><c:out value="${order.mode }"></c:out></td>
					<td><c:out value="${order.code }"></c:out></td>
					<td><c:out value="${order.method }"></c:out></td>
					<td><c:out value="${order.accept }"></c:out></td>
					<td><c:out value="${order.dsc }"></c:out></td>
					<td>
						<a href="delete?id=${order.id }">
							<input type="button" value="Delete" style="width: 100%;height: 50px">
						</a>
					</td>
					<td>
						<a href="edit?id=${order.id }">
							<input type="button" value="Update" style="width: 100%;height: 50px">
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br><br>
	<div align="center">
		<font size="6" color="red">${message }</font>
	</div>
</body>
</html>