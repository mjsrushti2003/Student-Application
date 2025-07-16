package in.pentagon.studentapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDaoImpl;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/forget")
public class ForgotPassward extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
		StudentDAO sdao=new StudentDaoImpl();
		PrintWriter out=resp.getWriter();
		Student s=sdao.getStudent(Long.parseLong(req.getParameter("phone")),req.getParameter("email"));
		if(s!=null) {
			if(req.getParameter("password").equals(req.getParameter("confirm"))) {
				s.setPassword(req.getParameter("password"));
				boolean res=sdao.updateStudent(s);
				if(res) {
					//out.println("Password reset successfull");
					req.setAttribute("success", "Password reset successfull");
					RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);
				}
				else {
					//out.println("Password reset failed!");
					req.setAttribute("error","Password reset failed!");
					RequestDispatcher rd=req.getRequestDispatcher("forgotpass.jsp");
					rd.forward(req, resp);
				}
			}
			else {
				req.setAttribute("error","Password Mismatch");
				RequestDispatcher rd=req.getRequestDispatcher("forgotpass.jsp");
				rd.forward(req, resp);
			}
		}
		else {
			//out.println("<h1>Invalid data</h1>");
			req.setAttribute("error","Invalid data!");
			RequestDispatcher rd=req.getRequestDispatcher("forgotpass.jsp");
			rd.forward(req, resp);
		}
	}


}
