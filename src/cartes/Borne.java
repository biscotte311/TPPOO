package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int km) {
		this.setKm(km);
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}
	
	@Override
	public String toString() {
		return "Borne : "+ this.km +" km";
	}

}
