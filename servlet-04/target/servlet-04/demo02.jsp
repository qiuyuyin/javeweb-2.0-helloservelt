<%--
  Created by IntelliJ IDEA.
  User: yili
  Date: 2020/12/11
  Time: 下午9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo02</title>
</head>
<body>
    <%@include file="common/header.jsp"%>
    <h1>index</h1>
    <%@include file="common/footer.jsp"%>
    <hr>

    <jsp:include page="/common/header.jsp"/>
    <h1>index</h1>
    <jsp:include page="/common/footer.jsp"/>
</body>
</html>
