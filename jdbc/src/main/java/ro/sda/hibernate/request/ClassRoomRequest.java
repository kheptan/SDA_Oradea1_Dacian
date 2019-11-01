package ro.sda.hibernate.request;

import java.util.List;

import org.hibernate.Session;

import ro.sda.bootstrap.BootStrap;
import ro.sda.entities.ClassRoom;
import ro.sda.request.Request;

public class ClassRoomRequest implements Request<ClassRoom> {
	private static final Session session = BootStrap.getSession();

	@Override
	public int insert(ClassRoom t) {
		return 0;
	}

	@Override
	public int update(ClassRoom t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ClassRoom> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(ClassRoom t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
