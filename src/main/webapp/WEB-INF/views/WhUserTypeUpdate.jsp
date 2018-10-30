<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WhUserType Update</title>
</head>
<body>

	<div align="center">
		<h1
			style="width: 600px; background-color: lightgreen; border-top-left-radius: 25px; border-top-right-radius: 25px;">Warehouse
			User Type Edit Page</h1>
	</div>
	<div align="center">
		<table
			style="background-color: lightgray; width: 600px; border-bottom-left-radius: 25px; border-bottom-right-radius: 25px;">
			<form:form action="update" method="POST" modelAttribute="whUserType">
				<tr style="height: 50px">
					<td style="width: 40%" align="right">User ID</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="id" />
					</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">User Type</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:radiobutton
							path="type" value="Vender" />Vender <form:radiobutton
							path="type" value="Customer" />Customer</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">User Code</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="code" />
					</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">User ForType</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="forType"
							readonly="true" /></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">User Email Id</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="email" />
					</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">User Contact</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="contact" />
					</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">User ID Type</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:select path="idType">
							<form:option value="">--Select One--</form:option>
							<form:option value="PanCard">PanCard</form:option>
							<form:option value="Aadhar">Aadhar</form:option>
							<form:option value="VoterID">VoterID</form:option>
							<form:option value="Other">Other</form:option>
						</form:select></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">If Other</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="ifOther" />
					</td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">ID Number</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="idNum" />
					</td>
				</tr>
				<tr style="height: 50px">
					<td colspan="3" align="center"><input type="submit"
						value="Update User"
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