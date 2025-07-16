<%@page import="in.pentagon.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
        <h2>Reset your password</h2>
        <%Student s=(Student)session.getAttribute("student"); %>
        <%String error=(String)request.getAttribute("error"); %>
        <%if(error!=null){%>
        <h3 style="text-align: center;"><%= error %></h3>
        <%} %>
        <form action="reset" method="post">
            <table>
                <tr>
                    <td> <label>Enter Your Phone number :</label><br><br></td>
                    <td><input type="text" name="phone" value="<%=s.getPhone() %>"><br><br></td>
                </tr>
                <tr>
                    <td><label>Enter Your mail id :</label><br><br></td>
                    <td> <input type="email" name="email" value="<%=s.getMail()%>"><br><br></td>
                </tr>
                <tr>
                    <td><label>Enter Your Password :</label><br><br></td>
                    <td><input type="password" name="password"><br><br></td>
                </tr>
                <tr>
                    <td><label>Confirm the password :</label><br><br></td>
                    <td><input type="password" name="confirm"><br><br></td>
                </tr>
                <tr>
                    <td><br><br><input type="submit" value="Reset Password"></td>
                    <td><br><br> <button ><a href="Dashboard.jsp">BACK</a> </button></td>
                </tr>
            </table>   
        </form>
    </center>
</body>
</html>