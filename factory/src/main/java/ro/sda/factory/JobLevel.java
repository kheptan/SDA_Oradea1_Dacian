package ro.sda.factory;

public enum JobLevel {
    DIRECTOR(1),
    MANAGER(2),
    WORKER(3);
	
	final int level;

	private JobLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}
}
