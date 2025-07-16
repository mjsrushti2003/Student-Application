package in.pentagon.studentapp.servlet;

import java.io.IOException;
import java.util.ArrayList;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDaoImpl;
import in.pentagon.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/searchuser")
public class SearchUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO dao=new StudentDaoImpl();
		ArrayList<Student> users=dao.getStudent(req.getParameter("user"));
		req.setAttribute("users", users);
		RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
		rd.forward(req, resp);
	}
}
