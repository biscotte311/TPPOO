package cartes;

public interface Cartes {
    Carte PRIORITAIRE = new Botte(Type.FEU); // Carte de type Botte
    Carte FEU_ROUGE = new Attaque(Type.FEU);   // Carte de type Attaque
    Carte FEU_VERT = new Parade(Type.FEU);      // Carte de type Parade
}
