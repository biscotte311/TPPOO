package cartes;

public class Botte extends Probleme {

	public Botte(Type type) {
		super(type);
	}
	
	@Override
	public String toString() {
		return "Botte : "+super.getType();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Botte) {			
			return ((Botte) o).getType() == this.getType();
		}
		return false;	
	}

}
