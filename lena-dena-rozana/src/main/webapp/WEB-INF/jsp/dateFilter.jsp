<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

</head>
<body>
 <form:form method="post" action="transactionByDate" modelAttribute="dateFilter">
<form:errors/>
<table > 
    
         <tr>    
          <td><spring:message code="dateLabel" /> :</td>    
          <td><form:input path="date" type="date"/></td>  
          <td><form:errors path="date" cssClass="error"/></td>
         </tr> 
         </table> 
</form:form>
</body>
</html>