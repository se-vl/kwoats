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
&quot;<i><c:out value="${randomQuote.text}" /></i>&quot;<br />
<b><c:out value="${randomQuote.author}" /></b>,
${randomQuote.year}
(${randomIndex + 1} / ${numberOfQuotes})
</p>

<h2>Add quote</h2>
<form method='post'>
	<table>
		<tr>
			<td>Text:</td>
			<td><input type='text' name='text' size='100' /></td>
		</tr>
		<tr>
			<td>Author:</td>
			<td><input type='text' name='author' size='25' /></td>
		</tr>
		<tr>
			<td>Year:</td>
			<td><input type='number' name='year' size='10' /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type='submit' /></td>
		</tr>
	</table>
</form>

</body>
</html>
