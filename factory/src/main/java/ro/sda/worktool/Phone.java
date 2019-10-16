package ro.sda.worktool;

public class Phone extends WorkTool {

	public Phone(String name) {
		super(name);
	}

	@Override
	public void action() {
		System.out.println("I'm using a phone");
	}
}
