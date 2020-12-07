<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title jsp here</title>

<style>
form {
	border: 1px solid pink;
	width: 350px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 20px;
	padding: 30px;
	display: grid;
	grid-template-columns: 1fr 1fr;
	grid-gap: 0.5em 0.5em;
}

#btnsubmit {
	grid-column: 2/3;
}

label {
	justify-self: right;
}
</style>

</head>
<body>
	jujutsu
	<%
System.out.println("inside wehre");
%>
	<%=new java.util.Date()%>
	<br>
	<%=pageContext.getServletContext().getContextPath()%>
	<p>${pageContext.servletContext.contextPath}</p>

	<c:out value="Makan nasi ${pageContext.servletContext.contextPath}" />

	<form action="${pageContext.servletContext.contextPath}/urlmapping" method="post">

		<label for="idname">Name:</label><input type="text" id="idname"
			name="name">
			 <label for="idpwd">Katalaluan:</label><input
			type="password" id="idpassword" name="namepassword"> 
			<input
			type="submit" value="HantarSubmit" id="btnsubmit">

	</form>
</body>
</html>