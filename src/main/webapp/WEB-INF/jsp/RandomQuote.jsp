<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Random quotes for everybody</title>
</head>
<body>

<h2>Random quote</h2>
<p>
&quot;<c:out value="${randomQuote}" />&quot;
(${randomIndex + 1} / ${numberOfQuotes})
</p>

<h2>Add quote</h2>
<form method='post'>
<input type='text' name='newQuote' size='100' />
<input type='submit' />
</form>

</body>
</html>
