<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${project.name} information Page</title>

<!--Stylesheet  -->
<link href="resources/css/inforPage.css" rel="stylesheet"
	type="text/css"/ >


</head>
<h1 align="center">${project.name} </h1>
	
<body>

		<br><br>
			<div id="left">
				<h4>Business objective</h4>${project.businessobjective}			
				<h4>Detailed description</h4>${project.description}	
			</div>
			
			<div id="right">
				<h4>Project category</h4>${project.type} project
				<h4>Estimated duration</h4>${project.duration} days
				<h4>Estimated cost</h4>$${project.cost}
				<h4>Number of issues</h4>${project.issues}
			</div>

		<button><a href="logout.php?logout=true">Log Out</a></button>
		<!-- <button id="back"><a href="${pageContext.request.contextPath}/index.jsp">&nbsp&nbsp&nbspBack&nbsp&nbsp&nbsp</a></button> -->

</body>
</html>