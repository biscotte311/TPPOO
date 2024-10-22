package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import cartes.Carte;

public class GestionCartes {

	public GestionCartes() {

	}

	public static Carte extraire(LinkedList<Carte> cartes) {
		int i = (int) (Math.random() * cartes.size());
		return cartes.remove(i);
	
	}
	public static Carte extraireV2(List<Carte> cartes) {
		Carte c = null;
		int i = (int) (Math.random() * cartes.size());
		ListIterator<Carte> lc = cartes.listIterator();
		for(int id = 0; id <= i; id++) {
			c = lc.next();
		}
		lc.remove();
		return c;
	}

	public static LinkedList<Carte> melanger(List<Carte> cartes) {
		LinkedList<Carte> l = new LinkedList<Carte>(cartes);
		LinkedList<Carte> c = new LinkedList<>();
		Carte carte= null;
		while (l.size() != 0) {
			carte = extraire(l);
			c.add(carte);
		}
		return c;
	}

	public static boolean verifierMelange(List<Carte> c1, List<Carte> c2) {
		boolean verif = true;
		for (Carte c : c1) {
			if (Collections.frequency(c1, c) != Collections.frequency(c2, c) && verif) {
				verif = false;
			}
		}
		return verif;
	}

	public static List<Carte> rassembler(List<Carte> c) {
		LinkedList<Carte> cartes = new LinkedList<>();
		for(int i = 0; i < c.size(); i++) {
			if(!cartes.contains(c.get(i))){
				cartes.add(c.get(i));
				for(int j = i; j < c.size(); j++) {
					if(c.get(j).equals(c.get(i))) {
						cartes.add(c.get(j));
					}
				}
			}
		}
		
		return cartes;
	}

	public static boolean verifierRassemblement(List<Carte> c) throws Exception {
		ListIterator<Carte> c1 = c.listIterator();
		ListIterator<Carte> c2 = c.listIterator();
		boolean verrification = true;
		Carte carteAVerrifier = c1.next();
		Carte carteSuivanteC1 = null;
		Carte carteSuivanteC2 = null;
		int i = 0;
		while(verrification && c1.hasNext()) {
			carteSuivanteC1 = c1.next();
			if(!carteSuivanteC1.equals(carteAVerrifier)) {
				i = c1.nextIndex();
				while( i != c2.nextIndex()) {
					c2.next();
				}
				while(verrification && c2.hasNext()) {
					carteSuivanteC2 = c2.next();
					if(carteSuivanteC2.equals(carteAVerrifier)) {
						verrification = false;
					}
				}
				c2 = c.listIterator();
				carteAVerrifier = carteSuivanteC1;
			}
			
		}
		return verrification;
	}
	
}
