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
    <h3>Online Voting</h3>
    Hello, ${lb.user.firstName} ${lb.user.lastName} <hr/>
    
    
    <c:choose>
        <c:when test="${lb.user.status ==0}">
            <jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean"/>
            <jsp:setProperty name="vb" property="userid" value="${lb.user.id}"/>
            <jsp:setProperty name="vb" property="candid" param="candidate"/>
            
            ${vb.vote()}
            <c:redirect url="logout.jsp"/>
        </c:when>
        <c:otherwise>
             Already voted.        
        </c:otherwise>
    </c:choose>
       <a href="index.jsp">LogOut</a>
</body>
</html>