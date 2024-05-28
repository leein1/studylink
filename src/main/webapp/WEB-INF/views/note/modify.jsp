<%--
  Created by IntelliJ IDEA.
  User: leeinwon
  Date: 2024. 5. 27.
  Time: 오후 5:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>modify</h1>
    <form>
        <input type="number" value="${dto.id}" name="id" readonly>
        <input type="date" value="${dto.createdate}" readonly>
        <input type="text" value="${dto.title}" name="title">
        <input type="text" value="${dto.content}" name="content">

        <button id="modify-button" type="button">modify</button>
    </form>
    <script>
        const formObj = document.querySelector("form")

        document.querySelector("#modify-button").addEventListener("click",function (e){

            e.preventDefault()
            e.stopPropagation()

            formObj.action = "/note/modify"
            formObj.method = "post"

            formObj.submit()
        },false)

    </script>

</body>
</html>
