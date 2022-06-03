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

<h2>Update Mobile </h2>

<c:if test="${u=='Sucess'}">
<h3 style="color: green;">Updated Successfully</h3>
</c:if>

<c:if test="${u=='Failed'}">
<h3 style="color: red;">Updation Failed</h3>
</c:if>

<form action="updateMobile" method="post">

Mobile Names:<select name="names">
  <c:forEach items="${name}" var="a"> 
<option>${a}</option>
</c:forEach>
</select>
<br>
Mobile Name: <input type="text" name="name" required/><br/><br/>
Mobile Price: <input type="number" name="price" required/><br/><br/>
<button>Update</button>

</form>

<hr> 

<hr>



</body>
</html>