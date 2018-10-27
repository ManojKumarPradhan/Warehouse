<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Data</title>
</head>
<body>
	<div align="center">
		<table style="width: 75%; " border="1" >
			<caption style="background-color: aqua;">
				<font size="8" color="green">
					ALL Customer DATA </font>
			</caption>
			<tr bgcolor="lightgray">
				<td colspan="9"><a href="excel" style="">Export Excel</a>
					&nbsp;&nbsp; | &nbsp;&nbsp;<a href="pdf">PDF Export</a></td>
			</tr>
			<tr style="height: 30px">
				<th style="width: 3%">ID</th>
				<th style="width: 12%">Customer Code</th>
				<th style="width: 12%">Address</th>
				<th style="width: 12%">Locations</th>
				<th style="width: 15%">Enabled</th>
				<th style="width: 36%">Email ID</th>
				<th style="width: 36%">Contact</th>
				<th colspan="2" style="width: 10%">Operation</th>
			</tr>
			<c:forEach items="${customers }" var="customer">
				<tr style="height: 40px" align="center">
					<td><c:out value="${customer.custId }"></c:out></td>
					<td><c:out value="${customer.custCode }"></c:out></td>
					<td><c:out value="${customer.custAddr }"></c:out></td>
					<td><c:out value="${customer.custLocs }"></c:out></td>
					<td><c:out value="${customer.custEnabled }"></c:out></td>
					<td><c:out value="${customer.custEmail }"></c:out></td>
					<td><c:out value="${customer.custContact }"></c:out></td>
					<td>
						<a href="delete?id=${customer.custId }">
							<input type="button" value="Delete" style="width: 100%;height: 50px">
						</a>
					</td>
					<td>
						<a href="edit?id=${customer.custId }">
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