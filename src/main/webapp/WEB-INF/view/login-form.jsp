<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<style>
.failed{
  color:red; 
}

</style>

</head>

<body>
<h1>Please Login Here..</h1>

<c:if test="${param.error!=null}">
    <i class="failed">Sorry! You entered envalid username/password</i>
</c:if>

<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
  UserName:<input type="text" name="username"/></br></br>
  Password:<input type="passsword" name="password"/>
  <input type="submit" value="LOGIN"/>
</form:form>


</body>
</html>

