<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">

function onLoad(){
	$("#password").keyup(checkPasswordsMatch);
	$("#confirmpass").keyup(checkPasswordsMatch);
	$("#details").submit(canSubmit);
}

function canSubmit(){
	var password = $("#password").val();
	var confirmpass = $("#confirmpass").val();
	
	if(password != confirmpass){
		alert("Passwords do not match!");
		return false;
	}else{
		return true;
	}
}
	
function checkPasswordsMatch(){
	var password = $("#password").val();
	var confirmpass = $("#confirmpass").val();
	
	if(password.length > 3 || confirmpass.length > 3){
		if(password == confirmpass){
			$("#matchpass").text("Passwords match.").addClass("valid").removeClass("error");
		}else{
			$("#matchpass").text("Passwords do not match.").addClass("error").removeClass("valid");
		}
	}
}

$(document).ready(onLoad);

</script>