<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>List of all Registered Users</h2>
<br/>

<table class="formtable">
	<tr>
		<th>Username</th>
		<th>Email</th>
		<th>Role</th>
		<th>Enabled</th>
		<th>Name</th>
		<th>Modify</th>
	</tr>
		<c:forEach items="${users}" var="u">
			<tr>
				<td><c:out value="${u.username}"></c:out></td>
				<td><c:out value="${u.name}"></c:out></td>
				<td><c:out value="${u.email}"></c:out></td>
				<td><c:out value="${u.authority}"></c:out></td>
				<td><c:out value="${u.enabled}"></c:out></td>
				<td>
					<c:if test="${u.enabled != false}">
						<form action="${pageContext.request.contextPath}/disableuser" method="POST">
							<input type="hidden" name="username" value="${u.username}" />
							<input type="submit" value="Disable" />
						</form>
					</c:if>
					<c:if test="${u.enabled == false}">
						<form action="${pageContext.request.contextPath}/enableuser" method="POST">
							<input type="hidden" name="username" value="${u.username}" />
							<input type="submit" value="Enable" />
						</form>
					</c:if>
				</td>
			</tr>
		</c:forEach>
</table>
<p>
<a href="${pageContext.request.contextPath}/">Return Home</a>
</p>