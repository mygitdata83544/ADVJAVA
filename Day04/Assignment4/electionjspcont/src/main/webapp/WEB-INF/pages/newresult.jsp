<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
	<h3>${initParam.appTitle}</h3>

	<jsp:useBean id="res" class="com.sunbeam.beans.CandidateListBean"/>
	${res.fetchCandidates()}
	<table border="1">
		<thead>
			<th>Id</th>
			<th>Name</th>
			<th>Party</th>
			<th>Votes</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach var="c" items="${res.candidateList}">
				<tr>
					<td>${c.id}</td>
					<td>${c.name}</td>
					<td>${c.party}</td>
					<td>${c.votes}</td>
					<td>
						<a href="ctl?page=editcand&id=${c.id}">
							<img src="images/edit.png" alt="Edit" width="24" height="24"/>
						</a>
						<a href="ctl?page=delcand&id=${c.id}">
							<img src="images/delete.png" alt="Del" width="24" height="24"/>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/><br/>
	<a href="logout.jsp">Sign Out</a>	
</body>
</html>
