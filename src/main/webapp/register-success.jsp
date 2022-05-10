<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.vinson.sms.*" %>
<%@ page import="com.vinson.sms.StudentDAO" %>
<%@ page import="java.io.PrintWriter" %>
<html>
<head>
  <title>Success</title>
</head>
<body>
<jsp:useBean id="obj" class="com.vinson.sms.StudentBean"/>
<jsp:setProperty name="obj" property="*"/>
<%
  String alert;
  int status = StudentDAO.insertStudent(obj);
  if(status>0){
    alert="Inserted Successfully";
  }
  else{
    alert = "Insertion Failed";
  }
  out.print(alert);
%>
</body>
</html>
