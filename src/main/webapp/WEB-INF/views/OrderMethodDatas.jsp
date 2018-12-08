<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Uoms Data</title>
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
				<h2>WELCOME TO Order METHOD DATA PAGE</h2>
			</div>

			<!-- card body start -->
			<div class="card-body">
				<div class="form-group">
					<a href="excel" class="btn btn-info">Export Excel</a> &nbsp;&nbsp;
					| &nbsp;&nbsp;&nbsp;<a href="pdf" class="btn btn-info">PDF
						Export</a>
				</div>
				<c:choose>
					<c:when test="${!empty orders}">
						<table class="table table-hover">
							<tr>
								<th style="width: 3%">ID</th>
								<th style="width: 12%">Order Mode</th>
								<th style="width: 12%">Order Code</th>
								<th style="width: 12%">Order Method</th>
								<th style="width: 15%">Order Accept</th>
								<th style="width: 36%">DESCRIPTION</th>
								<th colspan="2" style="width: 10%">Operation</th>
							</tr>
							<c:forEach items="${orders }" var="order">
								<tr>
									<td><c:out value="${order.id }"></c:out></td>
									<td><c:out value="${order.mode }"></c:out></td>
									<td><c:out value="${order.code }"></c:out></td>
									<td><c:out value="${order.method }"></c:out></td>
									<td><c:out value="${order.accept }"></c:out></td>
									<td><c:out value="${order.dsc }"></c:out></td>
									<td><a href="edit?id=${order.id}" class="btn btn-primary">EDIT</a></td>
									<td><a href="delete?id=${order.id}" class="btn btn-danger">DELETE</a></td>
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