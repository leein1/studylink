<%--
  Created by IntelliJ IDEA.
  User: leeinwon
  Date: 2024. 5. 25.
  Time: 오후 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>note list</h1>
    <c:forEach items="${dtoList}" var="dto">
        ${dto.id} | <a href="/note/read?id=${dto.id}">title : ${dto.title}</a> <br>
        <hr>
    </c:forEach>
    <button id="register-button" type="button">register</button>
    <script>
        document.querySelector("#register-button").addEventListener("click",function(e){
            self.location = "/note/register"
        },false)
    </script>
</body>
</html>
