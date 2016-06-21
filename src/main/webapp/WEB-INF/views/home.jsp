<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:two-column documentTitle="2 column layout" pageTitle="Blog Title" pageSummary="Blog summary." css="${css}" js="${js}">
          
    <jsp:attribute name="rightColumn">
      <t:static-box-small title="About">
      	<jsp:attribute name="content">
      		<p>
      		Etiam porta sem malesuada magna mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.
      		</p>
      	</jsp:attribute>
      </t:static-box-small>
      
      <t:link-list-box-small title="Archives">
      </t:link-list-box-small>
      
      <t:link-list-box-small title="Elsewhere">
      	
      </t:link-list-box-small>
    </jsp:attribute>
        
	<jsp:body>
		<c:forEach items="${articles}" var="article" >
			<t:article-summary title="${article.title}" meta="${article.author}">
				<jsp:body>
					${article.content}
				</jsp:body>
			</t:article-summary>
		</c:forEach>
  		<t:pager />
	</jsp:body>
</t:two-column>
