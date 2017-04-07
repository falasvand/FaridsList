<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>List of all Registered Users</h2>
<br/>

<table class="formtable">
	<tr>
		<td>Username</td><td>Email</td><td>Role</td><td>Enabled</td>
	</tr>
	<c:forEach var="u" items="${users}">
		<tr>
			<td><c:out value="${u.username}"></c:out></td>
			<td><c:out value="${u.email}"></c:out></td>
			<td><c:out value="${u.authority}"></c:out></td>
			<td><c:out value="${u.enabled}"></c:out></td>
		</tr>
	</c:forEach>
</table>