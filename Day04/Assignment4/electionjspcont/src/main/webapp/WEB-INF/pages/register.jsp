<%@page import="com.sunbeam.beans.RegistrationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<h3>${initParam.appTitle}</h3>
	<%--
		RegistrationBean rb = new RegistrationBean();
		rb.setFirstName(request.getParameter("firstName"));
		rb.setLastName(request.getParameter("lastName"));
		rb.setEmail(request.getParameter("email"));
		rb.setPasswd(request.getParameter("passwd"));
		rb.setBirth(request.getParameter("birth"));
		rb.setStatus(0);
		rb.setRole("voter");
		rb.registerUser();
		if(rb.getCount() == 1)
			out.println("Registration successful.");
		else
			out.println("Registration failed.");
	--%>
	<jsp:useBean id="rb" class="com.sunbeam.beans.RegistrationBean" scope="page"/>
	<%--
	<jsp:setProperty name="rb" property="firstName" param="firstName"/>
	<jsp:setProperty name="rb" property="lastName" param="lastName"/>
	<jsp:setProperty name="rb" property="email" param="email"/>
	<jsp:setProperty name="rb" property="passwd" param="passwd"/>
	<jsp:setProperty name="rb" property="birth" param="birth"/>
	--%>
	<jsp:setProperty name="rb" property="*" />
	<jsp:setProperty name="rb" property="status" value="0"/>
	<jsp:setProperty name="rb" property="role" value="voter"/>
	${ rb.registerUser() }
	<c:choose>
		<c:when test="${rb.count == 1}">
			Registration successful.
			<a href="ctl?page=index">Sign In</a>
		</c:when>
		<c:otherwise>
			Registration failed.
			<a href="ctl?page=newuser">Sign Up</a>
		</c:otherwise>
	</c:choose>
</body>
</html>



