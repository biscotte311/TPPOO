package cartes;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JeuDeCartes {
    
    private Configuration[] typesDeCartes;

    public JeuDeCartes() {
        this.typesDeCartes = new Configuration[17];
        
        
        // Ajout des bornes
        typesDeCartes[0] = new Configuration(new Borne(25), 10);
        typesDeCartes[1] = new Configuration(new Borne(50), 10);
        typesDeCartes[2] = new Configuration(new Borne(75), 10);
        typesDeCartes[3] = new Configuration(new Borne(100), 12);
        typesDeCartes[4] = new Configuration(new Borne(200), 4);

        // Ajout des parades
        typesDeCartes[5] = new Configuration(new Parade(Type.FEU), 14); // Feu Vert
        typesDeCartes[6] = new Configuration(new Parade(Type.ESSENCE), 6); // Bidon d'essence
        typesDeCartes[7] = new Configuration(new Parade(Type.CREVAISON), 6); // Roue de secours
        typesDeCartes[8] = new Configuration(new Parade(Type.ACCIDENT), 6); // Réparations

        // Ajout des attaques
        typesDeCartes[9] = new Configuration(new Attaque(Type.FEU), 5); // Feu Rouge
        typesDeCartes[10] = new Configuration(new Attaque(Type.ESSENCE), 3); // Panne d'essence
        typesDeCartes[11] = new Configuration(new Attaque(Type.CREVAISON), 3); // Crevaison
        typesDeCartes[12] = new Configuration(new Attaque(Type.ACCIDENT), 3); // Accident

        // Ajout des bottes
        typesDeCartes[13] = new Configuration(new Botte(Type.FEU), 1); // Prioritaire
        typesDeCartes[14] = new Configuration(new Botte(Type.ESSENCE), 1); // Citerne
        typesDeCartes[15] = new Configuration(new Botte(Type.CREVAISON), 1); // Increvable
        typesDeCartes[16] = new Configuration(new Botte(Type.ACCIDENT), 1); // As du volant
    }
    
    public Carte[] donneCarte() {
    	Carte[] cartes = new Carte[96];
    	int cpt = 0;
    	for(Configuration c : this.typesDeCartes) {
    		for(int i = 0; i < c.getNbExemplaires(); i++) {
    			cartes[cpt] = c.getCarte();
    			cpt ++;
    		}
    	}
    	return cartes;
    }

    // Retourne un tableau de Configuration
    public Configuration[] getTypesDeCartes() {
        return typesDeCartes;
    }

    // Modifie le tableau de Configuration
    public void setTypesDeCartes(Configuration[] typesDeCartes) {
        this.typesDeCartes = typesDeCartes;
    }

    // Affiche toutes les cartes du jeu
    public String affichageJeuDeCartes() {
    	String s = "";
    	for (Configuration c : this.typesDeCartes) {
    		s+= c.getNbExemplaires() + " " + c.getCarte().toString() + "\n";
    		
    	}
        return s;
    }

    
    public boolean checkCount(Carte cartes[]) throws Exception {
    	int cB = 0;
    	int cA = 0;
    	int cP = 0;
    	int cBo = 0;
        for(Carte c : cartes) {
        	if(c instanceof Borne) {
        		cBo ++;
        	}else if(c instanceof Attaque) {
        		cA ++;
        	}else if(c instanceof Botte) {
        		cB ++;
        	}else if(c instanceof Parade) {
        		cP ++;
        	}else {
        		throw new Exception("Erreur de type de carte");
        	}
        }
		return cBo == 46 && cA == 14 && cB == 4 && cP == 32;
    }
}
