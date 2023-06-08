<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>

	<!-- Here, we are using JSTL tag in order to send some data from the JSP file,
		as JSP is only able to receive the data and can't send the data  -->
		
	<!-- We have received the same null object{new Student()} so the key must be same
		as in the method "registerStudent()" as ModelAttribute and adding some values 
		to the variables. -->
		
	<!-- NOTE :- Here, we are using the PATH for variables. So, the name of variables 
		should be same as that of the Entity class variables -->
		
	<!-- After adding the values, we are giving an action for the url (/save) -->
	
	<f:form action="save" modelAttribute="student" >
		<f:input path="id" placeholder="Enter your id" /> <br>
		<f:input path="name" placeholder="Enter your name"/> <br>
		<f:input path="email" placeholder="Enter your email"/> <br>
		<f:input path="password" placeholder="Enter your password"/> <br>
		<input type="submit" value="Register">
	</f:form>
</body>
</html>