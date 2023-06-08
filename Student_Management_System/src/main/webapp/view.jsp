<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%> 
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Database</title>
</head>
<body>
	<table border="4px" cellpadding="10px" align="center" style="text-align: center;position: relative;top: 270px">
		<tr>
			<th>Student_id</th>
			<th>Student_name</th>
			<th>Student_email</th>
			<th>Student_password</th>
			<th>EDIT</th>
			<th>DELETE</th>		
		</tr>
		
		<!-- Here also, we are using JSTL tags and declaring a forEach loop where
			var="student" represents variable name and "items" represents List<Student> (items name
			should be same as that of the key name provided in the method "viewStudent()") -->
		<c:forEach var="student" items="${student }">
			<tr>
				<td>${student.getId() }</td>
				<td>${student.getName() }</td>
				<td>${student.getEmail() }</td>
				<td>${student.getPassword() }</td>
				
				<!-- In this tag, we are giving a link for (/updateStudent) and taking the id of 
				that particular student which is to be UPDATED -->
				<td> <a href="updateStudent?id=${student.getId()}">edit</a> </td>
				
				<!-- In this tag, we are giving a link for (/updateStudent) and taking the id of 
				that particular student which is to be DELETED -->
				<td> <a href="deleteStudent?id=${student.getId()}">delete</a> </td>
			</tr>
		
		</c:forEach>
	
	</table>
</body>
</html>