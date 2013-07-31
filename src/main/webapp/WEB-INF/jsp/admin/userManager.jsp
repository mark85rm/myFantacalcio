<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<link rel="stylesheet" href="<c:url value='/resources/css/demo_page.css'/>" />
	<link rel="stylesheet" href="<c:url value='/resources/css/demo_table.css'/>" />

  	<script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.js'/>"></script>
	<script type="text/javascript" charset="utf-8">
				$(document).ready(function() {
					$('#userlist').dataTable();
				} );
	</script>


<h3><spring:message code="label.listautenti"/></h3>


 
<c:if  test="${!empty utenteList}">
<table class="display" id="userlist">
<thead>
	<tr>
	    <th><spring:message code="label.username"/></th>
	    <th><spring:message code="label.firstname"/></th>
	     <th><spring:message code="label.lastname"/></th>
	    <th><spring:message code="label.nomesquadra"/></th>
	    <th><spring:message code="label.nomelega"/></th>
	<%--      <th><spring:message code="label.amministratorelega"/></th> --%>
	    <th>&nbsp;</th>
    </tr>
</thead>
<tbody>
<c:forEach items="${utenteList}" var="utente" varStatus="rowCounter">

<%-- 		<c:choose> --%>
<%--           <c:when test="${rowCounter.count % 2 == 0}"> --%>
<%--             <c:set var="rowStyle" scope="page" value="odd"/> --%>
<%--           </c:when> --%>
<%--           <c:otherwise> --%>
<%--             <c:set var="rowStyle" scope="page" value="even"/> --%>
<%--           </c:otherwise> --%>
<%--         </c:choose> --%>
    <tr>
        <td>${utente.username}</td>
        <td> ${utente.nome} </td>
        <td> ${utente.cognome} </td>
        <td> ${utente.squadra.nome} </td>
        <td> ${utente.squadra.lega.nome} </td>
<%--         <td> ${utente.squadra.lega.utenteAmministratore.nome} </td> --%>
        <td>
	        <c:choose>
		      <c:when test="${utente.enabled}">
		      <a href="<c:url value="/adminControl/disattivaUtente/${utente.id}" />">Disattiva</a>
		      </c:when>
		      <c:otherwise>
		         <a href="<c:url value="/adminControl/attivaUtente/${utente.id}" />">Attiva</a>
		      </c:otherwise>
			</c:choose>
        </td>
    </tr>

</c:forEach>
  </tbody>
</table>
</c:if>
   
