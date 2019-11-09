package ro.sda.hibernate.request;

import java.util.List;

import org.hibernate.Session;

import ro.sda.bootstrap.BootStrap;
import ro.sda.entities.Attendence;
import ro.sda.request.Request;

public class AttendenceRequest implements Request<Attendence> {
	private static final Session session = BootStrap.getSession();
	
	@Override
	public int insert(Attendence t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Attendence t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Attendence> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Attendence t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
