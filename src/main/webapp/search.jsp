<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
  String id = request.getParameter("userid");
  String driver = "org.postgresql.Driver";
  String connectionUrl = "jdbc:postgresql://localhost:5432/studentmanagementsystem";
  String database = "studentmanagementsystem";
  String userid = "postgres";
  String password = "vinsam@1512";
  try {
    Class.forName(driver);
  } catch (ClassNotFoundException e) {
    e.printStackTrace();
  }
  Connection connection = null;
  Statement statement = null;
  ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<head>
  <style>
  </style>

</head>
<body>
<div class="header">
  <div class="container">


    <div class="navbar">
    <div class="dd">
      <h1>Students Information</h1>
      <table border="1">
        <tr>
          <th>Student Name</th>
          <th>Student Register Number</th>
          <th>Student Phone Number</th>

        </tr>
        <jsp:useBean id="obj" class="com.vinson.sms.StudentBean"/>
        <jsp:setProperty property="*" name="obj" />
        <%
          String a= obj.getRegno();
          try{
            connection = DriverManager.getConnection(connectionUrl, userid, password);
            statement=connection.createStatement();
            resultSet = statement.executeQuery("select*from studentinformation where Stu_Reg_No="  + a + "");
            while(resultSet.next()){
        %>
        <tr>
          <td><%=resultSet.getString("name") %></td>
          <td><%=resultSet.getString("regno") %></td>
          <td><%=resultSet.getString("phno") %></td>

        </tr>
        <%
            }
            connection.close();
          } catch (Exception e) {
            e.printStackTrace();
          }
        %>
      </table>
    </div>
</body>
</html>
