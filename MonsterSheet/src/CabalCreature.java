/*
 * CabalCreature.java -- Represents a Cabal creature with the same characteristics as a Cabal species!
 * You can get and set different types of characteristics of a Cabal creature including type.
 * Jason Melnik
 * 2/09/2019
 */
import javax.swing.ImageIcon;

public class CabalCreature extends Cabal{
	private static String type;
	private String noise, weight, speed, skills, weapon, url;
	
	public CabalCreature(String type) {
		super(type);
		this.type = type;
		noise = "";
		weight = "";
		speed = "";
		skills = "";
		weapon = "";
		url = "";
	}
	
	public String toString() {
		return 	"Species: Cabal Type: " + type +   
				"\nNoise: " + noise() + " Weight: " + weight() + " Speed: " + speed() + " Skills: " + skills() + " Weapon: " + weapon() + 
				"\nSpecies Info: \n" + "locations Found In: " + locationsFoundIn() + " Common Colors: " + commonColors() + 
				"\nLeader of Species: " + leaderOfSpecies() + " Home World: " + homeWorld() + " Goals: " + goals() + 
				"\nAt war with: " + atWarWith() + " Life Span: " + lifeSpan();
	}
	
	public String getType() {
		return type;
	}
	
	public String noise() {
		return noise;
	}
	
	public String weight() {
		return weight;
	}
	
	public String speed() {
		return speed;
	}
	
	public String skills() {
		return skills;
	}
	
	public String weapon() {
		
		return weapon;
	}
	
	public ImageIcon bodyImage() {
		return new ImageIcon(url);
	}
	
	public void setImage(String url) {
		this.url = url;
	}
	
	public String getImage() {
		return url;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setNoise(String noise) {
		this.noise = noise;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	
}
