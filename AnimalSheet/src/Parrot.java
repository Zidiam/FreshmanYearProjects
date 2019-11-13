public class Parrot extends Animal{
	
	private int age; 
	private String color, name, details;
	
	private static final String SPECIES = "Parrot";
	
	Parrot(int age, String color, String name, String details){
		super(SPECIES);
		this.age = age;
		this.color = color;
		this.name = name;
		this.details = details;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getColor() {
		return color;
	}
	public String getName() {
		return name;
	}

	public String getDetails() {
		return details;
	}
	
	public String toString() {
		return "Name: " + name + " Age: " + age + " Color: " + color + " Details: " + details;
	}
	
	public static void main(String[] args) {
		Parrot Parrot1 = new Parrot(2, "Green", "Polly", "Small");
		System.out.print(Parrot1);
	}
	
	
}