
public abstract class Animal {
	public abstract String getColor();
	public abstract String getName();
	public abstract int getAge();
	
	String species;
	
	public Animal(String species) {
		this.species = species;
	}
	
	public String getSpecies() {
		return species;
	}
}
