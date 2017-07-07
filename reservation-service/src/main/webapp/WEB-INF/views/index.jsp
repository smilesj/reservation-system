<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>카테고리</title>
</head>
<body>
	<h1>카테고리</h1>
	<hr/>
	<form method="post" action="/category">
		<input type="text" name="name" />
		<input type="submit" value="등록" />
	</form>
	
	<hr/>
	<h3>카테고리목록</h3>
	<ul>
	<c:forEach items="${list }" var="i">
		<li>
			<input type="hidden" name="id" value="${i.id }"/>
			<input type="text" name="name" value="${i.name }" />
			<input class="removebtn" type="button" value="삭제" />
		</li>
	</c:forEach>
	</ul>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="resources/js/app.js"></script>
</html>