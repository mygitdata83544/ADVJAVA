<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete candidate</title>
</head>
<body>
      <h3>${initParam.appTitle}</h3>
      <jsp:useBean id="dcb" class="com.sunbeam.beans.DeleteCandidateBean"/>
      <jsp:setProperty property="*" name="dcb"/>
      ${dcb.deleteCand()}
      <c:redirect url="result.jsp"/>

</body>
</html>