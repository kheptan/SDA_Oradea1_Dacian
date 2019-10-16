package ro.sda.worktool;

public abstract class WorkTool {
	final String name;

	public WorkTool(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public abstract void action();
}
