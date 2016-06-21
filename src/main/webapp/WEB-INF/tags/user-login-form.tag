<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ attribute name="message" required="true" %>

<spring:url value="/login" var="formAction" />

<p>${message}</p>
<form class="form-signin" method="POST" action="${formAction}">
    <h2 class="form-signin-heading">Please sign in</h2>
    <label for="username" class="sr-only">Email address</label>
    <input name="username" id="username" class="form-control" placeholder="Email address" required="required" autofocus="autofocus" />
    <label for="password" class="sr-only">Password</label>
    <input name="password" type="password" id="password" class="form-control" placeholder="Password" required="required" />
    <!--<div class="checkbox">
      <label path="">
        <input type="checkbox" value="remember-me"> Remember me
      </label>
    </div>-->
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>