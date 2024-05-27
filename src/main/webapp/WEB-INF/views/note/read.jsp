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
    <form>
        <c:if test="${not empty dto}">
            ${dto.id}<br>
            ${dto.title}<br>
            ${dto.content}<br>
            ${dto.createdate}<br>
        </c:if>
        
        <button id="remove-button" type="button">remove</button>
        <button id="modify-button" type="button">modify</button>
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

        document.querySelector("#modify-button").addEventListener("click",function (e){

            e.preventDefault()
            e.stopPropagation()
            self.location = "/note/modify?id=${dto.id}"
            <%--formObj.action = "/note/modify?id=${dto.id}"--%>
            <%--formObj.method = "get"--%>

            <%--formObj.submit()--%>
            <%--           위 주석은 잘못된 코드였다...--%>
        },false)
    </script>
</body>
</html>
