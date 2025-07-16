<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Random" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    <style>
    body {
        margin: 0;
        padding: 0;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        background-color: #f2f2f2;
    }

    form {
        background-color: white;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }

    h1, h2 {
        text-align: center;
    }

    a {
        text-decoration: none;
        color: black;
    }

    button {
        background-color: rgb(159, 159, 219);
        border: none;
        padding: 6px 12px;
        border-radius: 4px;
    }

    h3 {
        text-align: center;
    }

    table {
        margin: auto;
    }

    input[type="submit"] {
        padding: 6px 12px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    </style>
</head>
<body>
    <center>
    <h1><strong>Pentagon Space</strong></h1>
        <h2>Login</h2>
        <%String success=(String)request.getAttribute("success"); %>
        <%if(success!=null){%>
        <h3 style="text-align: center;"><%= success %></h3>
        <%} %>
        <%String error=(String)request.getAttribute("error"); %>
        <%if(error!=null){%>
        <h3 style="text-align: center;"><%= error %></h3>
        <%} %>
        <form action="login" method="post">
            <!-- action takes url as argument which will be passed to @WebServlet("/login") --> 
            <table>
                <tr>
                    <td>Enter the Email ID:</td>
                    <td><input type="email" name="mail"></td>
                </tr>
                <tr>
                    <td><br>Enter the Password:</td>
                    <td><br><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><br>
                        <input type="submit" value="Login">
                        &nbsp;&nbsp;
                        <a href="forgotpass.jsp">Forgot password?</a>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><br>
                        <label>Don't have an account?</label>
                        <a href="Signup.jsp">Signup</a>
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
