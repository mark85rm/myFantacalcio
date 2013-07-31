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
   $( "#registerUser" ).validate({
	   rules: {
           nome: {
                   required: true
           }, 
           cognome: {
               required: true
       		}, 
       		username: {
                required: true
        	},
        	password: {
                required: true
        	},
        	repeatpassword: {
                equalTo: "#password"
        	},
        	mail: {
                required: true,
                email: true
        	},
        	squadranome: {
                required: true
        	}
	   },
	   messages: {
	   			   nome: {
		           required: "<spring:message code='message.obbligatorio.nome'/>"
				   }, 
				   cognome: {
				       required: "<spring:message code='message.obbligatorio.cognome'/>"
					}, 
					username: {
				        required: "<spring:message code='message.obbligatorio.username'/>"
					},
					password: {
				        required:  "<spring:message code='message.obbligatorio.password'/>"
					},
					repeatpassword: {
				        equalTo: "<spring:message code='message.password_non_coincide'/>"
					},
					mail: {
				        required: "<spring:message code='message.obbligatorio.mail'/>",
				        email: "<spring:message code='message.mail_not_valid'/>"
					},
					squadranome: {
				        required: "<spring:message code='message.obbligatorio.squadranome'/>"
					}
			   }
	   
   });
});
</script>
 <h3><spring:message code="label.registrautente"/></h3>
 
	<form:form method="post" action="add" commandName="utente" id="registerUser">
	 
		 <fieldset>
		    <legend><spring:message code="label.registerUser.legend" /></legend>
		    
		    	 <div class="row">
				 	<div class="small-12 large-6 columns">
				 		<form:label path="nome"><spring:message code="label.firstname"/></form:label>
				 	</div>
				   <div class="small-12 large-6 columns">
				   		<form:input path="nome" />
				   </div>
				 </div>
				 
				 <div class="row">
				 	<div class="small-12 large-6 columns">
				 		<form:label path="cognome"><spring:message code="label.lastname"/></form:label>
				 	</div>
				   <div class="small-12 large-6 columns">
				   		<form:input path="cognome" />
				   </div>
				 </div>
		
				 <div class="row">
				 	<div class="small-12 large-6 columns">
				 		<form:label path="username"><spring:message code="label.username"/></form:label>
				 	</div>
				   <div class="small-12 large-6 columns">
				   		<form:input path="username" />
				   </div>
				 </div>
				 
				 <div class="row">
				 	<div class="small-12 large-6 columns">
				 		 <form:label path="password"><spring:message code="label.password"/></form:label>
				 	</div>
				   <div class="small-12 large-6 columns">
				   		<form:password path="password" />
				   </div>
				 </div>
				 
				 <div class="row">
				 	<div class="small-12 large-6 columns">
				 		 <form:label path="repeatpassword"><spring:message code="label.confirm.password"/></form:label>
				 	</div>
				   <div class="small-12 large-6 columns">
				   		<form:password path="repeatpassword"/>
				   </div>
				 </div>
				 
				 <div class="row">
				 	<div class="small-12 large-6 columns">
				 		 <form:label path="mail"><spring:message code="label.email"/></form:label>
				 	</div>
				   <div class="small-12 large-6 columns">
				   		<form:input path="mail" />
				   </div>
				 </div>
				 
				 <div class="row">
				 	<div class="small-12 large-6 columns">
				 		<form:label path="squadra.nome"><spring:message code="label.nomesquadra"/></form:label>
				 	</div>
				   <div class="small-12 large-6 columns">
				   		<form:input  path="squadra.nome" />
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