package cartes;

import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JeuDeCartes {
	
	private ArrayList<Configuration> typesDeCartes;

	public JeuDeCartes() {
		this.typesDeCartes = new ArrayList<>();
		
		// Ajout des bornes
		typesDeCartes.add(new Configuration(new Borne(25), 10));
        typesDeCartes.add(new Configuration(new Borne(50), 10));
        typesDeCartes.add(new Configuration(new Borne(75), 10));
        typesDeCartes.add(new Configuration(new Borne(100), 12));
        typesDeCartes.add(new Configuration(new Borne(200), 4));

        // Ajout des parades
        typesDeCartes.add(new Configuration(new Parade(Type.FEU), 14)); // Feu Vert
        typesDeCartes.add(new Configuration(new Parade(Type.ESSENCE), 6)); // Bidon d'essence
        typesDeCartes.add(new Configuration(new Parade(Type.CREVAISON), 6)); // Roue de secours
        typesDeCartes.add(new Configuration(new Parade(Type.ACCIDENT), 6)); // Réparations

        // Ajout des attaques
        typesDeCartes.add(new Configuration(new Attaque(Type.FEU), 5)); // Feu Rouge
        typesDeCartes.add(new Configuration(new Attaque(Type.ESSENCE), 3)); // Panne d'essence
        typesDeCartes.add(new Configuration(new Attaque(Type.CREVAISON), 3)); // Crevaison
        typesDeCartes.add(new Configuration(new Attaque(Type.ACCIDENT), 3)); // Accident
        typesDeCartes.add(new Configuration(new Attaque(Type.FEU), 4)); // Limite 50

        // Ajout des bottes
        typesDeCartes.add(new Configuration(new Botte(Type.FEU), 1)); // Prioritaire
        typesDeCartes.add(new Configuration(new Botte(Type.ESSENCE), 1)); // Citerne
        typesDeCartes.add(new Configuration(new Botte(Type.CREVAISON), 1)); // Increvable
        typesDeCartes.add(new Configuration(new Botte(Type.ACCIDENT), 1)); // As du volant
		
	}

	public ArrayList<Configuration> getTypesDeCartes() {
		return typesDeCartes;
	}

	public void setTypesDeCartes(ArrayList<Configuration> typesDeCartes) {
		this.typesDeCartes = typesDeCartes;
	}
	
	public String affichageJeuDeCartes() {
		return this.typesDeCartes.stream()
				.map(c -> c.getNbExemplaires() 
				+" "+ c.getCarte().toString())
				.collect(Collectors.joining("\n"));
	}

}
