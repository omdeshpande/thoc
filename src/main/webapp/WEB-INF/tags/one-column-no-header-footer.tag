<!DOCTYPE html>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@ attribute name="css" required="true" type="java.util.ArrayList" %>
<%@ attribute name="js" required="true" type="java.util.ArrayList" %>

<%@ attribute name="documentTitle" required="true" %>

<html lang="en">

  <t:head documentTitle="${documentTitle}" css="${css}" js="${js}" />

  <body>

    <div class="container">
      
        <jsp:doBody />

    </div><!-- /.container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="${bootstrapJs}"></script>
  </body>
  
</html>