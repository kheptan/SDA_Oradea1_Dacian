package ro.sda.jdbc.request;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.sda.connect.JdbcConnector;
import ro.sda.entities.ClassRoom;
import ro.sda.request.Request;


public class ClassRoomRequest implements Request<ClassRoom> {

	private static final Connection conn = JdbcConnector.openConnection();

	@Override
	public int insert(ClassRoom classroom) {
		Statement stmt;
		int result;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(
					 "INSERT INTO Classroom (name,address) " +
					  "VALUES ('"+classroom.getName()+"','"+classroom.getAddress()+"')");
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@Override
	public int update(ClassRoom classroom) {
		int result;
		Statement stmt;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(
					 "UPDATE Classroom "+
				     "SET name = IF('"+classroom.getName()+"'='',name,'"+classroom.getName()+"'),"+
					 " address = IF('"+classroom.getAddress()+"'='',address, '"+classroom.getAddress()+"')"+
				     " WHERE idClassroom="+classroom.getIdClassroom()+""
		    );
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@Override
	public List<ClassRoom> selectAll() {
		List<ClassRoom> classes = new ArrayList<>();
		try {
			Statement getClassRoom = conn.createStatement();
			ResultSet rs = getClassRoom.executeQuery("SELECT * FROM Classroom");//all teams
			while (rs.next()) {
					classes.add(new ClassRoom(
								rs.getInt("idClassroom"),
								rs.getString("name"),
								rs.getString("address")
						 ));
			}//endwhile
			getClassRoom.close();
		} catch(SQLException e) {
			System.out.println("Opperation failed");
			System.out.println(e.getMessage());
			return null;
		}
		return classes;
	}

	@Override
	public int delete(ClassRoom classroom) {
		Statement stmt;
		int result;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(
					 "DELETE FROM Classroom WHERE name LIKE '%"+classroom.getName()+"'");
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
}
