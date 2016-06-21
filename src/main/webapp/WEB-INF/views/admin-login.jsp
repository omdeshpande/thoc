<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:one-column-no-header-footer documentTitle="Admin login" css="${css}" js="${js}">
	<jsp:body>
		<t:user-login-form message="${message}" />
	</jsp:body>
</t:one-column-no-header-footer>