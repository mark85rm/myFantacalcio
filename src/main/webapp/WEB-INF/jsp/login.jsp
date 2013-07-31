<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<body onload='document.f.j_username.focus();'>
<c:if test="${empty accessonegato}">
 
	<c:if test="${not empty error}">
	<div class="row">
		<div class="alert label small-12 large-12 columns">
		<spring:message code="label.loginnotsuccessful" />
			<br />
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</div>
	</c:if>
 <fieldset>
    <legend>
    	<spring:message code="label.login.legend" />  
    		<a href="<c:url value="/user/register" />" >
				<spring:message code="label.register" />
			</a>
    </legend>
	<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>
 
		 <div class="row">
		 	<div class="small-12 large-4 columns">User:</div>
		   <div class="small-12 large-8 columns"><input type='text' name='j_username' value=''></div>
		 </div>
		  <div class="row">
		 	<div class="small-12 large-4 columns">Password:</div>
		   <div class="small-12 large-8 columns"><input type='password' name='j_password' value=''></div>
		 </div>
		   <div class="row">
		
		   <div class="small-12 large-12 columns right"><input name="submit" type="submit" class="button radius"
							value="Login" />
			<input name="reset" class="button radius" type="Reset" />
			
			</div>
		 </div>
	</form>
</fieldset>
	</c:if>
	
	<c:if test="${not empty accessonegato}">
	<div class="row">
		<div class="alert label small-12 large-12 columns">
			<spring:message code="label.functionnotammitted" />
		</div>
	</div>
	</c:if>
</body>
</html>