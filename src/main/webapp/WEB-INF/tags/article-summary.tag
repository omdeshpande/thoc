<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ attribute name="title" required="true" %>
<%@ attribute name="meta" required="true" %>

<div class="blog-post">
    <h2 class="blog-post-title">${title}</h2>
    <p class="blog-post-meta">${meta}</p>
	<jsp:doBody />
 </div><!-- /.blog-post -->