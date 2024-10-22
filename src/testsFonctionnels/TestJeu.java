package testsFonctionnels;
import cartes.Borne;
import cartes.DebutLimite;
import cartes.FinLimite;
import joueur.Joueur;
import joueur.ZoneDeJeu;


public class TestJeu {
    public static void main(String[] args) {
        ZoneDeJeu zone = new ZoneDeJeu();
        Joueur joueur = new Joueur("Alice", zone);

        // Déposer des cartes de type Borne
        joueur.deposer(new Borne(25));
        joueur.deposer(new Borne(50));
        joueur.deposer(new Borne(75));

        // Afficher les km parcourus
        System.out.println("Total des bornes : " + joueur.donnerKmParcourus());
        
        System.out.println("Limite : " + zone.donnerLimitationVitesse());

        // Déposer des cartes de limitation et fin de limitation
        joueur.deposer(new DebutLimite());
        System.out.println("Limite : " + zone.donnerLimitationVitesse());

        joueur.deposer(new FinLimite());
        System.out.println("Limite : " + zone.donnerLimitationVitesse());
    }
}
