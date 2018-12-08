<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Orders</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">

		<div class="card">

			<!-- card heading starts -->
			<div class="card-header bg-info text-white">
				<h2>WELCOME TO Purchase Order DATA PAGE</h2>
			</div>

			<!-- card body start -->
			<div class="card-body">
				<div class="form-group">
					<a href="excel" class="btn btn-info">Export Excel</a> &nbsp;&nbsp;
					| &nbsp;&nbsp;&nbsp;<a href="pdf" class="btn btn-info">PDF
						Export</a>
				</div>
				<c:choose>
					<c:when test="${!empty purchaseOrders}">
						<table class="table table-hover">
							<tr>
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
									<td><a href="edit?id=${purchaseOrder.id}"
										class="btn btn-primary">EDIT</a></td>
									<td><a href="delete?id=${purchaseOrder.id}"
										class="btn btn-danger">DELETE</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<div class="text-info">No Data Found in Database</div>
					</c:otherwise>
				</c:choose>
				<!-- card body end -->
			</div>

			<!-- card footer -->
			<c:if test="${message ne null }">
				<div class="card-footer bg-warning">${message}</div>
			</c:if>

			<!-- card end -->
		</div>
		<!-- container end -->
	</div>
</body>
</html>