public class Cat extends Animal{
	
	private int age; 
	private String color, name, details;
	
	private static final String SPECIES = "Cat";
	
	Cat(int age, String color, String name, String details){
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
		Cat cat1 = new Cat(4, "Orange", "Toby", "Has 3 legs");
		System.out.print(cat1);
	}
	
	
}