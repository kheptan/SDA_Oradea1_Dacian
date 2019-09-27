package refactor;

public class StatementBody {
	private String title;
	private double amount;
	
	public StatementBody(String title,double amount) {
		this.amount = amount;
		this.title = title;
	}

	public double getAmount() {
		return amount;
	}

	public String getTitle() {
		return title;
	}

}
