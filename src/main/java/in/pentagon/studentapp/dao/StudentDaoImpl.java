package in.pentagon.studentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import in.pentagon.studentapp.connection.Connector;
import in.pentagon.studentapp.dto.Student;

public class StudentDaoImpl implements StudentDAO {
	Connection con =Connector.requestConnection();
	PreparedStatement ps=null;
	ResultSet rs=null; 
	@Override
	public boolean insertStudent(Student s) {
		int res = 0;
		String query="INSERT INTO STUDENT VALUES(0,?,?,?,?,?,?,SYSDATE())";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,s.getName());
			ps.setLong(2,s.getPhone());
			ps.setString(3,s.getMail());
			ps.setString(4,s.getBranch());
			ps.setString(5,s.getLoc());
			ps.setString(6,s.getPassword());
			res=ps.executeUpdate();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		if(res>=1) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean updateStudent(Student s) {
		String query="UPDATE STUDENT SET NAME=?,PHONE=?,MAIL=?,BRANCH=?,LOCATION=?,PASSWORD=? WHERE ID=?";
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMail());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLoc());
			ps.setString(6, s.getPassword());
			ps.setInt(7, s.getId());
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public boolean deleteStudent(int id) {
		String query="DELETE FROM STUDENT WHERE ID=?";
		int i=0;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public Student getStudent(String mail, String password) {
	    String query = "SELECT * FROM STUDENT WHERE MAIL=? AND PASSWORD=?";
	    Student s=null;
	    try {
	        ps = con.prepareStatement(query);
	        ps.setString(1, mail);
	        ps.setString(2, password);
	        rs = ps.executeQuery();
	        while(rs.next()) {
	            s = new Student();
	            s.setId(rs.getInt("id"));
	            s.setName(rs.getString("name"));
	            s.setPhone(rs.getLong("phone"));
	            s.setMail(rs.getString("mail"));
	            s.setBranch(rs.getString("branch"));
	            s.setLoc(rs.getString("location"));
	            s.setPassword(rs.getString("password"));
	            s.setDate(rs.getString("date"));
	            
	        } 
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	    return s;
	}

	@Override
	public Student getStudent(long phone, String mail) {
		String query="SELECT * FROM STUDENT WHERE PHONE=? AND MAIL=?";
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			ps.setLong(1, phone);
			ps.setString(2, mail);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
	            s.setName(rs.getString("name"));
	            s.setPhone(rs.getLong("phone"));
	            s.setMail(rs.getString("mail"));
	            s.setBranch(rs.getString("branch"));
	            s.setLoc(rs.getString("location"));
	            s.setPassword(rs.getString("password"));
	            s.setDate(rs.getString("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	@Override
	public ArrayList<Student> getStudent() {
		String query="SELECT * FROM STUDENT WHERE ID!=1";
		ArrayList<Student> studentlist=new ArrayList<Student>();
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				s = new Student();
	            s.setId(rs.getInt("id"));
	            s.setName(rs.getString("name"));
	            s.setPhone(rs.getLong("phone"));
	            s.setMail(rs.getString("mail"));
	            s.setBranch(rs.getString("branch"));
	            s.setLoc(rs.getString("location"));
	            s.setPassword(rs.getString("password"));
	            s.setDate(rs.getString("date"));
	            studentlist.add(s);
			}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentlist;
	}
	@Override
	public ArrayList<Student> getStudent(String name) {
		String query="SELECT * FROM STUDENT WHERE NAME=?";
		ArrayList<Student> studentlist=new ArrayList<Student>();
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, name);
			rs=ps.executeQuery();
			while(rs.next()) {
				s = new Student();
	            s.setId(rs.getInt("id"));
	            s.setName(rs.getString("name"));
	            s.setPhone(rs.getLong("phone"));
	            s.setMail(rs.getString("mail"));
	            s.setBranch(rs.getString("branch"));
	            s.setLoc(rs.getString("location"));
	            s.setPassword(rs.getString("password"));
	            s.setDate(rs.getString("date"));
	            studentlist.add(s);
			}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentlist;
	}

	@Override
	public Student changepassword(String password) {
		String query="SELECT * FROM STUDENT WHERE PASSWORD=?";
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, password);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
	            s.setName(rs.getString("name"));
	            s.setPhone(rs.getLong("phone"));
	            s.setMail(rs.getString("mail"));
	            s.setBranch(rs.getString("branch"));
	            s.setLoc(rs.getString("location"));
	            s.setPassword(rs.getString("password"));
	            s.setDate(rs.getString("date"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}
}
