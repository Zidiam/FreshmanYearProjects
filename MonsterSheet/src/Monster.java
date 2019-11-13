import java.util.ArrayList;

import javax.swing.ImageIcon;

/*
 * Monsters.java --The main class of Monster, which every monster has these characteristics
 * Jason Melnik
 * 1/29/2019
 */
public abstract class Monster {
	private static Hive[] hiveTypes = {new HiveCreature("Thrall")};
	private static Fallen[] fallenTypes = {new FallenCreature("Dreg")};
	private static Cabal[] cabalTypes = {new CabalCreature("Psion")};
	private static Vex[] vexTypes = {new VexCreature("Goblin")};
	
	private static String[] allSpecies = {"Hive", "Fallen", "Cabal", "Vex"};
	
	public abstract String homeWorld();
	public abstract String goals();
	public abstract String atWarWith();
	public abstract String lifeSpan();
	public abstract String locationsFoundIn();
	public abstract String commonColors();
	public abstract String leaderOfSpecies();
	public abstract ImageIcon speciesImage();
	
	private String species, type;
	
	public Monster() {
		//do nothing
	}
	
	public Monster(String species, String type) {
		this.species = species;
		this.type = type;
	}
	
	public Hive[] getHiveTypes(){
		return hiveTypes;
	}
	
	public Fallen[] getFallenTypes(){
		return fallenTypes;
	}
	
	public Cabal[] getCabalTypes(){
		return cabalTypes;
	}
	
	public Vex[] getVexTypes(){
		return vexTypes;
	}
	
	public String[] getAllSpecies() {
		return  allSpecies;
	}
	
	public String toString() {
		return "Species: " + species + " Type: " + type;
	}
	
	public static void instantiate() {
		//do things every time this is called
	}
	
	public static void main(String[] args) {
		Monster thrall = new HiveCreature("Thrall");
		Monster dreg = new FallenCreature("Dreg");
		Monster psion = new CabalCreature("Psion");
		Monster goblin = new VexCreature("Goblin");
		
		Hive[] hiveTypes = thrall.getHiveTypes();
		Fallen[] fallenTypes = dreg.getFallenTypes();
		Cabal[] cabalTypes = psion.getCabalTypes();
		Vex[] vexTypes = goblin.getVexTypes();
		
		for(int i = 0; i < hiveTypes.length; i++) {
			System.out.println(hiveTypes[i]);
		}
		
		for(int i = 0; i < fallenTypes.length; i++) {
			System.out.println(fallenTypes[i]);
		}
		
		for(int i = 0; i < cabalTypes.length; i++) {
			System.out.println(cabalTypes[i]);
		}
		
		for(int i = 0; i < vexTypes.length; i++) {
			System.out.println(vexTypes[i]);
		}
		
	}
}
