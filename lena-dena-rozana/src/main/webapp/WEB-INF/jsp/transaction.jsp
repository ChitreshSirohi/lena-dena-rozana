<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="welcome" /></title>
<%@ include file="logout.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
    .error {
        color: red; font-weight: bold;
    }
</style>
</head>
<body>
<form:form method="post" action="transaction" commandName="transactionForm">

<form:errors/>    
        <table > 
        <tr>    
          <td><spring:message code="partnerIdLabel" /> : </td>   
          <td><form:select path="partnerId">
					  <form:options items="${transactionList}" />
				       </form:select>
                                </td>
           <td><form:errors path="partnerId" cssClass="error"/></td>
         </tr>    
         <tr>    
          <td><spring:message code="dateLabel" /> :</td>    
          <td><form:input path="tempDateString" type="date"/></td>  
          <td><form:errors path="tempDateString" cssClass="error"/></td>
         </tr>   
         <tr>    
          <td><spring:message code="amount" /> :</td>    
          <td><form:input path="amount" /></td> 
          <td><form:errors path="amount" cssClass="error"/></td> 
         </tr>
         <tr>    
          <td><spring:message code="mobileNo" /> :</td>    
          <td><form:hidden path="mobileNo" /></td> 
          <td><form:errors path="mobileNo" cssClass="error"/></td>
         </tr>
         <tr>    
          <td><spring:message code="typeLabel" /> :</td>  
          <spring:message code="debitLabel" var="debit"/>
          <spring:message code="creditLabel" var="credit"/>  
          <td><form:select path="type">
					  <form:option  value="credit" label="${credit}"/>
					  <form:option  value="debit" label="${debit}"/>
				       </form:select></td>  
          <td><form:errors path="type" cssClass="error"/></td>
         </tr>
         <tr>    
          <td><spring:message code="settledLabel" /> : </td>   
          <td><form:checkbox path="settled" /></td>  
          <td><form:errors path="settled" cssClass="error"/></td>
         </tr>
         <tr>    
         <spring:message code="submit" var="labelsubmit"/>
          <td colspan="2"><input type="submit" value="${labelsubmit}"  /></td>    
         </tr>    
        </table>    
       </form:form>   
       
</body>
</html>