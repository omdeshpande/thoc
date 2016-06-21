<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ attribute name="title" required="true" %>
<%@ attribute name="content" fragment="true" required="true" %>

<div class="sidebar-module sidebar-module-inset">
	<h4>${title}</h4>
    <p>
    	<jsp:invoke fragment="content" />
    </p>
</div>