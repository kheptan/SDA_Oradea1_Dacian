package ro.sda.hibernate.repository;

import java.util.List;

import ro.sda.entities.Team;
import ro.sda.hibernate.request.ModuleRequest;

public class ModuleQuery {
	private static void printTeamsByLocation(String location) {
		List<Team> teams = new ModuleRequest().getTeamByLocation(location);
		if (teams!=null) {
			teams.forEach(e->{
				System.out.println(e.getName());
			});
		}
	}
	
	public static void  printTeamsInMarch(String location){
		List<Team> teams = new ModuleRequest().getTeamsInMarch(location);
		if (teams!=null) {
			teams.forEach(e->{
				System.out.println(e.getName());
			});
		}
	}
}
