package jeu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	private Sabot sabot;
	
	public Jeu() {
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		LinkedList<Carte> cartes = new LinkedList<>(Arrays.asList(jeuDeCartes.donneCarte()));
		LinkedList<Carte> melanger =  GestionCartes.melanger(cartes);
		Carte[] c = new Carte[melanger.size()];
		for(int i = 0; i < melanger.size(); i++) {
			c[i] = melanger.get(i);
		}
		this.sabot = new Sabot(c);
	}
	
	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		
	}

}
