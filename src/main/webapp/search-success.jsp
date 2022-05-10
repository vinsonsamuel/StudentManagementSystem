<%@ page import="java.sql.ResultSet" import="com.vinson.sms.StudentDAO"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.vinson.sms.ConnectionProvider" %>
<%@ page import="java.sql.Statement" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search</title>
    <style>
        h1{
            text-align: center;
        }
        .center {
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="container">
        <div class="navbar">
            <div class="dd">
                <h1>Students Information</h1>
                <table class="center" border="1">
                    <tr>
                        <th>Register Number</th>
                        <th>Student Full Name</th>
                        <th>Student Phone Number</th>
                    </tr>
                    <jsp:useBean id="obj" class="com.vinson.sms.StudentBean"/>
                    <jsp:setProperty property="*" name="obj" />
                    <%
                        int a= obj.getRegno();
                        Connection conn = null;
                        String sql;
                        if(a==0) {
                            sql = "select*from studentdetails";
                        }else{
                            sql = "select*from studentdetails where regno=" + a + "";
                        }
                        try{
                            conn = ConnectionProvider.getCon();
                            Statement statement = conn.createStatement();
                            ResultSet resultSet = statement.executeQuery(sql);
                            while(resultSet.next()){
                    %>
                    <tr>
                        <td><%=resultSet.getInt("regno") %></td>
                        <td><%=resultSet.getString("name") %></td>
                        <td><%=resultSet.getString("phone") %></td>
                    </tr>
                    <%
                            }
                            conn.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    %>
                </table>
            </div>
</body>
</html>