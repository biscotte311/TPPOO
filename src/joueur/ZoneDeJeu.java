package joueur;

import java.util.LinkedList;
import cartes.Carte;
import cartes.Cartes;
import cartes.DebutLimite;
import cartes.Borne;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;
import cartes.Attaque;
import cartes.Bataille;

public class ZoneDeJeu {

	private LinkedList<Carte> vitesse; // Limitation ou fin de limitation de vitesse
	private LinkedList<Carte> bataille; // Pile d'attaques et de parades
	private LinkedList<Carte> bornes; // Collection de bornes (km parcourus)

	public ZoneDeJeu() {
		this.vitesse = new LinkedList<>();
		this.bataille = new LinkedList<>();
		this.bornes = new LinkedList<>();
	}

	public int donnerLimitationVitesse() {
		if (vitesse.isEmpty()) {
			return 200;
		}

		Carte derniereCarte = this.vitesse.get(this.vitesse.size() - 1); // Récupère la dernière carte de la pile
		if (derniereCarte instanceof FinLimite) {
			return 200;
		} else if (derniereCarte instanceof DebutLimite) {
			return 50;
		}

		return 200;
	}

	public int donnerKmParcourus() {
		int totalKm = 0;
		for (Carte carte : bornes) {
			if (carte instanceof Borne) {
				totalKm += ((Borne) carte).getKm();
			}
		}
		return totalKm;
	}

	public void deposer(Carte c) {
		if (c instanceof Borne) {
			bornes.add(c);
		} else if (c instanceof DebutLimite || c instanceof FinLimite) {
			vitesse.add(c);
		} else if (c instanceof Bataille) {
			bataille.add(c);
		}
	}

	public boolean peutAvancer() {
		if (this.bataille.isEmpty())
			return false;
		return this.bataille.get(this.bataille.size() - 1).equals(Cartes.FEU_VERT);
	}

	public boolean estDepotFeuVertAutorise() {
		if (this.bataille.isEmpty())
			return true; // Si la pile est vide, le feu vert peut être déposé.

		Carte sommet = this.bataille.get(this.bataille.size() - 1);
		return sommet.equals(Cartes.FEU_ROUGE) && !sommet.equals(Cartes.FEU_VERT);
	}

	public boolean estDepotBorneAutorise(Borne borne) {
		return peutAvancer() && donnerKmParcourus() + borne.getKm() <= 1000
				&& borne.getKm() <= donnerLimitationVitesse();
	}

	public boolean estDepotLimiteAutorise(Limite limite) {
		if (limite instanceof DebutLimite) {
			return vitesse.isEmpty() || vitesse.get(vitesse.size() - 1) instanceof FinLimite;
		}
		if (limite instanceof FinLimite) {
			return !vitesse.isEmpty() && vitesse.get(vitesse.size() - 1) instanceof DebutLimite;
		}
		return false;
	}

	public boolean estDepotBatailleAutorise(Bataille bataille) {
		if (bataille instanceof Attaque) {
			return peutAvancer(); // Une attaque peut être déposée seulement si le joueur peut avancer (donc pas
									// déjà bloqué).
		} else if (bataille instanceof Parade) {
			if (bataille.equals(Cartes.FEU_VERT)) {
				if (this.bataille.isEmpty()) {
					return true;
				}
				Carte sommet = this.bataille.get(this.bataille.size() - 1);
				return sommet.equals(Cartes.FEU_ROUGE) || sommet.equals(Cartes.FEU_VERT) ;
			}else {
				if (this.bataille.isEmpty()) {
					return false;
				}
				Carte sommet = this.bataille.get(this.bataille.size() - 1);
				if (sommet instanceof Attaque) {
					Type typeSommet = ((Attaque) sommet).getType();
					return bataille.getType() == typeSommet;
				}
			}
		}
		return false;
	}
	
	public boolean estDepotAutorise(Carte carte) {
		if (carte instanceof Borne) {
			return estDepotBorneAutorise((Borne) carte);
		} else if (carte instanceof Limite) {
			return estDepotLimiteAutorise((Limite) carte);
		} else if (carte instanceof Bataille) {
			return estDepotBatailleAutorise((Bataille) carte);
		}
		return false; // Si aucun des cas précédents
	}

	//

	public LinkedList<Carte> getBornes() {
		return bornes;
	}
}
