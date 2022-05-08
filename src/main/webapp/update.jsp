<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Update Student Details</title>
  <style>
    form{
      text-align: center;
    }
    input{
      padding: 12px 20px;
      margin: 8px 0;
      box-sizing: border-box;
    }
    input[type=button], input[type=submit], input[type=reset] {
      background-color: #04AA6D;
      border: none;
      color: white;
      padding: 16px 32px;
      text-decoration: none;
      margin: 4px 2px;
      cursor: pointer;
    }
    h2{
      text-align: center;
    }
  </style>
</head>
<body>
<h2>Fill All The Required Details</h2>
<form name="f1" action="update-success.jsp" method="get">
  <label for="name">Full Name:</label><br>
  <input type="text" id="name" name="name"><br>
  <label for="regno">Register Number:</label><br>
  <input type="text" id="regno" name="regno"><br>
  <label for="phno">Phone Number:</label><br>
  <input type="text" id="phno" name="phno"><br>
  <input type="submit">
</form>
</body>
</html>