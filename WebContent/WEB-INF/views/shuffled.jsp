<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hello World</title>
</head>
<body>

    <c:out value="${deck}" />
    <a href="<c:url value="/sort" />">Sort a deck</a>
    <a href="<c:url value="/jsonSort" />">RestSort a deck</a>
    <a href="<c:url value="/createcjsonSort" />">RestSort a deck</a>
    <a href="<c:url value="/redirect" />">Home</a>
</body>
</html>