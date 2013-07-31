<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" /></title>

	<link rel="stylesheet" href="<c:url value='/resources/css/normalize.css'/>" />
	<link rel="stylesheet" href="<c:url value='/resources/css/foundation.css'/>" />
	<link rel="stylesheet" href="<c:url value='/resources/css/jquery-ui-1.10.3.custom.css'/>" />
	<link rel="stylesheet" href="<c:url value='/resources/css/custom.css'/>" />


    <script src="<c:url value='/resources/js/vendor/custom.modernizr.js'/>"></script>
  
    <style>
	html { 
  	background: url(<c:url value='/resources/img/sfondo.jpg'/>) no-repeat center center fixed; 
  	-webkit-background-size: cover;
 	 -moz-background-size: cover;
 	 -o-background-size: cover;
  	background-size: cover;
	}
  </style>

</head>
<body>
 
  	<!--  
	<script>
 	 document.write('<script src=' +
 	 ('__proto__' in {} ? '<c:url value="/resources/js/vendor/zepto"/>' : '<c:url value="/resources/js/vendor/jquery"/>') +
 	 '.js><\/script>')
  	</script>

  -->
  	
  <script src="<c:url value='/resources/js/jquery.js'/>"></script>
  <script src="<c:url value='/resources/js/foundation.min.js'/>"></script>
  <script src="<c:url value='/resources/js/foundation/foundation.js'/>"></script>
  <script src="<c:url value='/resources/js/foundation/foundation.alerts.js'/>"></script>
  <script src="<c:url value='/resources/js/foundation/foundation.clearing.js'/>"></script>
  <script src="<c:url value='/resources/js/foundation/foundation.cookie.js'/>"></script>
  <script src="<c:url value='/resources/js/foundation/foundation.dropdown.js'/>"></script>
  <script src="<c:url value='/resources/js/foundation/foundation.forms.js'/>"></script>
  <script src="<c:url value='/resources/js/foundation/foundation.joyride.js'/>"></script>
  <script src="<c:url value='/resources/js/foundation/foundation.magellan.js'/>"></script>
  <script src="<c:url value='/resources/js/foundation/foundation.orbit.js'/>"></script> 
  <script src="<c:url value='/resources/js/foundation/foundation.placeholder.js'/>"></script>
  <script src="<c:url value='/resources/js/foundation/foundation.reveal.js'/>"></script>
  <script src="<c:url value='/resources/js/foundation/foundation.section.js'/>"></script>
  <script src="<c:url value='/resources/js/foundation/foundation.tooltips.js'/>"></script>
  <script src="<c:url value='/resources/js/foundation/foundation.topbar.js'/>"></script>
  <script src="<c:url value='/resources/js/foundation/foundation.interchange.js'/>"></script> 
  <script src="<c:url value='/resources/js/jquery-ui-1.10.3.custom.js'/>"></script> 
  <script src="<c:url value='/resources/js/combobox.js'/>"></script> 
  <script src="<c:url value='/resources/js/jquery.validate.js'/>"></script>
 
   	 <script>
	    $(document).foundation();
	  </script>
	    <!--  
	-->
	
	<div class="row">
		<div class="large-9 columns left">
			<tiles:insertAttribute name="header" />
		</div>
	
		<div class="large-3 columns right">
			<tiles:insertAttribute name="usermenu" />	
		</div>

	</div>

	
	<div class="row">
		<div class="small-12 large-12 columns">
			<tiles:insertAttribute name="menu" />
		</div>
	</div>
<hr/>
	<div class="row" style="height: 50%;">
		<div class="large 12-columns panel radius">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
<hr/>
	<div class="row">
		<div class="large 12-columns panel">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>

</body>
</html>