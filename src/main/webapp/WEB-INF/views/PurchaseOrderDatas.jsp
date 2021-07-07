<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Orders</title>
</head>
<body>
	<div align="center">
		<table style="width: 85%;" border="1">
			<caption>
				<font size="8"> ALL Purchase Order DATA </font>
			</caption>
			<tr>
				<td colspan="10"><a href="excel" style="">Export Excel</a>
					&nbsp;&nbsp; | &nbsp;&nbsp;<a href="pdf">PDF Export</a></td>
			</tr>
			<tr style="height: 30px">
				<th style="width: 10%">ID</th>
				<th style="width: 10%">Order Code</th>
				<th style="width: 10%">Shipment Type</th>
				<th style="width: 10%">Vender</th>
				<th style="width: 10%">Reference Number</th>
				<th style="width: 10%">Quality</th>
				<th style="width: 10%">Status</th>
				<th style="width: 20%">Note</th>
				<th colspan="2" style="width: 10%">Operation</th>
			</tr>
			<c:forEach items="${purchaseOrders }" var="purchaseOrder">
				<tr style="height: 40px" align="center">
					<td><c:out value="${purchaseOrder.id }"></c:out></td>
					<td><c:out value="${purchaseOrder.code }"></c:out></td>
					<td><c:out value="${purchaseOrder.shipmentType.code }"></c:out></td>
					<td><c:out value="${purchaseOrder.whUserType.code }"></c:out></td>
					<td><c:out value="${purchaseOrder.refNum }"></c:out></td>
					<td><c:out value="${purchaseOrder.qualityCheck }"></c:out></td>
					<td><c:out value="${purchaseOrder.status }"></c:out></td>
					<td><c:out value="${purchaseOrder.dsc }"></c:out></td>
					<td><a href="delete?id=${purchaseOrder.id }"> <input
							type="button" value="Delete">
					</a></td>
					<td><a href="edit?id=${purchaseOrder.id }"> <input
							type="button" value="Update">
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