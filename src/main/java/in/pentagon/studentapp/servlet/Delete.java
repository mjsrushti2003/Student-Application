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
@WebServlet("/delete")
public class Delete extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO dao=new StudentDaoImpl();
		boolean res=dao.deleteStudent(Integer.parseInt(req.getParameter("id")));
		if(res) {
			req.setAttribute("success", "User record deleted successfully");
			RequestDispatcher rd=req.getRequestDispatcher("ViewUser.jsp");
			rd.forward(req, resp);
		}
		else {
			req.setAttribute("error", "Failed to delete user record");
			RequestDispatcher rd=req.getRequestDispatcher("ViewUser.jsp");
			rd.forward(req, resp);
		}
	}

}
