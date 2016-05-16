<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>param bind</title>
</head>
<body>
	<form action="parambind?urlParam=AAA" method="post" enctype="multipart/form-data">
		<input type="text" name="formParam" /><br />
		<input type="file" name="formFile" /><br />
		<input type="submit" value="Submit" />
	</form>
</body>
</html>
