<%@page import="in.pentagon.studentapp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Application Form</title>
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
        <h2>Update Your Account</h2>
        <%Student s=(Student)session.getAttribute("student"); %>
        <%String error=(String)session.getAttribute("error"); %>
        <%if(error!=null){ %>
        <h3><%=error %></h3>
        <%} %>
        <form action="update" method="post">
            <table>
                <tr>
                    <td><label>Enter Your Name:</label><br><br></td>
                    <td><input type="text" name="name" value="<%=s.getName() %>"><br><br></td>
                </tr>
                <tr>
                    <td><label>Enter Your Phone Number:</label><br><br></td>
                    <td><input type="text" name="phone" value="<%=s.getPhone() %>"><br><br></td>
                </tr>
                <tr>
                    <td><label>Enter Your Mail ID:</label><br><br></td>
                    <td><input type="email" name="email" value="<%=s.getMail() %>"><br><br></td>
                </tr>
                <tr>
                    <td><label>Enter the Branch:</label><br><br></td>
                    <td><input type="text" name="branch" value="<%=s.getBranch() %>"><br><br></td>
                </tr>
                <tr>
                    <td><label>Enter Your Location:</label><br><br></td>
                    <td><input type="text" name="location" value="<%=s.getLoc() %>"><br><br></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <br>
                        <input type="submit" value="Update Account">
                        <br><br>
                      
                        <a href="Dashboard.jsp">Back</a>
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
