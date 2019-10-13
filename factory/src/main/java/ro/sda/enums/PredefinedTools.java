package ro.sda.enums;

public enum PredefinedTools {
	ROBOT("operate robots in production",1),
	LAPTOP("use a laptop",2),
	DRONE("use drones",3),
	PHONE("make phone calls",4),
    ELECTRICVEHICLE("driving eco",5),
    WELDINGTOOL("connect electronic pieces on board",6),
	PLIERS("use pliers",7);
	
	private final String name;
	private final int position;
	private PredefinedTools(String name, int position) {
		this.name = name;
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public int getPosition() {
		return position;
	}
}
