package joueur;

import java.util.LinkedList;
import java.util.Iterator;
import cartes.Carte;

public class MainJoueur implements Iterable<Carte> {

    private LinkedList<Carte> main; // Liste des cartes dans la main du joueur

    public MainJoueur() {
        this.main = new LinkedList<>();
    }

    public void prendre(Carte carte) {
        main.add(carte);
    }

    public void jouer(Carte carte) {
        assert main.contains(carte) : "La carte doit être présente dans la main pour pouvoir être jouée.";
        main.remove(carte);
    }

    public LinkedList<Carte> getMain() {
        return main;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Main du joueur :\n");
        for (Carte carte : main) {
            sb.append(carte.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Carte> iterator() {
        return main.iterator();
    }
}
