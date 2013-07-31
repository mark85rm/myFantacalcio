<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<link rel="stylesheet" href="<c:url value='/resources/css/demo_page.css'/>" />
	<link rel="stylesheet" href="<c:url value='/resources/css/demo_table.css'/>" />

  	<script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.js'/>"></script>
	<script type="text/javascript" charset="utf-8">

				$(document).ready(function() {
					$('#rosa').dataTable();
					
				} );
	</script>
	
	<h3>${utente.squadra.nome}</h3>
	
	<form:form action="addGiocatoreRosa" method="get">

	<div class="row">
		<div class="small-12 large-2 columns">
			<label><spring:message code="label.addGiocatore"/></label>
		</div>
		<div class="small-12 large-4 columns">
				<select name="giocatoreid" class="combobox">
				    <option value=""></option>
				    <c:forEach items="${giocatoriList}" var="giocatore" varStatus="rowCounter">
				   		 <option value="${giocatore.id}">${giocatore.nome}</option>
					</c:forEach>
				  </select>
			
		</div>
		<div class="small-12 large-6 columns">
			 <input type="submit" class="button radius" value="<spring:message code="label.add"/>"/>
		</div>
	 </div>
	 
	 </form:form>	

<hr/>

<h4><spring:message code="label.rosa"/></h4>
 
<c:if  test="${!empty utente.squadra.giocatori}">
<table class="display" id="rosa">
<thead>
	<tr>
	    <th><spring:message code="label.nomegiocatore"/></th>
	    <th><spring:message code="label.squadragiocatore" /></th>
	    <th><spring:message code="label.ruologiocatore"/></th>
	    <th>&nbsp;</th>
    </tr>
</thead>
<tbody>
<c:forEach items="${utente.squadra.giocatori}" var="giocatore" varStatus="rowCounter">
    <tr>
        <td>${giocatore.nome}</td>
    	<td>${giocatore.squadraCalcio}</td>
    	 <td>${giocatore.ruoloGiocatore.nome}</td>
    	 <td>
		  <a href="<c:url value="/user/eliminaGiocatoreRosa/${giocatore.id}" />">Elimina</a>
        </td>
    </tr>

</c:forEach>
  </tbody>
</table>
</c:if>
   
