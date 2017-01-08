<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="welcome" /></title>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
    .error {
        color: red; font-weight: bold;
    }
</style>
</head>
<body>
<form:form method="post" action="login" commandName="loginForm">    
        <table > 
        <tr>    
          <td><spring:message code="userid" /> : </td>   
          <td><form:input path="id"  /></td>  
          <td align="left"><form:errors path="id" cssClass="error"/></td>
         </tr>   
         <tr>    
          <td><spring:message code="password" /> : </td>   
          <td><form:input path="password"  type="password" /></td>  
          <td><form:errors path="password" cssClass="error"/></td>
         </tr> 
         <tr>    
         <spring:message code="submit" var="labelsubmit"/>
          <td colspan="2"><input type="submit" value="${labelsubmit}"  /></td>    
         </tr>    
        </table>    
       </form:form>   
       <a href="owner"><spring:message code="registerOwner" /> </a>
</body>
</html>