<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item update</title>
</head>
<body>

	<div align="center">
		<header
			style="width: 600px;font-size: 50px; font-weight: bold">Item
			Edit Page</header>
		<table
			style="width: 600px;">
			<form:form action="update" method="POST" modelAttribute="item">
				<tr style="height: 45px">
					<td style="width: 40%" align="right">Item Id</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="id" /></td>
				</tr>
				<tr style="height: 45px">
					<td style="width: 40%" align="right">Item Code</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input
							path="itemCode" /></td>
				</tr>
				<tr style="height: 45px">
					<td style="width: 40%" align="right">Item Dimension</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left">Width<form:input
							path="width" size="3" />&nbsp;&nbsp;Length<form:input
							path="height" size="3" />&nbsp;&nbsp; Height<form:input
							path="length" size="3" />
					</td>
				</tr>
				<tr style="height: 45px">
					<td style="width: 40%" align="right">Item Cost</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input
							path="itemCost" /></td>
				</tr>
				<tr style="height: 45px">
					<td style="width: 40%" align="right">Currency</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:select
							path="currency">
							<form:option value="">--Select One--</form:option>
							<form:option value="INR">INR</form:option>
							<form:option value="USD">USD</form:option>
							<form:option value="AUS">AUS</form:option>
							<form:option value="ERU">ERU</form:option>
						</form:select></td>
				</tr>
				<tr style="height: 45px">
					<td style="width: 40%" align="right">UOM Type</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:select path="uom.id">
							<form:option value="">--Select One--</form:option>
							<form:options items="${uoms }" itemLabel="model" itemValue="id" />
						</form:select></td>
				</tr>
				<tr style="height: 45px">
					<td style="width: 40%" align="right">Order Method type</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left">Sale Type :<br> <form:select
							path="saleType.id">
							<form:option value="">--Select One--</form:option>
							<form:options items="${sales }" itemLabel="code" itemValue="id" />
						</form:select><br> <br> Purchase Type :<br> <form:select
							path="purchaseType.id">
							<form:option value="">--Select One--</form:option>
							<form:options items="${purchases }" itemLabel="code"
								itemValue="id" />
						</form:select><br>
					</td>
				</tr>

				<tr style="height: 45px">
					<td style="width: 40%" align="right">Warehouse User type</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="center">
						<table style="width: 100%">
							<tr>
								<th style="width: 50%" align="center"><br>Item Vender
									Type<br> <form:select path="venderType" multiple="true"
										items="${vendors}" itemLabel="code" itemValue="id">
									</form:select>
								<th style="width: 50%" align="center"><br>Item
									Customer Type<br> <form:select path="customerType"
										multiple="true" items="${customers }" itemLabel="code"
										itemValue="id">
									</form:select></th>
							</tr>
						</table>
					</td>
				</tr>
				<tr style="height: 45px">
					<td style="width: 40%" align="right">Description</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:textarea path="dsc" /></td>
				</tr>
				<tr style="height: 45px">
					<td colspan="3" align="center"><input type="submit"
						value="Update Item"
						style="width: 150px; height: 40px; font-size: 15px; font-weight: bold;"></td>
				</tr>
			</form:form>
		</table>
	</div>
	<div align="center">
		<h2>${message }</h2>
	</div>
</body>
</html>