<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<script>
	$(document).ready(function() {
		$('#nav li').hover(function() {
			//mostra sottomenu
			$('ul', this).stop(true, true).delay(50).slideDown(100);

		}, function() {
			//nascondi sottomenu
			$('ul', this).stop(true, true).slideUp(200);
		});
	});
</script>

<ul id="nav">

	<li class="first"><a href="<c:url value="/home" />"><spring:message	code="label.menu.home" /></a></li>
	<li><a href="#"><spring:message	code="label.menu.lega" /></a>
	 <ul>
        <li><a href="#"><spring:message	code="label.sottomenu.classifica" /></a></li>
        <li><a href="#"><spring:message	code="label.sottomenu.calendario" /></a></li>
        <li><a href="#"><spring:message	code="label.sottomenu.ultimagiornata" /></a></li>
        <li class="last"><a href="#"><spring:message code="label.sottomenu.statistiche" /></a></li>
    </ul>  
	</li>
	
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<li><a href="#"><spring:message	code="label.menu.amministrazionesito" /></a>
			<ul>
				<li><a href="<c:url value="/admin/userManager" />">
				<spring:message	code="label.sottomenu.gestioneutenti" />
				</a></li>
				<li><a href="<c:url value="/admin/giocatoriManager" />">
				<spring:message	code="label.sottomenu.listagiocatori" />
				</a></li>
				<li><a href="<c:url value="/admin/aggiornaListaGiocatore" />">
				<spring:message	code="label.sottomenu.aggiornalistagiocatori" />
				</a></li>
				<li class="last"><a href="<c:url value="/admin/legaManager" />">
				<spring:message	code="label.sottomenu.amministrazioneleghe" />
				</a></li>
				
				

			</ul>
			<div class="clear"></div>
		</li>
	</sec:authorize>
	
	<li class="last"><a href="#"><spring:message	code="label.menu.profiloutente" /></a>
			<ul>
				<li><a href="<c:url value="/user/rosaManager" />">
				<spring:message	code="label.sottomenu.gestioneRosa" />
				</a></li>
				<li class="last"><a href="<c:url value="/admin/creaLega" />">
				<spring:message	code="label.sottomenu.crealega" />
				</a></li>
			</ul>
	</li>
		
</ul>




<!--  
    <li><a href="#">Voce 03</a>
    <ul>
        <li><a href="#">Sottovoce Menu Numero 04</a></li>
        <li><a href="#">Sottovoce Menu Numero 05</a></li>
        <li><a href="#">Sottovoce Menu Numero 06</a></li>
        <li class="last"><a href="#">Sottovoce Menu Numero 07</a></li>
    </ul>         
        <div class="clear"></div>
    </li>
    <li class="last"><a href="#">Voce 04</a></li>
    -->


