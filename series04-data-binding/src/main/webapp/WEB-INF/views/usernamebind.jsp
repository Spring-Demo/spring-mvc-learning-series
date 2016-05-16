<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>username bind</title>
</head>
<body>
	<form:form modelAttribute="sessionaccountmodel" method="post">
		用户名: <form:input path="username"/>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>
