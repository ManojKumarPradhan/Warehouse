<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WhUserType Register</title>
<script type="text/javascript" lang="JavaScript">
	function userType(userType) {
		var type;
		if (userType.value == 'Vender') {
			type = 'Purchase';
		} else if (userType.value == 'Customer') {
			type = 'Sale';
		}
		document.getElementById("forType").value = type;
	}
</script>
<style type="text/css">
.err {
	color: red;
}
</style>
</head>
<body>

	<div align="center">
		<header style="width: 700px; font-size: 40px; font-weight: bold">Warehouse
			User Type Register Page</header>
	</div>
	<div align="center">
		<table style="width: 700px;">
			<form:form action="insert" method="POST" modelAttribute="whUserType">
				<tr style="height: 50px">
					<td style="width: 40%" align="right">User Type</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:radiobutton
							path="type" value="Vender" id="type" onclick="userType(this)" />Vender
						<form:radiobutton path="type" value="Customer" id="type"
							onclick="userType(this)" />Customer <br> <form:errors
							path="type" cssClass="err" /></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">User Code</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="code" /><br>
						<form:errors path="code" cssClass="err" /></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">User ForType</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="forType"
							readonly="true" id="forType" /></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">User Email Id</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="email" /><br>
						<form:errors path="email" cssClass="err" /></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">User Contact</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="contact" /><br>
						<form:errors path="contact" cssClass="err" /></td>
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
						</form:select><br> <form:errors path="idType" cssClass="err" /></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">If Other</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="ifOther" /><br>
						<form:errors path="ifOther" cssClass="err" /></td>
				</tr>
				<tr style="height: 50px">
					<td style="width: 40%" align="right">ID Number</td>
					<td style="width: 5%" align="center">:</td>
					<td style="width: 55%" align="left"><form:input path="idNum" /><br>
						<form:errors path="idNum" cssClass="err" /></td>
				</tr>
				<tr style="height: 50px">
					<td colspan="3" align="center"><input type="submit"
						value="Create User"
						style="width: 150px; height: 40px; font-size: 15px; font-weight: bold"></td>
				</tr>
			</form:form>
		</table>
	</div>
	<div align="center">
		<h2>${message }</h2>
	</div>
</body>
</html>