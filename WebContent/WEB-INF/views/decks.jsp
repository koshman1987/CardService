<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hello World</title>
</head>
<body>
 <c:if test="${not empty lists}">
 
		<ul>
			<c:forEach var="listValue" items="${lists}">
				<li>${listValue}
				<a href="<c:url value="/shuffle?id=${listValue.id}" />">Shuffle a deck</a>
				<a href="<c:url value="/sort?id=${listValue.id}" />">Sort a deck</a>
				</li>
			</c:forEach>
		</ul>
 
	</c:if>
    <a href="<c:url value="/create" />">Create a deck</a>
    <a href="<c:url value="/jsonCreate" />">RestCreate a deck</a>
    
    <a href="<c:url value="/jsonShuffle" />">RestShuffle a deck</a>
    
    <a href="<c:url value="/jsonSort" />">RestSort a deck</a>
    <a href="<c:url value="/sortBySuit" />">Suit sort a deck</a>
</body>
</html>