<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote</title>
</head>
<body>
      <h3>${initParam.appTitle}</h3>
      <jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean" scope="request"/>
      <jsp:setProperty name="vb" property="*"/>
      ${ vb.voteRecord() }
      
      <c:choose>
           <c:when test="${candidate}">
               Thank You For Your Vote.
           </c:when>
      </c:choose>
</body>
</html>