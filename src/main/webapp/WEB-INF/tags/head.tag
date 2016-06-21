<%@tag description="Head element of the page" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="documentTitle" required="true" %>
<%@attribute name="css" required="true" type="java.util.ArrayList" %>
<%@attribute name="js" required="true" type="java.util.ArrayList" %>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${documentTitle}</title>

	<!-- CSS Includes -->
	<c:forEach items="${css}" var="incl">
		<spring:url value="${incl}" var="url" />
		<link href="${url}" rel="stylesheet">
	</c:forEach>
	
	<!-- JS Includes -->
	<c:forEach items="${js}" var="incl">
		<spring:url value="${incl}" var="url" />
		<script src="${url}"></script>
	</c:forEach>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
 </head>