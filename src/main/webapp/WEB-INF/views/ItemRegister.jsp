<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Register</title>
<style type="text/css">
.err {
	color: red;
}
</style>
</head>
<body>

	<div align="center">
		<header> Item Register Page </header>
		<table>
			<form:form action="insert" method="POST" modelAttribute="item">
				<tr style="height: 45px">
					<td style="width: 40%" align="right">Item Code</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input
							path="itemCode" /> <br> <form:errors path="itemCode"
							cssClass="err" /></td>
				</tr>
				<tr style="height: 45px">
					<td style="width: 40%" align="right">Item Dimension</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left">Width&nbsp;<form:input
							path="width" size="3" />&nbsp;&nbsp;Length&nbsp;<form:input
							path="length" size="3" />&nbsp;&nbsp; Height&nbsp;<form:input
							path="height" size="3" /> <br> <form:errors path="width"
							cssClass="err" /> <br> <form:errors path="length"
							cssClass="err" /> <br> <form:errors path="height"
							cssClass="err" />
					</td>
				</tr>
				<tr style="height: 45px">
					<td style="width: 40%" align="right">Item Cost</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input
							path="itemCost" /> <br> <form:errors path="itemCost"
							cssClass="err" /></td>
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
						</form:select> <br> <form:errors path="currency" cssClass="err" /></td>
				</tr>
				<tr style="height: 45px">
					<td style="width: 40%" align="right">UOM Type</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:select path="uom.id">
							<form:option value="">--Select One--</form:option>
							<form:options items="${uoms }" itemLabel="model" itemValue="id" />
						</form:select> <br> <form:errors path="uom" cssClass="err" /></td>
				</tr>
				<tr style="height: 45px">
					<td style="width: 40%" align="right">Order Method type</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left">Sale Type :<br> <form:select
							path="saleType.id">
							<form:option value="">--Select One--</form:option>
							<form:options items="${sales }" itemLabel="code" itemValue="id" />
						</form:select> <br> <form:errors path="saleType" cssClass="err" /> <br>
						<br> Purchase Type :<br> <form:select
							path="purchaseType.id">
							<form:option value="">--Select One--</form:option>
							<form:options items="${purchases }" itemLabel="code"
								itemValue="id" />
						</form:select><br><form:errors path="purchaseType"
							cssClass="err" />
					</td>
				</tr>

				<tr style="height: 45px">
					<td style="width: 40%" align="right">Warehouse User type</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="center">
						<table style="width: 100%">
							<tr>
								<th style="width: 50%" align="center"><br>Item Vender
									Type<br> <form:select path="venderType" multiple="true">
										<form:options items="${vendors}" itemLabel="code"
											itemValue="id" />
									</form:select>
								<th style="width: 50%" align="center"><br>Item
									Customer Type<br> <form:select path="customerType"
										multiple="true">
										<form:options items="${customers }" itemLabel="code"
											itemValue="id" />
									</form:select></th>
							</tr>
							<tr>
								<td colspan="2"><form:errors path="venderType"
										cssClass="err" /> <br> <form:errors path="customerType"
										cssClass="err" /></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr style="height: 45px">
					<td style="width: 40%" align="right">Description</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><br> <form:textarea
							path="dsc" /><br> <br><form:errors path="dsc" cssClass="err"/></td>
				</tr>
				<tr style="height: 35px">
					<td colspan="3" align="center"><input type="submit"
						value="Create Item"></td>
				</tr>
			</form:form>
		</table>
	</div>
	<div align="center">
		<h2>${message }</h2>
	</div>
</body>
</html>