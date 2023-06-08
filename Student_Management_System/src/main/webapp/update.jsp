<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<!-- Here, we are receiving the student object found with id from the
	updateStudent() method by passing the key ("student") in ModelAttribute -->
	
	<!-- Data which is already present will be loaded and we can update 
		whichever data needs to be updated and click on submit -->
		
	<!-- Action is given to (/saveUpdatedStudent) url. -->
	<f:form action="saveUpdatedStudent" modelAttribute="student">
		<f:input path="id" readonly="true"/> <br>
		<f:input path="name"/><br>
		<f:input path="email"/><br>
		<f:input path="password"/><br>
		<input type="submit" value="Update"><br>
	
	</f:form>
</body>
</html>