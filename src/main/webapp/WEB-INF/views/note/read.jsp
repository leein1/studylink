<%--
  Created by IntelliJ IDEA.
  User: leeinwon
  Date: 2024. 5. 26.
  Time: 오후 6:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>note read</h1>
    <form action="modify" method="get">
        <c:if test="${not empty dto}">
            ${dto.id}<br>
            ${dto.title}<br>
            ${dto.content}<br>
            ${dto.createdate}<br>
        </c:if>
        <button id="remove-button" type="button">remove</button>
    </form>
    <script>
        const formObj = document.querySelector("form")

        document.querySelector("#remove-button").addEventListener("click",function (e){

            e.preventDefault()
            e.stopPropagation()

            formObj.action = "/note/remove?id=${dto.id}"
            formObj.method = "post"

            formObj.submit()
        },false)
    </script>
</body>
</html>
