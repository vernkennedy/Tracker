<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--Stylesheet  -->
<link href="resources/css/newOReditProject.css" rel="stylesheet" type="text/css"/ >
<title>New Contact</title>
</head>
<body>
	<div align="center">
		<h1>New Project</h1>
		<form:form action="saveProject" method="post" modelAttribute="project">
			<table>
				<form:hidden path="id" />
				<tr>
					<td>ProjectName:<br>
					<form:input path="name" /></td>
				</tr>
				<tr>
					<td>ProjectType:<br> <form:radiobutton path="type"
							value="Current" />Current <form:radiobutton path="type"
							value="Past" />Past
					</td>
				</tr>
				<tr>
					<td>Cost:<br>
					<form:input path="cost" /></td>
				</tr>
				<tr>
					<td>Duration:<br>
					<form:input path="duration" /></td>
				</tr>
				<tr>
					<td>Issues:<br>
					<form:input path="issues" /></td>
				</tr>
				<tr>
					<td>Completed (true or false):<br> <form:radiobutton
							path="completed" value="true" />Completed <form:radiobutton
							path="completed" value="false" />Not Completed
					</td>
				</tr>
				<tr>
					<td>Objective:<br>
					<pre>
							<form:textarea path="businessobjective" rows="5" cols="30" />
						</pre></td>
				</tr>
				<tr>
					<td>Description:<br>
					<form:input path="description" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>