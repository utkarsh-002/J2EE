<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospital</title>
</head>
<body>
<form action="input" method="get">
id:<input type="text" name="id">
name:<input type="text" name="name">
age:<input type="text" name="age">
date:<input type="text" name="date">
cause:<input type="text" name="cause">
doctor:<input type="text" name="doctor">
<input type=submit>
</form><br>
<form action="input">
Want to delete the entry:<input type="text" name="del">
ID:<input type="text" name="id">
<input type=submit>
</form>
</body>
</html>