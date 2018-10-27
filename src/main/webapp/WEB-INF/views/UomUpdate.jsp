<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Uom update</title>
</head>
<body>

	<div align="center">
		<h1>UOM EDIT Page</h1>
	</div>
	<div align="center">
		<table>
			<form:form action="update" method="POST" modelAttribute="uom">
				<tr style="height: 40px">
					<td style="width: 40%" align="right">UOM ID</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="id" readonly="true"/>
					</td>
				</tr>
				<tr style="height: 40px">
					<td style="width: 40%" align="right">UOM Type</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:select path="type">
							<form:option value="">--Select One--</form:option>
							<form:option value="packing">Packing</form:option>
							<form:option value="No Packing">No Packing</form:option>
							<form:option value="NA">--NA--</form:option>
						</form:select></td>
				</tr>
				<tr style="height: 40px">
					<td style="width: 40%" align="right">UOM Model</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="model" />
					</td>
				</tr>
				<tr style="height: 40px">
					<td style="width: 40%" align="right">Description</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:textarea path="dsc" />
					</td>
				</tr>
				<tr style="height: 40px">
					<td colspan="3" align="center"><input type="submit"
						value="Update"></td>
				</tr>
			</form:form>
		</table>
	</div>
	<div align="center">
		<h2>${message }</h2>
	</div>
</body>
</html>