package cartes;
public enum Type {
	FEU("Rouge", "Vert", "Véhicule priotitaire"),
	ESSENCE("Panne d'essence", "Essence", "Citern d'essence"),
	CREVAISON("Crevaison", "Roue de seours", "Increvable"),
	ACCIDENT("Accident", "Réparations", "As du volant");
	
	public final String attaque;
	public final String parade;
	public final String botte;
	private Type(String attaque, String parade, String botte) {
		this.attaque = attaque;
		this.parade = parade;
		this.botte = botte;
	}
}
