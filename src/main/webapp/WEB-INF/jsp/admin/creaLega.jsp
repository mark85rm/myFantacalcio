<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>

<style type="text/css">
label.error { float: none; color: red; padding-left: .5em; vertical-align: top; }
</style>

<script>
$(function() {
   $( "#creaLega" ).validate({
	   rules: {
           nome: {
                   required: true
           }
	   },
	   messages: {
	   			   nome: {
		           required: "Il nome è un campo obbligatorio"
				   }
			   }
	   
   });
});
</script>

 <h3><spring:message code="label.crealega"/></h3>
 
	<form:form method="post" action="addLega" commandName="lega" id="creaLega">
	 
		 <fieldset>
		    <legend><spring:message code="label.crealega.legend" /></legend>
		    
		    	 <div class="row">
				 	<div class="small-12 large-6 columns">
				 		<form:label path="nome"><spring:message code="label.firstname"/></form:label>
				 	</div>
				   <div class="small-12 large-6 columns">
				   		<form:input path="nome" />
				   </div>
				 </div>
				 
				 <div class="row">
				 	<div class="small-12 large-12 columns">
				 		 <input type="submit" value="<spring:message code="label.addcontact"/>"/>
				 	</div>
				 </div>
				 
		</fieldset>
	 
	</form:form>
 
</body>
</html>