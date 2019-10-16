package ro.sda.worktool;

public class Laptop extends WorkTool {

	public Laptop(String name) {
		super(name);
	}

	@Override
	public void action() {
		System.out.println("I'm using a laptop");
	}

}
