<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order_Method Update</title>
</head>
<body>

	<div align="center">
		<h1>Order Method Edit Page</h1>
	</div>
	<div align="center">
		<table>
			<form:form action="update" method="POST" modelAttribute="orderMethod">
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Order ID</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="id" readonly="true"/>
					</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Order Mode</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:radiobutton
							path="mode" value="sale" />Sale <form:radiobutton path="mode"
							value="purchase" />Purchase</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Order Code</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="code" />
					</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Order Method</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:select path="method">
							<form:option value="">--Select One--</form:option>
							<form:option value="FIFO">FIFO</form:option>
							<form:option value="LIFO">LIFO</form:option>
							<form:option value="FCFO">FCFO</form:option>
							<form:option value="FEFO">FEFO</form:option>
						</form:select></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Order Accept</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:checkbox
							path="accept" value="Multi-Model" />Multi-Model<br> <form:checkbox
							path="accept" value="Accept Return" />Accept Return</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Description</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:textarea path="dsc" />
					</td>
				</tr>
				<tr style="height: 50px">
					<td colspan="3" align="center"><input type="submit"
						value="Update Order Method"></td>
				</tr>
			</form:form>
		</table>
	</div>
	<div align="center">
		<h2>${message }</h2>
	</div>
</body>
</html>