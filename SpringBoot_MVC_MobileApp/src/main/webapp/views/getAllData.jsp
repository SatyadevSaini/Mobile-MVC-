<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${mdata}" var="a">
<h5>  <c:out value="${a.name}"></c:out> </h5>
<h5>  <c:out value="${a.price}"></c:out> </h5>

<img alt="" src="getImage?name=${a.name}" height="50px" width="50px">



<hr>
</c:forEach>


</body>
</html>