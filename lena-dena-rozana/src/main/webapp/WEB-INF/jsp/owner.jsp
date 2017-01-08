<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
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
<form:form method="post" action="owner" commandName="ownerForm">

<form:errors/>    
        <table > 
        <tr>    
          <td><spring:message code="userid" /> : </td>   
          <td><form:input path="id"  /></td> 
           <td><form:errors path="id" cssClass="error"/></td>
         </tr>   
         <tr>    
          <td><spring:message code="password" /> : </td>   
          <td><form:input path="password" type="password" /></td> 
          <td><form:errors path="password" cssClass="error"/></td> 
         </tr> 
         <tr>    
          <td><spring:message code="fname" /> : </td>   
          <td><form:input path="fname"  /></td>  
          <td><form:errors path="fname" cssClass="error"/></td>
         </tr>  
         <tr>    
          <td><spring:message code="lname" /> : </td>   
          <td><form:input path="lname"  /></td> 
          <td><form:errors path="lname" cssClass="error"/></td> 
         </tr>   
         <tr>    
          <td><spring:message code="address" /> :</td>    
          <td><form:input path="address" /></td>  
          <td><form:errors path="address" cssClass="error"/></td>
         </tr>   
         <tr>    
          <td><spring:message code="email" /> :</td>    
          <td><form:input path="email" /></td> 
          <td><form:errors path="email" cssClass="error"/></td> 
         </tr>
         <tr>    
          <td><spring:message code="mobileNo" /> :</td>    
          <td><form:input path="mobileNo" /></td> 
          <td><form:errors path="mobileNo" cssClass="error"/></td>
         </tr>
         <tr>    
          <td><spring:message code="altMobileNo" /> :</td>    
          <td><form:input path="altMobileNo" /></td>  
          <td><form:errors path="altMobileNo" cssClass="error"/></td>
         </tr>
         <tr>    
         <spring:message code="submit" var="labelsubmit"/>
          <td colspan="2"><input type="submit" value="${labelsubmit}"  /></td>    
         </tr>    
        </table>    
       </form:form>   
       
</body>
</html>