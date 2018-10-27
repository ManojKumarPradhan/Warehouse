<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendor Data</title>
</head>
<body>
	<div align="center">
		<table style="width: 75%;" border="1">
			<caption style="background-color: aqua;">
				<font size="8" color="green"> ALL VENDOR DATA </font>
			</caption>
			<tr bgcolor="lightgray">
				<td colspan="7"><a href="excel" style="">Export Excel</a>
					&nbsp;&nbsp; | &nbsp;&nbsp;<a href="pdf">PDF Export</a></td>
			</tr>
			<tr style="height: 30px">
				<th style="width: 3%">ID</th>
				<th style="width: 12%">Vendor Name</th>
				<th style="width: 12%">Vendor Code</th>
				<th style="width: 12%">Vendor Designation</th>
				<th style="width: 15%">Vendor Preserve</th>
				<th colspan="2" style="width: 10%">Operation</th>
			</tr>
			<c:forEach items="${vendors }" var="vendor">
				<tr style="height: 40px" align="center">
					<td><c:out value="${vendor.id }"></c:out></td>
					<td><c:out value="${vendor.venName }"></c:out></td>
					<td><c:out value="${vendor.venCode }"></c:out></td>
					<td><c:out value="${vendor.venDesg }"></c:out></td>
					<td><c:out value="${vendor.venPreserve }"></c:out></td>
					<td><a href="delete?id=${vendor.id }"> <input
							type="button" value="Delete" style="width: 100%; height: 50px">
					</a></td>
					<td><a href="edit?id=${vendor.id }"> <input type="button"
							value="Update" style="width: 100%; height: 50px">
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