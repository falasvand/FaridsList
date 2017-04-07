<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
function onDeleteClick(event){
	var doDelete = confirm("Are you sure you want to delete this Ad?");
	
	if(doDelete==false){
		event.preventDefault();
	}
}
function onReady(){
	$("#delete").click(onDeleteClick);
}
$(document).ready(onReady);
</script>
	<f:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="comment">
	<f:input type="hidden" path="id"/>
		<table class="formtable">
			<tr>
				<td class="label">Advertisement: </td><td><f:textarea name="text" path="text" class="control" rows="10" cols="10"></f:textarea>
				<br/><f:errors path="text" cssClass="error"></f:errors></td>
			</tr>
			<tr>
				<td class="label"> </td><td><input type="submit" class="control" value="Save Advert" />
				<c:if test="${comment.id != 0}">
					<input type="submit" class="control" value="Delete Advert" name="delete" id="delete"/>
				</c:if>
				</td>
			</tr>
		</table>
	</f:form>
