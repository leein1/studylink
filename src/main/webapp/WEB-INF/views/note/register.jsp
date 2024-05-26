<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: leeinwon
  Date: 2024. 5. 25.
  Time: 오후 3:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>레지스터 GET</h1>
    <form action="/note/register" method="post">
        제목<input type="text" name="title"><br>
        내용<input type="text" name="content"><Br>
        <button type="submit">등록</button>
    </form>
    <script>
        const serverValidResult = {}
        <c:forEach items="${errors}" var="error">
        serverValidResult['${error.getField()}'] = '${error.defaultMessage}'
        </c:forEach>

        console.log(serverValidResult)
    </script>
</body>
</html>
