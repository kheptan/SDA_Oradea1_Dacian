package ro.sda.worktool;

public class Pen extends WorkTool {

	public Pen(String name) {
		super(name);
	}

	@Override
	public void action() {
		System.out.println("I'm using a pen");
	}
    
}
