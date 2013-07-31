<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h4>
<a href="?lang=it"><img src="<c:url value='/resources/img/flag/IT.jpg'/>" width="30" height="15" /></a>
<a href="?lang=en"><img src="<c:url value='/resources/img/flag/EN.jpg'/>" width="30" height="15" /></a>
<a href="<c:url value="/j_spring_security_logout" />" >
	<spring:message code="label.logout" />
</a>
</h4>
