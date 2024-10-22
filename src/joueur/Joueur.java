package joueur;

import cartes.Carte;
import jeu.Sabot;

public class Joueur {

	private String nom;
	private ZoneDeJeu zoneDeJeu;
	private MainJoueur mainJoueur;

	public Joueur(String nom, ZoneDeJeu zoneDeJeu) {
		this.setNom(nom);
		this.setZoneDeJeu(zoneDeJeu);
		this.mainJoueur = new MainJoueur(); // Initialisation de la main
	}

	public void donner(Carte carte) {
		this.mainJoueur.prendre(carte);
	}

	public Carte prendreCarte(Sabot sabot) {
		if (sabot.estVide()) {
			return null;
		}
		Carte carte = sabot.piocher();
		this.mainJoueur.prendre(carte);
		return carte;
	}

	public int donnerKmParcourus() {
		return this.zoneDeJeu.donnerKmParcourus();
	}

	public void deposer(Carte c) {
		zoneDeJeu.deposer(c); // Délégué à ZoneDeJeu
	}

	private boolean peutAvancer() {
		return zoneDeJeu.peutAvancer();
	}

	public boolean estDepotAutorise(Carte carte) {
		if (this.peutAvancer()) {
			return zoneDeJeu.estDepotAutorise(carte);
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Joueur) {
			return ((Joueur) o).getNom().equals(this.getNom());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Nom : " + this.nom + "\n";
	}

	// default methode
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public ZoneDeJeu getZoneDeJeu() {
		return zoneDeJeu;
	}

	public void setZoneDeJeu(ZoneDeJeu zoneDeJeu) {
		this.zoneDeJeu = zoneDeJeu;
	}

	public MainJoueur getMainJoueur() {
		return mainJoueur;
	}

}
