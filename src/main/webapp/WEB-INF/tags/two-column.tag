<!DOCTYPE html>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ attribute name="rightColumn" fragment="true" %>
<%@ attribute name="documentTitle" required="true" %>
<%@ attribute name="pageTitle" required="true" %>
<%@ attribute name="pageSummary" required="true" %>
<%@ attribute name="css" required="true" type="java.util.ArrayList" %>
<%@ attribute name="js" required="true" type="java.util.ArrayList" %>

<html lang="en">

  <t:head documentTitle="${documentTitle}" css="${css}" js="${js}" />

  <body>

    <t:header pageTitle="${pageTitle}" pageSummary="${pageSummary}" />

    <div class="container">
      <div class="row">
        <div class="col-sm-8 blog-main">
          	<jsp:doBody />
        </div><!-- /.blog-main -->

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
        	<jsp:invoke fragment="rightColumn" />
        </div><!-- /.blog-sidebar -->

      </div><!-- /.row -->

    </div><!-- /.container -->

    <t:footer />

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="${bootstrapJs}"></script>
  </body>
  
</html>