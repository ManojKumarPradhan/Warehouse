<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items Data</title>
</head>
<body>
	<div align="center">
		<table style="width: 85%;" border="1">
			<caption>
				<font size="8"> ALL ITEMs DATA </font>
			</caption>
			<tr>
				<td colspan="15"><a href="excel" style="">Export Excel</a>
					&nbsp;&nbsp; | &nbsp;&nbsp;<a href="pdf">PDF Export</a></td>
			</tr>
			<tr style="height: 30px">
				<th style="width: 3%">ID</th>
				<th style="width: 10%">Item Code</th>
				<th style="width: 5%">Height</th>
				<th style="width: 5%">Length</th>
				<th style="width: 5%">Width</th>
				<th style="width: 10%">Cost</th>
				<th style="width: 6%">Currency</th>
				<th style="width: 12%">UOM</th>
				<th style="width: 10%">Sale</th>
				<th style="width: 10%">Purchase</th>
				<th style="width: 10%">Vendor</th>
				<th style="width: 10%">Customer</th>
				<th style="width: 14%">Description</th>
				<th colspan="2" style="width: 10%">Operation</th>
			</tr>
			<c:forEach items="${items }" var="item">
				<tr style="height: 40px" align="center">
					<td><c:out value="${item.id }"></c:out></td>
					<td><c:out value="${item.itemCode }"></c:out></td>
					<td><c:out value="${item.height }"></c:out></td>
					<td><c:out value="${item.length }"></c:out></td>
					<td><c:out value="${item.width }"></c:out></td>
					<td><c:out value="${item.itemCost }"></c:out></td>
					<td><c:out value="${item.currency }"></c:out></td>
					<td><c:out value="${item.uom.model }"></c:out></td>
					<td><c:out value="${item.saleType.code }"></c:out></td>
					<td><c:out value="${item.purchaseType.code }"></c:out></td>
					<td><c:forEach items="${item.venderType }" var="vender">
							<c:out value="${vender.code }"></c:out>
						</c:forEach></td>
					<td><c:forEach items="${item.customerType }" var="customer">
							<c:out value="${customer.code }"></c:out>
						</c:forEach></td>
					<td><c:out value="${item.dsc }"></c:out></td>
					<td><a href="delete?id=${item.id }"> <input type="button"
							value="Delete">
					</a></td>
					<td><a href="edit?id=${item.id }"> <input type="button"
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