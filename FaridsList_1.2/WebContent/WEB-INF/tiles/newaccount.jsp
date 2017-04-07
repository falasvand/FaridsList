<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>


<h3>Create New Account</h3>
	<f:form id="details" method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user">
		<table class="formtable">
			<tr>
				<td class="label">Username: </td><td><f:input type="text" class="control" path="username"/>
				<div class="error"><f:errors path="username"></f:errors></div></td>
			</tr>
			<tr>
				<td class="label">Name: </td><td><f:input type="text" class="control" path="name"/>
				<div class="error"><f:errors path="name"></f:errors></div></td>
			</tr>
			<tr>
				<td class="label">Email: </td><td><f:input type="text" class="control" path="email"/>
				<div class="error"><f:errors path="email"></f:errors></div></td>
			</tr>
			<tr>
				<td class="label">Password: </td><td><f:input type="password" id="password" class="control" path="password"/>
				<div class="error"><f:errors path="password"></f:errors></div></td>
			</tr>
			<tr>
				<td class="label">Confirm Password: </td><td><input type="password" id="confirmpass" class="control" name="confirmpass" />
				<div id="matchpass"></div></td>
			</tr>
			<tr>
				<td class="label"> </td><td><input type="submit" class="control" value="Create Account" /></td>
			</tr>
		</table>
	</f:form>
