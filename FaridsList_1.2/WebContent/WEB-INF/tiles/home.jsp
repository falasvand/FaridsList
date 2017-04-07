<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<table class="comments">
	<c:forEach var="comm" items="${comments}">
		<tr>
			<td class="name"><c:out value="${comm.user.name}"></c:out></td>
			<td class="contact"><a
				href="<c:url value='/message?uid=${comm.username}'/>">contact</a></td>
			<td class="text"><c:out value="${comm.text}"></c:out></td>
		</tr>
	</c:forEach>
</table>



<script type="text/javascript">
function updateMessageLink(data){
	$("#numberOfMessages").text(data.number);
}
function onLoad(){
	updatePage();
	window.setInterval(updatePage, 5000);
}
function updatePage(){
	$.getJSON("<c:url value="/getmessages"/>", updateMessageLink);
}
$(document).ready(onLoad);
</script>


