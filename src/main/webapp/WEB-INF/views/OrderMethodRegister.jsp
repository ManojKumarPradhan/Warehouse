<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Method Register</title>
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
				<h2>Order Method Register Page</h2>
			</div>


			<!-- card body -->
			<div class="card-body">
				<form:form action="insert" method="post"
					modelAttribute="orderMethod" cssClass="form">
					<div class="form-group">
						<label for="mode" class="control-label col-sm-4">Order
							Mode</label><br>
						<form:radiobutton path="mode" value="sale"
							class="control-label" />
						Sale
						<form:radiobutton path="mode" value="purchase"
							class="control-label" />
						Purchase<br>
						<form:errors path="mode" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="code" class="control-label col-sm-4">ORDER
							Code</label>
						<form:input path="code" cssClass="form-control col-sm-4" />
						<form:errors path="code" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="method" class="control-label col-sm-4">Order
							Method</label>
						<form:select path="method" cssClass="form-control col-sm-4">
							<form:option value="">--Select One--</form:option>
							<form:option value="FIFO">FIFO</form:option>
							<form:option value="LIFO">LIFO</form:option>
							<form:option value="FCFO">FCFO</form:option>
							<form:option value="FEFO">FEFO</form:option>
						</form:select>
						<form:errors path="method" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="accept" class="control-label col-sm-4">UOM
							MODEL</label><br>
						<form:checkbox path="accept" value="Multi-Model" class="control-label"/>
						Multi-Model
						<form:checkbox path="accept" value="Accept Return" class="control-label" />
						Accept Return<br>
						<form:errors path="accept" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label for="dsc" class="control-label col-sm-4">Order NOTE</label>
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