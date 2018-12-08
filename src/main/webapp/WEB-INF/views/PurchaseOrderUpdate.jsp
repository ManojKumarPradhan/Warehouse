<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Purchase Order Edit</title>
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
	<!-- container start -->
	<div class="container">

		<!-- card start -->
		<div class="card">


			<!-- card Header -->
			<div class="card-header bg-primary text-white">
				<h2>Purchase Order Edit Page</h2>
			</div>


			<!-- card body -->
			<div class="card-body">
				<form:form action="update" method="post"
					modelAttribute="purchaseOrder" cssClass="form">
					<div class="form-group">
						<label for="id" class="control-label col-sm-4">ORDER ID</label>
						<form:input path="id" cssClass="form-control col-sm-4"
							readonly="true" />
					</div>
					<div class="form-group">
						<label for="code" class="control-label col-sm-4">ORDER
							Code</label>
						<form:input path="code" cssClass="form-control col-sm-4" />
						<form:errors path="code" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="shipmentType" class="control-label col-sm-4">Shipment
							Code</label>
						<form:select path="shipmentType.id"
							cssClass="form-control col-sm-4">
							<form:option value="">--Select One--</form:option>
							<form:options items="${shipmentTypes }" itemLabel="code"
								itemValue="id" />
						</form:select>
						<form:errors path="shipmentType" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="whUserType" class="control-label col-sm-4">Vendors</label>
						<form:select path="whUserType" cssClass="form-control col-sm-4">
							<form:option value="">--Select One--</form:option>
							<form:options items="${venders }" itemLabel="code" itemValue="id" />
						</form:select>
						<form:errors path="whUserType" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="refNum" class="control-label col-sm-4">Reference
							Number</label>
						<form:input path="refNum" cssClass="form-control col-sm-4" />
						<form:errors path="refNum" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="qualityCheck" class="control-label col-sm-4">Quality
							Check</label><br>
						<form:radiobutton path="qualityCheck" value="Required"
							class="control-label" />
						Required
						<form:radiobutton path="qualityCheck" value="NotRequired"
							class="control-label" />
						NotRequired<br>
						<form:errors path="qualityCheck" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="status" class="control-label col-sm-4">Status</label>
						<form:input path="status" cssClass="form-control col-sm-4"
							value="OPEN" readonly="true" />
						<form:errors path="status" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="dsc" class="control-label col-sm-4">Purchase
							Order NOTE</label>
						<form:textarea path="dsc" cssClass="form-control col-sm-4" />
						<form:errors path="dsc" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<input type="submit" value="Order Method Register"
							class="btn btn-success" />
					</div>


				</form:form>

			</div>

			<!-- card footer -->
			<c:if test="${message ne null }">
				<div class="card-footer bg-info text-white">${message}</div>
			</c:if>

			<!-- card end -->
		</div>

		<!-- container end -->
	</div>
</body>
</html>