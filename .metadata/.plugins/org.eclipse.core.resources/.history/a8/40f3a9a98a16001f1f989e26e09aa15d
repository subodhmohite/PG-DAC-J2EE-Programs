<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="err_handler.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Page</title>
</head>
<body>
<%
int result = 100/0;//result : local var --jspService
pageContext.setAttribute("nm",result);
%>
<%--display the value of page scoped attribute --%>
<h5>Result-${pageScope.nm}</h5>
</body>
</html>