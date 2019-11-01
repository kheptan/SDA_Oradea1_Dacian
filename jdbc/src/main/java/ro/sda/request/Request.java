package ro.sda.request;

import java.util.List;

public interface Request<T>{
	
	public int insert(T t);
	
	public int update(T t);
	
	public List<T> selectAll();
	
	public int delete(T t);
}
