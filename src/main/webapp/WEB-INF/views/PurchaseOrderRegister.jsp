<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Order Register</title>
<style type="text/css">
.err {
	color: red;
}
</style>
</head>
<body>
	<div align="center">
		<header style="font-size: 30px; font-weight: bold"> Purchase
			Order Register Page </header>
		<table>
			<form:form action="insert" method="POST"
				modelAttribute="purchaseOrder">
					<tr >
					<td>Order Code</td>
					<td>:</td>
					<td><form:input path="code" />
						<br> <form:errors path="code" cssClass="err" /></td>
				</tr>
				<tr>
					<td >Shipment Code</td>
					<td>:</td>
					<td><form:select
							path="shipmentType.id">
							<form:option value="">--Select One--</form:option>
							<form:options items="${shipmentTypes }" itemLabel="code"
								itemValue="id" />
						</form:select> <br> <form:errors path="shipmentType.id" cssClass="err" />
					</td>
				</tr>
				<tr>
					<td>Vender</td>
					<td>:</td>
					<td><form:select
							path="whUserType">
							<form:option value="">--Select One--</form:option>
							<form:options items="${venders }" itemLabel="code" itemValue="id" />
						</form:select> <br> <form:errors path="whUserType" cssClass="err" /></td>
				</tr>
				<tr>
					<td>Reference Number</td>
					<td>:</td>
					<td><form:input path="refNum" />
						<br> <form:errors path="refNum" cssClass="err" /></td>
				</tr>
				<tr>
					<td>Quality Check</td>
					<td>:</td>
					<td><form:radiobutton
							path="qualityCheck" value="Required" />Required<form:radiobutton
							path="qualityCheck" value="NotRequired" />NotRequired <br>
						<form:errors path="qualityCheck" cssClass="err" /></td>
				</tr>
				<tr>
					<td>Status</td>
					<td>:</td>
					<td><form:input path="status"
							value="OPEN" readonly="true" /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td>:</td>
					<td><br> <form:textarea
							path="dsc" /><br> <br> <form:errors path="dsc"
							cssClass="err" /></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><input type="submit"
						value="Placed Order"></td>
				</tr>
			</form:form>
		</table>
	</div>
	<div align="center">
		<h2>${message }</h2>
	</div>
</body>
</html>