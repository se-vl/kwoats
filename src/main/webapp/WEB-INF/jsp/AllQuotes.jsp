<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Random quotes for everybody</title>
</head>
<body>

<h2>All quotes</h2>
<ol>
	<c:forEach items="${allQuotes}" var="quote">
		<li><c:out value="${quote}" /></li>
	</c:forEach>
</ol>

</body>
</html>
