package in.pentagon.studentapp.servlet;

import java.io.IOException;

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
@WebServlet("/reset")
public class ResetPassword extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		StudentDAO dao=new StudentDaoImpl();
		Student s=(Student)hs.getAttribute("student");
		if(Long.parseLong(req.getParameter("phone"))==s.getPhone()&& req.getParameter("email").equals(s.getMail())){
			if(req.getParameter("password").equals(req.getParameter("confirm"))) {
				s.setPassword(req.getParameter("password"));
				boolean res=dao.updateStudent(s);
				if(res) {
					req.setAttribute("success", "Password reset successfull");
					RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
					rd.forward(req, resp);
				}
				else {
					req.setAttribute("error", "Failed to reset the password");
					RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
					rd.forward(req, resp);
				}
			}
			else {
				req.setAttribute("error", "Password Mismatch!");
				RequestDispatcher rd=req.getRequestDispatcher("ResetPassword.jsp");
				rd.forward(req, resp);
			}
		}
		else {
			req.setAttribute("error", "Invalid data,No sudent found!");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
		
	}

}
