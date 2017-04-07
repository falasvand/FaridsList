<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
	<c:choose>
	<c:when test="${hasComment}">
			<a href="${pageContext.request.contextPath}/createcomment">Edit/Delete
				current Ad</a>
	</c:when>
	<c:otherwise>
			<a href="${pageContext.request.contextPath}/createcomment">Create
				a new Ad</a>
	</c:otherwise>
</c:choose>
&nbsp;
<sec:authorize access="hasRole('ROLE_ADMIN')">
		<a href="${pageContext.request.contextPath}/admin">Admin</a>
</sec:authorize>
&nbsp;
<sec:authorize access="isAuthenticated()">
	<a href="${pageContext.request.contextPath}/messages">Messages (<span id="numberOfMessages">0</span>)</a>
</sec:authorize>