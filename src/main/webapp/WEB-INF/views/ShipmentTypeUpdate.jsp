<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipment Edit</title>
</head>
<body>

	<div align="center">
		<h1
			style="width: 600px; background-color: lightgreen; border-top-left-radius: 25px; border-top-right-radius: 25px;">Shipment
			Type Edit Page</h1>
	</div>
	<div align="center">
		<table
			style="background-color: lightgray; width: 600px; border-bottom-left-radius: 25px; border-bottom-right-radius: 25px;">
			<form:form action="update" method="POST"
				modelAttribute="shipmentType">
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Shipment ID</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="id" />
					</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Shipment Mode</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:select path="mode">
							<form:option value="">--Select One--</form:option>
							<form:option value="Air">Air</form:option>
							<form:option value="Truck">Truck</form:option>
							<form:option value="Ship">Ship</form:option>
							<form:option value="Train">Train</form:option>
						</form:select></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Shipment Code</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="code" />
					</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Enable Shipment</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:checkbox
							path="enabled" value="Yes" />Yes</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Shipment Grade</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:radiobutton
							path="grade" value="A" />A <form:radiobutton path="grade"
							value="B" />B<form:radiobutton path="grade" value="C" />C</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Description</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:textarea path="dsc" />
					</td>
				</tr>
				<tr style="height: 50px">
					<td colspan="3" align="center"><input type="submit"
						value="Update Shipment"
						style="background-color: lightgreen; width: 150px; height: 40px; border-radius: 15px; border-color: green;"></td>
				</tr>
			</form:form>
		</table>
	</div>
	<div align="center">
		<h2>${message }</h2>
	</div>
</body>
</html>