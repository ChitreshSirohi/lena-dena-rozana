<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ include file="logout.jsp" %>
   <%@ include file="dateFilter.jsp" %>
</head>
<body>


<table border="2" width="70%" cellpadding="2">  
<tr><th>Name</th><th>Phone No</th><th>Amount</th><th>Settled</th></tr>  
     <c:forEach var="transaction" items="${transactionList}">
   <tr>  
   <td>${transaction.name}</td>  
   <td>${transaction.mobileNo}</td>  
   <td>${transaction.amount}</td>  
   <td>${transaction.settled}</td>  
   </tr>  
  </c:forEach>
   </table>
</body>
</html>