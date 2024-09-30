package testsFonctionnels;

import java.util.Iterator;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.Parade;
import cartes.Type;
import jeu.Sabot;

public class TestSabot {

	public static void main(String[] args) throws Exception {
		Carte[] cartes = new Carte[4];
		cartes[0] = new Borne(25);
		cartes[1] = new Parade(Type.FEU);
		cartes[2] = new Attaque(Type.FEU);
		cartes[3] = new Botte(Type.FEU);
		Sabot s = new Sabot(cartes);
		System.out.println("Avec piocher \n");
		for (int i = 0; i < cartes.length; i++) {
			System.out.println(s.piocher().toString());
		}

		cartes[0] = new Borne(25);
		cartes[1] = new Parade(Type.FEU);
		cartes[2] = new Attaque(Type.FEU);
		cartes[3] = new Botte(Type.FEU);
		s = new Sabot(cartes);
		System.out.println("\nSans piocher\n"); 
		Iterator<Carte> it = s.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
			it.remove();
		}
		
		System.out.println("\ntest1\n");
		Carte[] carte = new Carte[5];
		carte[0] = new Borne(25);
		carte[1] = new Parade(Type.FEU);
		carte[2] = new Attaque(Type.FEU);
		carte[3] = new Botte(Type.FEU);
		carte[4] = new Botte(Type.FEU);
		s = new Sabot(carte);
		
		it = s.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
			it.remove();
			s.piocher();

		}
		
		System.out.println("\n\n");
		cartes[0] = new Borne(25);
		cartes[1] = new Parade(Type.FEU);
		cartes[2] = new Attaque(Type.FEU);
		cartes[3] = new Botte(Type.FEU);
		s = new Sabot(cartes);
		it = s.iterator();
		s.piocher();
		while (it.hasNext()) {
			it.next();
			it.remove();
			s.piocher();			
			s.ajouterCarte(new Botte(Type.ACCIDENT));			
		}
		
	}

}
