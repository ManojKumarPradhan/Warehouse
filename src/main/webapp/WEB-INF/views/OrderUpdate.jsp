<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order_Method Update</title>
<style type="text/css">
.err {
	color: red;
}
</style>
</head>
<body>

	<div align="center">
		<header style="width: 650px; font-size: 36px; font-weight: bold">Order
			Method Edit Page</header>
		<table
			style="width: 650px;">
			<form:form action="update" method="POST" modelAttribute="orderMethod">
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Order ID</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="id"
							readonly="true" /></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Order Mode</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:radiobutton
							path="mode" value="sale" />Sale <form:radiobutton path="mode"
							value="purchase" />Purchase <br> <form:errors path="mode"
							cssClass="err" /></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Order Code</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="code" /><br>
						<form:errors path="code" cssClass="err" /></td>
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
						</form:select><br> <form:errors path="method" cssClass="err" /></td>
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
						<br> <form:errors path="dsc" cssClass="err" /></td>
				</tr>
				<tr style="height: 50px">
					<td colspan="3" align="center"><input type="submit"
						value="Create Order Method"
						style="width: 200px; height: 40px; font-size: 15px;"></td>
				</tr>
			</form:form>
		</table>
	</div>
	<div align="center">
		<h2>${message }</h2>
	</div>
</body>
</html>