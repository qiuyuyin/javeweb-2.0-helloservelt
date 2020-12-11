<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("name1","yili_1");
    request.setAttribute("name2","yili_2");
    session.setAttribute("name3","yili_3");
    application.setAttribute("name4","yili_4");
%>
<%
    String name1 = pageContext.findAttribute("name1").toString();
    String name2 = pageContext.findAttribute("name2").toString();
    String name3 = pageContext.findAttribute("name3").toString();
    String name4 = pageContext.findAttribute("name4").toString();
//    String name5 = pageContext.findAttribute("name5").toString();
//    pageContext.getAttribute("name1");
//    request.getAttribute("name2");
//    session.getAttribute("name3");
//    application.getAttribute("name4");
%>
<h1>value:</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<%--<h3>${name5}</h3>--%>
<%--<h3><%= name5%></h3>--%>

</body>
</html>
