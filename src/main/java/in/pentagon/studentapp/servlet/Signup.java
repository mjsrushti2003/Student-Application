package in.pentagon.studentapp.servlet;

import in.pentagon.studentapp.dao.StudentDaoImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
		//Creation of POJO class object
		Student s=new Student();
		StudentDAO sdao=new StudentDaoImpl();
		PrintWriter out=resp.getWriter();
		s.setName(req.getParameter("name"));
		s.setPhone(Long.parseLong(req.getParameter("phone")));
		s.setMail(req.getParameter("email"));
		s.setBranch(req.getParameter("branch"));
		s.setLoc(req.getParameter("location"));
		if(req.getParameter("password").equals(req.getParameter("confirm"))) {
			s.setPassword(req.getParameter("password"));
			boolean res=sdao.insertStudent(s);
			if(res) {
				//out.println("<h1>Data saved successfully</h1>");
				req.setAttribute("success", "Account Created Successfully");
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);;
			}
			else {
				//out.println("<h1>Failed to add data</h1>");
				req.setAttribute("error","Failed to Create Account");
				RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
				rd.forward(req, resp);
			}
		}
		else {
			//out.println("<h1>Password mismatch</h1>");
			req.setAttribute("error","Password Mismatch");
			RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
			rd.forward(req, resp);
		}
	}
}
