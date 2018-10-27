<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendor update</title>
</head>
<body>

	<div align="center">
		<h1>Order Vendor Edit Page</h1>
	</div>
	<div align="center">
		<table>
			<form:form action="update" method="POST" modelAttribute="vendor">
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Vendor ID</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="id" />
					</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Vendor Name</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="venName" />
					</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Vendor Code</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:select
							path="venCode">
							<form:option value="">--Select One--</form:option>
							<form:option value="CAT">CAT</form:option>
							<form:option value="RES">RES</form:option>
						</form:select></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Vendor Designation</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:radiobutton
							path="venDesg" value="sale" />Sale<br> <form:radiobutton
							path="venDesg" value="Service" />Service <br> <form:radiobutton
							path="venDesg" value="Both" />Both</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">Preserve</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:checkbox
							path="venPreserve" value="A" />A<br> <form:checkbox
							path="venPreserve" value="B" />B<br> <form:checkbox
							path="venPreserve" value="C" />C</td>
				</tr>
				<tr style="height: 50px">
					<td colspan="3" align="center"><input type="submit"
						value="Update Vendor" width="200px" height="40px"></td>
				</tr>
			</form:form>
		</table>
	</div>
	<div align="center">
		<h2>${message }</h2>
	</div>
</body>
</html>