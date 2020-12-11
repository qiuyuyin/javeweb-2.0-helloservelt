<html>
<head>
    <title>My_first</title>
</head>
<body>
<%= new java.util.Date()%>
<%--java--%>
<hr>

<%
    int sum = 0;
    for (int i = 0; i < 100; i++) {
        sum+=i;
    }
    out.println("<h1>sum:"+sum+"</h1>");
%>

<%!
    static {
        System.out.println("hello");
    }
    private int global = 0;

    public void yili(){
        System.out.println("insert!");
    }
%>
</body>
</html>
