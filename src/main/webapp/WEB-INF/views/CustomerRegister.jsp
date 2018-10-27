<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Register</title>
</head>
<body>

	<div align="center">
		<h1>Customer Register Page</h1>
	</div>
	<div align="center">
		<table>
			<form:form action="insert" method="POST" modelAttribute="customer">
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Customer Code</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input
							path="custCode" /></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Address</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:textarea
							path="custAddr" /></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Customer Locations</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:select
							path="custLocs">
							<form:checkbox path="custLocs" value="HYD" />HYDERABAD
							<form:checkbox path="custLocs" value="BAN" />BAN
							<form:checkbox path="custLocs" value="DEL" />DELI
							<form:checkbox path="custLocs" value="CHN" />CHENNAI
							<form:checkbox path="custLocs" value="KOC" />KOCHI
						</form:select></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Enabled</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:radiobutton
							path="custEnabled" value="YES" />YES <form:radiobutton
							path="custEnabled" value="NO" />NO</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Customer Email ID</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input
							path="custEmail" /></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Customer Contact</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input
							path="custContact" /></td>
				</tr>
				<tr style="height: 50px">
					<td colspan="3" align="center"><input type="submit"
						value="Create Customer" width="30%" height="80%"></td>
				</tr>
			</form:form>
		</table>
	</div>
	<div align="center">
		<h2>${message }</h2>
	</div>
</body>
</html>