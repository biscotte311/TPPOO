package cartes;

public class Probleme extends Carte {

	private Type type;

	public Probleme(Type type) {
		this.setType(type);
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}