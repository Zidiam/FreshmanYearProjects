/*
 * Hive.java -- The main Species called Hive that all have certain things that only relate to this species
 * Jason Melnik
 * 2/09/2019
 */
import javax.swing.ImageIcon;

public abstract class Hive extends Monster {
	public static enum allTypes{Thrall, CursedThrall, Acolyte, Knight, Wizard, Ogre, Schrieker};
	
	public abstract String noise();
	public abstract String weight();
	public abstract String speed();
	public abstract String skills();
	public abstract String weapon();
	public abstract ImageIcon bodyImage();
	
	private String type;
	private String locations, commonColors, leader, home, goals, war, lifespan;
	public Hive(String type) {
		super("Hive", type);
		this.type = type;
		locations = "Moon";
		commonColors = "Gray and yellow";
		leader = "Croton";
		home = "the abyss";
		goals = "Corrupt all land";
		war = "Everyone";
		lifespan = "100 years";
	}
	
	public String getType() {
		return type;
	}
	
	public String toString() {
		return "Species: Hive Type: " + type;
	}
	
	public String locationsFoundIn() {
		return locations;
	}
	
	public String commonColors() {
		return commonColors;
	}
	
	public String leaderOfSpecies() {
		return leader;
	}
	
	public String homeWorld() {
		return home;
	}
	
	public String goals() {
		return goals;
	}
	
	public String atWarWith() {
		return war;
	}
	
	public String lifeSpan() {
		return lifespan;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public void setLocations(String locations) {
		this.locations = locations;
	}
	public void setCommonColors(String commonColors) {
		this.commonColors = commonColors;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	public void setWar(String war) {
		this.war = war;
	}
	public void setLifespan(String lifespan) {
		this.lifespan = lifespan;
	}
	public ImageIcon speciesImage() {
		return new ImageIcon();
	}
}
