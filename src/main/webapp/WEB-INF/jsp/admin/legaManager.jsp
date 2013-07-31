<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<link rel="stylesheet" href="<c:url value='/resources/css/demo_page.css'/>" />
	<link rel="stylesheet" href="<c:url value='/resources/css/demo_table.css'/>" />

  	<script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.js'/>"></script>
	<script type="text/javascript" charset="utf-8">
				$(document).ready(function() {
					$('#legaList').dataTable();
				} );
	</script>


<h3><spring:message code="label.elencoleghe"/></h3>


 
<c:if  test="${!empty legaList}">
<table class="display" id="legaList">
<thead>
	<tr>
	    <th><spring:message code="label.nomelega"/></th>
	    <th><spring:message code="label.amministratorelega"/></th>
	     <th><spring:message code="label.squadrelega"/></th>
	    <th>&nbsp;</th>
    </tr>
</thead>
<tbody>
<c:forEach items="${legaList}" var="lega" varStatus="rowCounter">
    <tr>
        <td>${lega.nome}</td>
        <td><a href="mailto:${lega.utenteAmministratore.mail}">${lega.utenteAmministratore.nome}  ${lega.utenteAmministratore.cognome}</a></td>
        <td> ... </td>
   
        <td>
	        <c:choose>
		      <c:when test="${lega.enabled}">
		      <a href="<c:url value="/admin/disattivaLega/${lega.id}" />">Disattiva</a>
		      </c:when>
		      <c:otherwise>
		         <a href="<c:url value="/admin/attivaLega/${lega.id}" />">Attiva</a>
		      </c:otherwise>
			</c:choose>
        </td>
    </tr>

</c:forEach>
  </tbody>
</table>
</c:if>
   
