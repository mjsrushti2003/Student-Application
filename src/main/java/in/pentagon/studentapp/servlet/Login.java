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
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
		StudentDAO sdao=new StudentDaoImpl();
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession(true);
		Student s=sdao.getStudent(req.getParameter("mail"),req.getParameter("password"));
		if(s!=null) {
			//out.println("<h1>Login Successfull</h1>");
			session.setAttribute("student", s);
			req.setAttribute("success", "Login Successfull");
			RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
			rd.forward(req, resp);
		}
		else {
			//out.println("<h1>Login failed</h1>");
			req.setAttribute("error", "Login Failed");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
	}

	
}
