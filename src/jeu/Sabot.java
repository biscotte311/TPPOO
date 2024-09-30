package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {
	
	private Carte[] cartes;
	private int nbCartes;
	
    
	public Sabot(Carte[] cartes) {
		this.cartes = cartes;
		this.nbCartes = this.cartes.length;
	}
	
	public boolean estVide() {
		return this.nbCartes == 0;
	}
	
	public void ajouterCarte(Carte carte) throws Exception {
		if(this.nbCartes == this.cartes.length) {
			throw new Exception("Sabot plein");
		}else {
			this.cartes[this.nbCartes] = carte;
			this.nbCartes ++;			
		}
	}
	
	
	private class Iterateur implements Iterator<Carte>{
		private boolean nextEffectue =  false;
		private int indiceIterateur = 0;
		private int nombreOperations = 0;
		private int nombreOperationsReference = nombreOperations;
		
		@Override
		public boolean hasNext() {
			return this.indiceIterateur < Sabot.this.nbCartes;
		}
	
		@Override
		public Carte next() {
			verificationConcurrence();
			if(hasNext()) {
				this.nextEffectue = true;
	            return Sabot.this.cartes[indiceIterateur++];
			}else {
				throw new IllegalStateException();
			}
			
		}
		
		public void remove() {
			verificationConcurrence();
			 if (!nextEffectue || nbCartes == 0) {
		        throw new IllegalStateException("Impossible de supprimer un élément avant d'appeler next()");
		    }
	
		    for (int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
		    	Sabot.this.cartes[i] = Sabot.this.cartes[i + 1];
		    }
		    Sabot.this.cartes[nbCartes - 1] = null;
		    nbCartes--;	    
		    nextEffectue = false;
		    indiceIterateur--;
			nombreOperations++;
			nombreOperationsReference++;
		}
		
		private void verificationConcurrence(){
			if (nombreOperations != nombreOperationsReference)
				throw new ConcurrentModificationException();
		}
	
	}
	
	public Carte piocher() {
		Iterateur iterateur = new Iterateur(); 
		if (!iterateur.hasNext()) {
			throw new IllegalStateException("Le sabot est vide, impossible de piocher");
		}
		Carte cartePiochee = iterateur.next();
		iterateur.remove();  
		return cartePiochee;
	}

	@Override
	public Iterator<Carte> iterator() {
		// TODO Auto-generated method stub
		return new Iterateur();
	}
	

}
