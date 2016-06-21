<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ attribute name="pageTitle" required="true" %>
<%@ attribute name="pageSummary" required="true" %>

<div class="blog-masthead">
  <div class="container">
    <nav class="blog-nav">
      <a class="blog-nav-item active" href="#">Home</a>
      <a class="blog-nav-item" href="#">New features</a>
      <a class="blog-nav-item" href="#">Press</a>
      <a class="blog-nav-item" href="#">New hires</a>
      <a class="blog-nav-item" href="#">About</a>
    </nav>
  </div>
</div>
<div class="container">
  	<div class="blog-header">
	    <h1 class="blog-title">${pageTitle}</h1>
	    <p class="lead blog-description">${pageSummary}</p>
	</div>
</div>