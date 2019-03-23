<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<String> list = (List)session.getAttribute("note");
	if(list.size() == 10)
		list.remove(9);
	list.add(0,"新的消息"+Math.random()*10);
	response.sendRedirect(request.getHeader("Referer"));
%>
</body>
</html>