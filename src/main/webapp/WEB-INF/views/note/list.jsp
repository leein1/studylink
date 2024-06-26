<%--
  Created by IntelliJ IDEA.
  User: leeinwon
  Date: 2024. 5. 25.
  Time: 오후 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>note list</h1>

    <div class="searchOption">
<%--        <c:if test="${not empty searchDTO }">--%>
<%--            <c:forEach items="${searchDTO.types}" var="type">--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${type eq 'title'}">--%>
<%--                        <c:set var="titleStatus" value="true"></c:set>--%>
<%--                    </c:when>--%>
<%--                    <c:when test="${type eq 'content'}">--%>
<%--                        <c:set var="contentStatus" value="true"></c:set>--%>
<%--                    </c:when>--%>
<%--                </c:choose>--%>
<%--            </c:forEach>--%>
<%--            &lt;%&ndash;    DEBUG&ndash;%&gt;--%>
<%--            <script>--%>
<%--                console.log("${searchDTO.checkType('title')}");--%>
<%--            </script>--%>
<%--            &lt;%&ndash;    DEBUG&ndash;%&gt;--%>
<%--        </c:if>--%>

<%--        <form action="/note/list" method="get">--%>
<%--            제목 검색<input type="checkbox" value="title" name="types" <c:if test="${titleStatus}">checked</c:if>>--%>
<%--            내용 검색<input type="checkbox" value="content" name="types" <c:if test="${contentStatus}">checked</c:if> >--%>
<%--            검색어 : <input type="text" name="keyword" <c:if test="${not empty searchDTO.keyword}">value="${searchDTO.keyword}" </c:if>>--%>
<%--            <button type="submit">Search</button>--%>
<%--        </form>--%>
        <form action="/note/list" method="get">
            제목 검색<input id="title" type="checkbox" value="title" name="types" ${searchDTO.checkType('title') ? "checked" : ""}>
            내용 검색<input id="content" type="checkbox" value="content" name="types" ${searchDTO.checkType('content') ? "checked" : ""}>
            검색어 : <input id="keyword" type="text" name="keyword" value="${searchDTO.keyword}">
            <button type="submit">Search</button>
        </form>
        <script>
            document.querySelector("form").addEventListener("submit",function(e){

                let keyword = document.querySelector("#keyword").value.trim();
                let title = document.querySelector("#title").checked;
                let content = document.querySelector("#content").checked;

                if(!title && !content){

                    e.preventDefault();
                    alert("검색 조건을 체크 해주세요");
                }else if(!keyword){

                   e.preventDefault();
                   alert("검색어를 입력해주세요");
               }
            },false);
        </script>
    <%--        <form id="searchForm" action="/note/list" method="get">--%>

<%--            &lt;%&ndash; DEBUG&ndash;%&gt;--%>
<%--            <c:forEach var="type" items="${paramValues.types}">--%>
<%--                <script>--%>
<%--                    console.log("types: " + "${type}");--%>
<%--                </script>--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${type eq 'title'}">--%>
<%--                        <c:set var="titleStatus" value="true"/>--%>
<%--                        <script>--%>
<%--                            console.log("title: " + "${titleStatus}");--%>
<%--                        </script>--%>
<%--                    </c:when>--%>
<%--                    <c:when test="${type eq 'content'}">--%>
<%--                        <c:set var="contentStatus" value="true"/>--%>
<%--                        <script>--%>
<%--                            console.log("content: " + "${contentStatus}");--%>
<%--                        </script>--%>
<%--                    </c:when>--%>
<%--                </c:choose>--%>
<%--            </c:forEach>--%>
<%--            &lt;%&ndash; DEBUG&ndash;%&gt;--%>


<%--            제목 검색<input id="titleCheckbox" type="checkbox" value="title" name="types" <c:if test="${titleStatus}">checked</c:if>>--%>
<%--            내용 검색<input id="contentCheckbox" type="checkbox" value="content" name="types" <c:if test="${contentStatus}">checked</c:if>>--%>
<%--            검색어 : <input type="text" value="${param.keyword}" name="keyword">--%>
<%--            <button type="submit">Search</button>--%>
<%--        </form>--%>
    </div>
<%--  <div class="searchOption">  --%>
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
