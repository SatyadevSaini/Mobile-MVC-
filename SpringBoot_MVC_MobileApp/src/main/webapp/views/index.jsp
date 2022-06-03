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
<h1>Mobile App</h1>
<hr>

<c:if test="${result=='Success'}">
<h3 style=" color: green;">Mobile Uploaded Successfully</h3>
</c:if>

<c:if test="${result=='Failed'}">
<h3 style=" color: red;">Failed </h3>
</c:if>


<form action="addMobile" method="post" enctype="multipart/form-data">

Mobile Name: <input type="text" name="name" required/><br/><br/>
Mobile Price: <input type="number" name="price" required/><br/><br/>
Image 1 Upload :  <input type="file" name="image1"> <br> <br>
Image 2 Upload :  <input type="file" name="image2"> <br> <br>

<button>Add Mobile</button>
</form>

<hr> 

<a href="update">UpdateLink</a>

<hr>
<a href="getAllData">Get AllMobiles</a>
<hr>





















</body>
</html>