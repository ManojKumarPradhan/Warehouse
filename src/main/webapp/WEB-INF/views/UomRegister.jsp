<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Uom Register</title>
<style type="text/css">
.err {
	color: red;	
}
</style>
</head>
<body>

	<div align="center">
		<header style="width: 600px; font-size: 40px;">UOM Register
			Page</header>
	</div>
	<div align="center">
		<table style="width: 600px;">
			<form:form action="insert" method="POST" modelAttribute="uom">
				<tr style="height: 40px">
					<td style="width: 40%" align="right">UOM Type</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:select path="type">
							<form:option value="">--Select One--</form:option>
							<form:option value="packing">Packing</form:option>
							<form:option value="No Packing">No Packing</form:option>
							<form:option value="NA">--NA--</form:option>
						</form:select> <br> <form:errors path="type" cssClass="err" /></td>
				</tr>
				<tr style="height: 40px">
					<td style="width: 40%" align="right">UOM Model</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="model" /><br>
						<form:errors path="model" cssClass="err" /></td>
				</tr>
				<tr style="height: 40px">
					<td style="width: 40%" align="right">Description</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:textarea path="dsc" /><br>
						<form:errors path="dsc" cssClass="err" /></td>
				</tr>
				<tr style="height: 40px">
					<td colspan="3" align="center"><input type="submit"
						value="Create Uom"
						style="width: 150px; height: 40px; font-size: 15px;"></td>
				</tr>
			</form:form>
		</table>
	</div>
	<div align="center">
		<h2>${message }</h2>
	</div>
</body>
</html>