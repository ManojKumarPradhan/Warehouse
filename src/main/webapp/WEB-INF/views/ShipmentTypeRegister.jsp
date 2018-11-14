<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipment Register</title>
<style type="text/css">
.err{
	color: red;
}
</style>
</head>
<body>

	<div align="center">
		<header style="width: 650px; font-size: 40px; font-weight: bold">Shipment
			Type Register Page</header>
	</div>
	<div align="center">
		<table style="width: 650px;">
			<form:form action="insert" method="POST"
				modelAttribute="shipmentType">
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Shipment Mode</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:select path="mode">
							<form:option value="">--Select One--</form:option>
							<form:option value="Air">Air</form:option>
							<form:option value="Truck">Truck</form:option>
							<form:option value="Ship">Ship</form:option>
							<form:option value="Train">Train</form:option>
						</form:select> <br>
					<form:errors path="mode" cssClass="err"/></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Shipment Code</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="code" /><br>
					<form:errors path="code" cssClass="err"/></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Enable Shipment</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:checkbox
							path="enabled" value="Yes" />Yes <br>
					<form:errors path="enabled" cssClass="err"/></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Shipment Grade</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:radiobutton
							path="grade" value="A" />A <form:radiobutton path="grade"
							value="B" />B<form:radiobutton path="grade" value="C" />C <br>
					<form:errors path="grade" cssClass="err"/></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Description</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:textarea path="dsc" /><br>
					<form:errors path="dsc" cssClass="err"/></td>
				</tr>
				<tr style="height: 50px">
					<td colspan="3" align="center"><input type="submit"
						value="Create Shipment"
						style="width: 150px; height: 40px; font-size: 15px; font-weight: bold"></td>
				</tr>
			</form:form>
		</table>
	</div>
	<div align="center">
		<h2>${message }</h2>
	</div>
</body>
</html>