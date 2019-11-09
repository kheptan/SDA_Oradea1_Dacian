package ro.sda.hibernate.repository;

import java.util.List;

import ro.sda.entities.ClassRoom;
import ro.sda.hibernate.request.ClassRoomRequest;

public class ClassRoomQuery {
	
	public static void createNewClassRoom(String name,String address) {
		int classroomRequest = new ClassRoomRequest().insert(new ClassRoom(name,address));
		if( classroomRequest == 1) { System.out.println("Succes!");}
		else { System.out.println("Not inserted"); }
	}
	
	public static List<ClassRoom> getAllClassRooms(){
		return new ClassRoomRequest().selectAll();
	}
	
	public static ClassRoom getClassByName(String byName) {
		return new ClassRoomRequest().getClassRoom(byName);
	}
	
	
	public static void deleteClassRoom(String byName) {
		ClassRoom classRoom = getClassByName(byName);
		if(classRoom!=null) {
			new ClassRoomRequest().delete(classRoom);
		} else {
			System.out.println("Didn't find the course");
		}
	}
}
