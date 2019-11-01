package ro.sda.jdbc.request;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.sda.connect.JdbcConnector;
import ro.sda.entities.Person;
import ro.sda.entities.Team;
import ro.sda.request.Request;

public class TeamRequest implements Request<Team> {
	
	private static final Connection conn = JdbcConnector.openConnection();

	@Override
	public int insert(Team t) {
		Statement stmt;
		int result;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(
					 "INSERT INTO Team (name,maxStudents) " +
					  "VALUES ('"+t.getName()+"','"+t.getMaxStudents()+"')");
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@Override
	public int update(Team t) {
		Statement stmt;
		int result;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(
					 "UPDATE Team "+
				     "SET name = IF('"+t.getName()+"'='',name,'"+t.getName()+"'),"+
					 " maxStudents = IF("+t.getMaxStudents()+"=0,maxStudents,"+t.getMaxStudents()+")"+
				     " WHERE idTeam="+t.getIdTeam()+""
		    );
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@Override
	public List<Team> selectAll() {
		List<Team> teams = new ArrayList<>();
		try {
			Statement getTeam = conn.createStatement();
			Statement getPerson = conn.createStatement();
			ResultSet rs = getTeam.executeQuery("SELECT * FROM Team");//all teams

			while (rs.next()) {
				//get team ID
				int idTeam = rs.getInt("idTeam");
				
				List<Person> persons = new ArrayList<>();

				//add all persons where id=idTeam				
				ResultSet rsPers = getPerson.executeQuery("SELECT * FROM Person "
						+ " WHERE isTrainer=0 and idTeam = " + idTeam);
				
				while (rsPers.next()) {
					persons.add(new Person(
								rsPers.getInt("idPerson"),
								rsPers.getString("firstName"),
								rsPers.getString("lastName"),
								rsPers.getString("email"),
								rsPers.getByte("isTrainer"),
								rsPers.getInt("idTeam")
						 ));
				}
				//add a new team in list
				teams.add( new Team(
							rs.getInt("idTeam"),
							rs.getString("name"),
							rs.getInt("maxStudents"),
							persons)
					     );
			}//endwhile
			
			getPerson.close();
			getTeam.close();
		} catch(SQLException e) {
			System.out.println("Opperation failed");
			System.out.println(e.getMessage());
			return null;
		}
		return teams;
	}

	@Override
	public int delete(Team t) {
		Statement stmt;
		int result;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(
					 "DELETE FROM Team WHERE name LIKE '%"+t.getName()+"'");
		} catch (SQLException e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}


}
