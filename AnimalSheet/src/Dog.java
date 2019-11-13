public class Dog extends Animal{
	
	private int age; 
	private String color, name, details;
	
	private static final String SPECIES = "Dog";
	
	Dog(int age, String color, String name, String details){
		super(SPECIES);
		this.age = age;
		this.color = color;
		this.name = name;
		this.details = details;
	}
	
	Dog(){
		super(SPECIES);
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
		Dog dog1 = new Dog(5, "Black", "Bob", "Fat");
		System.out.print(dog1);
	}
	
	
}