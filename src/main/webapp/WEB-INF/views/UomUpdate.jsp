<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Uom Edit</title>
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
				<h2>WELCOME TO UOM EDIT PAGE</h2>
			</div>


			<!-- card body -->
			<div class="card-body">
				<form:form action="update" method="post" modelAttribute="uom"
					cssClass="form">

					<div class="form-group">
						<label for="id" class="control-label col-sm-4">UOM
							ID</label>
						<form:input path="id" cssClass="form-control col-sm-4" readonly="true" />
						<form:errors path="id" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="type" class="control-label col-sm-4">UOM TYPE</label>
						<form:select path="type" cssClass="form-control col-sm-4">
							<form:option value="">--Select One--</form:option>
							<form:option value="packing">Packing</form:option>
							<form:option value="No Packing">No Packing</form:option>
							<form:option value="NA">--NA--</form:option>
						</form:select>
						<form:errors path="type" cssClass="text-danger" />
					</div>


					<div class="form-group">
						<label for="model" class="control-label col-sm-4">UOM
							MODEL</label>
						<form:input path="model" cssClass="form-control col-sm-4" />
						<form:errors path="model" cssClass="text-danger" />
					</div>


					<div class="form-group">
						<label for="dsc" class="control-label col-sm-4">UOM NOTE</label>
						<form:textarea path="dsc" cssClass="form-control col-sm-4" />
						<form:errors path="dsc" cssClass="text-danger" />
					</div>



					<div class="form-group">
						<input type="submit" value="Update UOM" class="btn btn-success" />
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