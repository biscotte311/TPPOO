package cartes;

public class Attaque extends Bataille {

	public Attaque(Type type) {
		super(type);
	}
	
	@Override
	public String toString() {
		return "Attaque : "+super.getType();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Attaque) {			
			return ((Attaque) o).getType() == this.getType();
		}
		return false;	
	}
	

}
