<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="welcome" /></title>
</head>
<body>
<h2><spring:message code="welcome" /></h2>
<a href="owner"><spring:message code="register" /></a>
<a href="login"><spring:message code="login" /></a>
<p>Current Locale : ${pageContext.response.locale}</p>
</body>
</html>