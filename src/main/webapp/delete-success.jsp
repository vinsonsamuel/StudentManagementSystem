<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.vinson.sms.*" %>
<%@ page import="com.vinson.sms.StudentDAO" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<jsp:useBean id="obj" class="com.vinson.sms.StudentBean"/>
<jsp:setProperty name="obj" property="*"/>
<%
    int status = StudentDAO.deleteStudent(obj);
    if(status>0){
        out.print("Deleted Succesfully");
    }
    else{
        out.print("Deletion Failed");
    }
%>
</body>
</html>