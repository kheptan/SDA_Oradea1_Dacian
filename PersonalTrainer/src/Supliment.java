
public enum Supliment {
	ENERGYGEL(30), ENERGYGEL_WITH_COFFEE(40), PROTEIN_BARS(50), BANANAS(20), MIRACLE_MIX(70);

	int stamina;

	private Supliment(int stamina) {
		this.stamina = stamina;
	}
}
