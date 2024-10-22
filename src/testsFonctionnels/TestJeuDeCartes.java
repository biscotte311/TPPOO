package testsFonctionnels;

import java.util.LinkedList;

import cartes.Borne;
import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class TestJeuDeCartes {

	public TestJeuDeCartes() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		JeuDeCartes jeu = new JeuDeCartes();
		Carte cartes[] = jeu.donneCarte();
//		System.out.println(jeu.affichageJeuDeCartes());
		System.out.println("checkout : "+jeu.checkCount(cartes));

		LinkedList<Carte> LinkedListeCarteNonMelangee = new LinkedList<>();
		for (Carte carte : jeu.donneCarte()) {
			LinkedListeCarteNonMelangee.add(carte);
		}
		LinkedList<Carte> LinkedListeCartes = new LinkedList<>(LinkedListeCarteNonMelangee);
//		System.out.println(LinkedListeCartes);
		Carte c1 = new Borne(25);
		System.out.println(LinkedListeCartes.contains(c1));
		
		LinkedListeCartes = GestionCartes.melanger(LinkedListeCartes);
//		System.out.println(LinkedListeCartes);
		System.out.println("LinkedListe mélangée sans erreur ? "
				+ GestionCartes.verifierMelange(LinkedListeCarteNonMelangee, LinkedListeCartes) +"\n");
//		System.out.println(GestionCartes.rassembler(LinkedListeCartes));
		System.out.println(
				"LinkedListe rassemblée sans erreur ? " + GestionCartes.verifierRassemblement(GestionCartes.rassembler(LinkedListeCartes)));
	}

}
