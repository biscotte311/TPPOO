package cartes;

public class Configuration {

	private int nbExemplaires;
	private Carte carte;
	
	public Configuration(Carte carte, int nbExemeplaires) {
		this.setCarte(carte);
	}

	public int getNbExemplaires() {
		return nbExemplaires;
	}

	public void setNbExemplaires(int nbExemplaires) {
		this.nbExemplaires = nbExemplaires;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

}
