<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipment Data</title>
</head>
<body>
	<div align="center">
		<table style="width: 80%;" border="1">
			<caption>
				<font size="8"> ALL SHIPMENT DATA </font>
			</caption>
			<tr>
				<td colspan="8"><a href="excel" style="">Export Excel</a>
					&nbsp;&nbsp; | &nbsp;&nbsp;<a href="pdf">PDF Export</a></td>
			</tr>
			<tr style="height: 30px">
				<th style="width: 3%">ID</th>
				<th style="width: 12%">Shipment Mode</th>
				<th style="width: 12%">Shipment Code</th>
				<th style="width: 12%">Enable Shipment</th>
				<th style="width: 15%">Shipment Grade</th>
				<th style="width: 36%">DESCRIPTION</th>
				<th colspan="2" style="width: 10%">Operation</th>
			</tr>
			<c:forEach items="${shipmentTypes }" var="shipmentType">
				<tr style="height: 40px" align="center">
					<td><c:out value="${shipmentType.id }"></c:out></td>
					<td><c:out value="${shipmentType.mode }"></c:out></td>
					<td><c:out value="${shipmentType.code }"></c:out></td>
					<td><c:out value="${shipmentType.enabled }"></c:out></td>
					<td><c:out value="${shipmentType.grade }"></c:out></td>
					<td><c:out value="${shipmentType.dsc }"></c:out></td>
					<td><a href="delete?id=${shipmentType.id }"> <input
							type="button" value="Update">
					</a></td>
					<td><a href="edit?id=${shipmentType.id }"> <input
							type="button" value="Update">
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<br>
	<div align="center">
		<font size="6">${message }</font>
	</div>
</body>
</html>