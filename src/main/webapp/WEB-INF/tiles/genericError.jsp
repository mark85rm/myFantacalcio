<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
<div class="small-12 large-12 columns">

	<div class="callout panel">
	Si e' verificato un problema. 
	Contattare l'amministratore del sistema e comunicare queste informazioni:
	</div>
	
	</div>
</div>

<div class="row">
<div class="small-12 large-12 columns">

	<div class="regular panel">
	Messaggio:
	<br/>
	${exception.message}
	<br/>
	<br/>
	Causa: 
	<br/>
	${exception.cause}
	</div>
	</div>
</div>

<div class="row">
<div class="small-12 large-12 columns">
	<a href="#" class="button round small alert">Invia segnalazione</a>
</div>
 </div>

