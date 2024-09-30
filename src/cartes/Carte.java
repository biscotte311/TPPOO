package cartes;

public abstract class Carte {
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Carte) {
			o=(Carte) o;
			return o.toString().equals(this.toString());
		}
		return false;
		
	}

}
