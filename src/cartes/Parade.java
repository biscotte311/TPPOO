package cartes;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type);
	}
	
	@Override
	public String toString() {
		return "Parade : "+super.getType();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Parade) {			
			return ((Parade) o).getType() == this.getType();
		}
		return false;	
	}

}
