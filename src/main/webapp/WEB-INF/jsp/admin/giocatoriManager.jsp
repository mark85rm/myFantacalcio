<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<link rel="stylesheet" href="<c:url value='/resources/css/demo_page.css'/>" />
	<link rel="stylesheet" href="<c:url value='/resources/css/demo_table.css'/>" />

  	<script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.js'/>"></script>
	<script type="text/javascript" charset="utf-8">
				$(document).ready(function() {
					$('#giocatoreList').dataTable();
				} );
	</script>


<hr/>

<h6><spring:message code="label.rosa"/></h6>
<c:if  test="${!empty giocatori}">
<table class="display" id="giocatoreList">
<thead>
	<tr>
	    <th><spring:message code="label.nomegiocatore"/></th>
	    <th><spring:message code="label.squadragiocatore" /></th>
<%-- 	    <th><spring:message code="label.fantasquadragiocatore" /></th> --%>
	    <th><spring:message code="label.ruologiocatore"/></th>
	    <th>&nbsp;</th>
    </tr>
</thead>
<tbody>
<c:forEach items="${giocatori}" var="giocatore" varStatus="rowCounter">
    <tr>
        <td>${giocatore.nome}</td>
    	<td>${giocatore.squadraCalcio}</td>
<%--     	 <td>${giocatore.squadra.nome}</td> --%>
    	 <td>${giocatore.ruoloGiocatore.nome}</td>
        <td>
		  <a href="<c:url value="/admin/modificaGiocatore/${giocatore.id}" />">Modifica</a>
        </td>
    </tr>

</c:forEach>
  </tbody>
</table>
</c:if>