<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h3>Send Message</h3>
	<f:form method="post" commandName="message">
	
	<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
	<input type="hidden" name="_eventId" value="send" />
	
		<table class="formtable">
			<tr>
				<td class="label">Your Name: </td><td><f:input type="text" class="control" path="name" value="${fromName}"/>
				<div class="error"><f:errors path="name"></f:errors></div></td>
			</tr>
			<tr>
				<td class="label">Your email: </td><td><f:input type="text" class="control" path="email" value="${fromEmail}"/>
				<div class="error"><f:errors path="email"></f:errors></div></td>
			</tr>
			<tr>
				<td class="label">Subject: </td><td><f:input type="text" class="control" path="subject"/>
				<div class="error"><f:errors path="subject"></f:errors></div></td>
			</tr>
			<tr>
				<td class="label">Message: </td><td><f:textarea type="text" class="control" path="content"/>
				<div class="error"><f:errors path="content"></f:errors></div></td>
			</tr>
			<tr>
				<td class="label"> </td><td><input type="submit" class="control" value="Send Message" /></td>
			</tr>
		</table>
	</f:form>
