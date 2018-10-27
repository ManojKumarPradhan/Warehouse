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
		<table style="width: 75%" border="1">
			<caption>
				<font size="8" color="green">
					ALL UOM DATA </font>
			</caption>
			<tr bgcolor="lightgray">
				<td colspan="8"><a href="excel" style="">Export Excel</a>
					&nbsp;&nbsp; | &nbsp;&nbsp;<a href="pdf">PDF Export</a></td>
			</tr>
			<tr style="height: 30px">
				<th style="width: 3%">ID</th>
				<th style="width: 15%">TYPE</th>
				<th style="width: 20%">MODEL</th>
				<th style="width: 52%">DESCRIPTION</th>
				<th colspan="2" style="width: 10%">Operation</th>
			</tr>
			<c:forEach items="${uoms }" var="uom">
				<tr style="height: 50px" align="center">
					<td><c:out value="${uom.id }"></c:out></td>
					<td><c:out value="${uom.type }"></c:out></td>
					<td><c:out value="${uom.model }"></c:out></td>
					<td><c:out value="${uom.dsc }"></c:out></td>
					<td>
						<a href="delete?id=${uom.id }">
							<input type="button" value="Delete" style="width: 100%;height: 50px">
						</a>
					</td>
					<td>
						<a href="edit?id=${uom.id }">
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