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
    int status = StudentDAO.updateStudent(obj);
    if(status>0){
        out.print("Updated Succesfully");
    }
    else{
        out.print("Updation Failed");
    }
%>
</body>
</html>