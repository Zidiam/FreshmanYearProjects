import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Enemy{
	private static String[] names = {"Bot", "Hacker", "Glitch", "Bug", "Error"};
	private int hit, health;
	private String name;
	private static Random rand = new Random();
	
	
	public Enemy(int hitStrength, int selfHealth) {
		if (hitStrength >= 200) {
			hit = rand.nextInt(hitStrength - 100) + 100;
		}
		else {
			hit = hitStrength;
		}
		health = selfHealth;
		name = names[rand.nextInt(names.length)];
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getStrength() {
		return hit;
	}
	
	public String getName() {
		return name;
	}
	
	public void damage(int gothit) {
		health -= gothit;
	}
	
	public boolean isDead() {
		return health <= 0;
	}
	
}

public class GinzaEscapePanel extends JPanel{
	
	private final int WIDTH = 690, HEIGHT = 500;
	private int speed = 75;
	private Timer timer;
	private JButton leftB, rightB, upB, downB, fightB, runB, lootB, shopB, actualInventoryB, lootBoxB, secretB;
	private JLabel coinsP, healthP, statsP, helmetProtP, chestProtP, pantsProtP, shoesProtP, strengthP, fightText, enemyStats, enemyHealth, 
				   enemyStrength, updateStatus, dungeonL;
	private int coins, health, helmetProt, chestProt, pantsProt, shoesProt, spotx, spoty, strength, dungeon, lootBox, lootBoxA;
	private String[][] dungeonMap;
	private ArrayList<Point> walls, treasure, end, fight;
	private Point beforeStep;
	private boolean fightScene, setupFight, gameOver, inventory, inventoryScene, shopScene, ending;
	private Enemy enemy;
	private static Random rand = new Random();
	private String lootRewards;
	
	//If I want to make a bigger game:
	//private JButton inventoryB;
	
	public GinzaEscapePanel() {
		ending = false;
		gameOver = false;
		fightScene = false;
		setupFight = false;
		inventory = false;
		inventoryScene = false;
		shopScene = false;
		coins = 0;
		health = 100;
		helmetProt = 10;
		chestProt = 10;
		pantsProt = 10;
		shoesProt = 10;
		strength = 10;
		dungeon = 1;
		lootBox = 10;
		lootRewards = "";
		
		setBackground(Color.WHITE);
		
		addKeyListener(new DirectionListener());
		timer = new Timer(speed, new ReboundListener());
		
		leftB = new JButton("W");
		rightB = new JButton("E");
		upB = new JButton("N");
		downB = new JButton("S");
		//inventoryB = new JButton("I");
		lootB = new JButton("Loot Box");
		actualInventoryB = new JButton("Inventory");
		shopB = new JButton("Shop");
		secretB = new JButton("test");
		
		leftB.setBackground(Color.WHITE);
		rightB.setBackground(Color.WHITE);
		upB.setBackground(Color.WHITE);
		downB.setBackground(Color.WHITE);
		//inventoryB.setBackground(Color.white);
		lootB.setBackground(Color.white);
		actualInventoryB.setBackground(Color.white);
		shopB.setBackground(Color.white);
		secretB.setBackground(Color.white);
		
		updateStatus = new JLabel();
		statsP = new JLabel("Stats:");
		coinsP = new JLabel("Coins: " + coins);
		healthP = new JLabel("Health: " + health);
		strengthP = new JLabel("Strength: " + strength);
		helmetProtP = new JLabel("Helmet: " + helmetProt);
		chestProtP = new JLabel("ChestPlate: " + chestProt);
		pantsProtP = new JLabel("Pants: " + pantsProt);
		shoesProtP = new JLabel("Shoes: " + shoesProt);
		dungeonL = new JLabel("Dungeon: " + dungeon);
		
		upB.setBounds(75, 350, 50, 50);
		rightB.setBounds(125, 400, 50, 50);
		downB.setBounds(75, 450, 50, 50);
		leftB.setBounds(25, 400, 50, 50);
		//inventoryB.setBounds(75, 400, 50, 50);
		updateStatus.setBounds(200, 375, 1000, 25);
		statsP.setBounds(0, 0, 200, 25);
		coinsP.setBounds(0, 25, 200, 25);
		healthP.setBounds(0, 50, 200, 25);
		strengthP.setBounds(0, 75, 200, 25);
		helmetProtP.setBounds(0, 100, 200, 25);
		chestProtP.setBounds(0, 125, 200, 25);
		pantsProtP.setBounds(0, 150, 200, 25);
		shoesProtP.setBounds(0, 175, 200, 25);
		lootB.setBounds(25, 250, 150, 25);
		actualInventoryB.setBounds(200, 0, 100, 25);
		shopB.setBounds(300, 0, 100, 25);
		dungeonL.setBounds(0, 200, 200, 25);
		secretB.setBounds(698, 508, 100, 100);
		secretB.setOpaque(false);
		secretB.setContentAreaFilled(false);
		secretB.setBorderPainted(false);
		
		leftB.addActionListener(new ButtonListener());
		rightB.addActionListener(new ButtonListener());
		upB.addActionListener(new ButtonListener());
		downB.addActionListener(new ButtonListener());
		//inventoryB.addActionListener(new ButtonListener());
		lootB.addActionListener(new ButtonListener());
		actualInventoryB.addActionListener(new ButtonListener());
		shopB.addActionListener(new ButtonListener());
		secretB.addActionListener(new ButtonListener());
		
		lootB.setVisible(true);//false for full game
		actualInventoryB.setVisible(false);
		shopB.setVisible(false);
		
		add(lootB);
		
		setLayout(null);
		
		add(secretB);
		add(dungeonL);
		add(leftB);
		add(rightB);
		add(upB);
		add(downB);
		//add(inventoryB);
		add(actualInventoryB);
		add(shopB);
		
		add(updateStatus);
		add(statsP);
		add(coinsP);
		add(healthP);
		add(strengthP);
		add(helmetProtP);
		add(chestProtP);
		add(pantsProtP);
		add(shoesProtP);
		
		getDungeonMap("src\\Dungeons\\Dungeon" + dungeon + ".txt");
		walls();
		treasure();
		end();
		fight();
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		timer.start();
		
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == secretB) {
				updateStatus.setText("HOW DARE YOU FIND MY SECRET STASH!         01000110 01101001 01101110 01100100");
				coins += 1000000;
				statsUpdate();
			}
			if (fightScene == false){
				beforeStep = new Point(spotx, spoty);
				if(event.getSource() == leftB && spotx*25 + 200 - 25>= 200) {
					boolean temp = false;
					for(int x = 0; x < walls.size(); x++) {
						if(walls.get(x).x == spotx-1 && walls.get(x).y == spoty) {
							temp = true;
						}
					}
					if (temp == false) {
						spotx -= 1;
					}
				}
				if(event.getSource() == rightB && spotx*25 + 200 + 25 <= 690) {
					boolean temp = false;
					for(int x = 0; x < walls.size(); x++) {
						if(walls.get(x).x == spotx+1 && walls.get(x).y == spoty) {
							temp = true;
						}
					}
					if (temp == false) {
						spotx += 1;
					}
				}
				if(event.getSource() == upB && spoty*25 - 25 >= 0 ) {
					boolean temp = false;
					for(int x = 0; x < walls.size(); x++) {
						if(walls.get(x).x == spotx && walls.get(x).y == spoty-1) {
							temp = true;
						}
					}
					if (temp == false) {
						spoty -= 1;
					}
				}
				if(event.getSource() == downB && spoty*25 + 25 <= 350 ) {
					boolean temp = false;
					for(int x = 0; x < walls.size(); x++) {
						if(walls.get(x).x == spotx && walls.get(x).y == spoty + 1) {
							temp = true;
						}
					}
					if (temp == false) {
						spoty += 1;
					}
				}
				
				for(int x = 0; x < treasure.size(); x++) {
					if(treasure.get(x).x == spotx && treasure.get(x).y == spoty) {
						gotTreasure();
						treasure.remove(new Point(spotx, spoty));
					}
				}
				
				for(int x = 0; x < fight.size(); x++) {
					if(fight.get(x).x == spotx && fight.get(x).y == spoty) {
						fightScene = true;
					}
				}
				
				for(int x = 0; x < end.size(); x++) {
					if(end.get(x).x == spotx && end.get(x).y == spoty) {
						dungeon += 1;
						if(dungeon >= 10) {
							ending = true;
						}
						else {
							getDungeonMap("src\\Dungeons\\Dungeon" + dungeon + ".txt");
							walls();
							treasure();
							end();
							fight();
						}
					}
				}
				
				//ALL SHOP LOGISTICS
//				if(event.getSource() == inventoryB) {
//					inventory = !inventory;
//					inventoryScene = true;
//					actualInventoryB.setVisible(inventory);
//					shopB.setVisible(inventory);
//					lootB.setVisible(inventory);
//				}
				if(event.getSource() == lootB) {
					if(lootBox <= coins) {
						coins -= lootBox;
						lootBox += lootBox/2.5;
						gotTreasure();
					}
				}
				if(event.getSource() == actualInventoryB) {
					inventoryScene = true;
					shopScene = false;
				}
				if(event.getSource() == shopB) {
					shopScene = true;
					inventoryScene = false;
				}
				
				repaint();
			}
			else {
				if(event.getSource() == fightB) {
					int damg = enemy.getStrength();
					while(enemy.isDead() == false && health >= 0) {
						if(helmetProt > 0 && damg > 0) {
							damg -= helmetProt;
							helmetProt = 0;
						}
						if(chestProt > 0 && damg > 0) {
							damg -= chestProt;
							chestProt = 0;
						}
						if(pantsProt > 0 && damg > 0) {
							damg -= pantsProt;
							pantsProt = 0;
						}
						if(shoesProt > 0 && damg > 0) {
							damg -= shoesProt;
							shoesProt = 0;
						}
						if(damg > 0) {
							health -= damg;
						}
						enemy.damage(strength);
						statsUpdate();
						repaint();
					}
					if(health <= 0) {
						gameOver = true;
					}
					else {
						updateStatus.setText("Enemy damaged you with " + enemy.getStrength()+ " hitpoints and you didn't die congrates!");
						fight.remove(new Point(spotx, spoty));
						coins += dungeon*15;
						fightScene = false;
						setupFight = false;
						remove(fightText);
						remove(enemyStats);
						remove(enemyHealth);
						remove(enemyHealth);
						remove(enemyStrength);
						remove(runB);
						remove(fightB);
						repaint();
					}
					
				}
				if(event.getSource() == runB) {
					spotx = beforeStep.x;
					spoty =  beforeStep.y;
					fightScene = false;
					setupFight = false;
					remove(fightText);
					remove(enemyStats);
					remove(enemyHealth);
					remove(enemyHealth);
					remove(enemyStrength);
					remove(runB);
					remove(fightB);
					repaint();
				}
			}
		}
	}
	
	public void gotTreasure() {
		int randm;
		String txt = "You found treasure: ";
		lootRewards = "Rewards: ";
		for(int x = 0; x < dungeon; x++) {
			randm = rand.nextInt(700);
			if(randm >= 0 && randm <= 100) {
				coins += dungeon*15;
				txt += " " + dungeon*15 + " coins, ";
				lootRewards += " " + dungeon*15 + " coins, ";
			}
			if(randm >= 101 && randm <= 200) {
				strength += dungeon*15;
				txt += " " + dungeon*15 + " strength, ";
				lootRewards += " " + dungeon*15 + " strength, ";
			}
			if(randm >= 201 && randm <= 300) {
				helmetProt += dungeon*15;
				txt += " " + dungeon*15 + " helmet, ";
				lootRewards += " " + dungeon*15 + " helmet, ";
			}
			if(randm >= 301 && randm <= 400) {
				chestProt += dungeon*15;
				txt += " " + dungeon*15 + " chest, ";
				lootRewards += " " + dungeon*15 + " chest, ";
			}
			if(randm >= 401 && randm <= 500) {
				pantsProt += dungeon*15;
				txt += " " + dungeon*15 + " pants, ";
				lootRewards += " " + dungeon*15 + " pants, ";
			}
			if(randm >= 501 && randm <= 600) {
				shoesProt += dungeon*15;
				txt += " " + dungeon*15 + " shoes, ";
				lootRewards += " " + dungeon*15 + " shoes, ";
			}
			if(randm >= 601 && randm <= 700) {
				health = 100;
				txt += " full health, ";
				lootRewards += " full health, ";
			}
			
			updateStatus.setText(txt);
			coinsP.setText("Coins: " + coins);
			healthP.setText("Health: " + health);
			strengthP.setText("Strength: " + strength);
			helmetProtP.setText("Helmet: " + helmetProt);
			chestProtP.setText("ChestPlate: " + chestProt);
			pantsProtP.setText("Pants: " + pantsProt);
			shoesProtP.setText("Shoes: " + shoesProt);
		}
	}
	
	public void statsUpdate() {
		coinsP.setText("Coins: " + coins);
		healthP.setText("Health: " + health);
		strengthP.setText("Strength: " + strength);
		helmetProtP.setText("Helmet: " + helmetProt);
		chestProtP.setText("ChestPlate: " + chestProt);
		pantsProtP.setText("Pants: " + pantsProt);
		shoesProtP.setText("Shoes: " + shoesProt);
	}
	
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		makeDungeon(page);
		
		page.setColor(Color.BLACK);
		page.drawLine(200, 0, 200, 500);
		page.drawLine(200, 375, 700, 375);
		
		page.drawOval(200 + spotx * 25, spoty * 25, 25, 25);
		
		page.drawString("Cost: " + lootBox, 25, 249);//remove for full game
		
		if(inventory == true) {
			shop(page);
		}
		if(ending == true) {
			theEnd(page);
		}
		
	}
	
	public void theEnd(Graphics page) {
		removeAll();
		page.setColor(Color.BLACK);
		page.fillRect(0, 0, 1000, 1000);
		page.setColor(Color.white);
		page.drawString("Well you have defeated me...", 25, 25);
		page.drawString("I guess the human race is better than AI", 25, 50);
		page.drawString("I guess I must release you from this trap", 25, 75);
		page.drawString("Have a great life and dont come back or else I will trap you in this game again!", 25, 100);
		page.drawString("-Created by Jason Melnik", 25, 125);
		
	}
	
	public void shop(Graphics page) {
		if (inventoryScene == true) {
			inventoryScene(page);
			System.out.println("test");
		}
		if (shopScene == true) {
			shopScene(page);
		}
	}
	
	public void inventoryScene(Graphics page){
		page.setColor(Color.WHITE);
		page.fillRect(0, 0, 800, 800);
		lootB.setVisible(false);
	}
	
	public void shopScene(Graphics page){
		page.setColor(Color.WHITE);
		page.fillRect(0, 0, 800, 800);
		page.setColor(Color.BLACK);
		page.drawString("Cost: " + lootBox, 350, 145);
		page.drawString(lootRewards, 350, 300);
		lootB.setVisible(true);
	}
	
	private class DirectionListener implements KeyListener{
		public void keyPressed(KeyEvent event) {
			if(event.getKeyCode() == KeyEvent.VK_A) {}
		}
		public void keyTyped(KeyEvent event) {}
		public void keyReleased(KeyEvent event) {}
	}
	
	private void fightScene(Point prev) {
		updateStatus.setText("");
		if(setupFight == false) {
			enemy = new Enemy(dungeon*25, dungeon*25);
			fightText = new JLabel("You have encountered a " + enemy.getName());
			enemyStats = new JLabel("Stats: ");
			enemyHealth = new JLabel("Health: " + enemy.getHealth());
			enemyStrength = new JLabel("Strength: " + enemy.getStrength());
			runB = new JButton("Run");
			fightB = new JButton("Fight");
			
			fightText.setBounds(200, 375, 1000, 25);
			enemyStats.setBounds(200, 400, 1000, 25);
			enemyHealth.setBounds(200, 425, 1000, 25);
			enemyStrength.setBounds(200, 450, 1000, 25);
			runB.setBounds(200, 475, 75, 25);
			fightB.setBounds(275, 475, 75, 25);
			runB.setBackground(Color.WHITE);
			fightB.setBackground(Color.WHITE);
			
			runB.addActionListener(new ButtonListener());
			fightB.addActionListener(new ButtonListener());
			
			add(fightText);
			add(enemyStats);
			add(enemyHealth);
			add(enemyStrength);
			add(runB);
			add(fightB);
			
			repaint();
			
			setupFight = true;
		}
			

	}
	
	private class ReboundListener implements ActionListener
	{
		//--------------------------------------------------------------
		//  Updates the position of the image and possibly the direction
		//  of movement whenever the timer fires an action event.
		//--------------------------------------------------------------
		public void actionPerformed(ActionEvent event)
		{
			if(fightScene == true) {
				fightScene(beforeStep);
			}
			if(gameOver == true) {
				reset();
			}
			repaint();
		}
	}
	
	private void makeDungeon(Graphics page) {
		page.setColor(Color.BLACK);
		int xbuffer = 200;
		int ybuffer = 0;
		
		for(int z = 0; z < walls.size(); z++) {
			page.fillRect(xbuffer + walls.get(z).x*25, ybuffer + walls.get(z).y*25, 25, 25);
		}
		
	}
	
	private void getDungeonMap(String fileName) {
		File file = new File(fileName); 
		Scanner sc;
		try {
			sc = new Scanner(file);
			int col = Integer.parseInt(sc.next());
			int row = Integer.parseInt(sc.next());
			spotx = Integer.parseInt(sc.next());
			spoty = Integer.parseInt(sc.next());

			dungeonMap = new String[row][col];
			dungeonMap[0][0] = "test";
			
			boolean temp = false;
			for(int x = 0; x < row; x++) {
				for(int y = 0; y < col; y++) {
					dungeonMap[x][y] = sc.next();
				}
			}
			
			String txter = "";
			while(sc.hasNext()) {
				txter += sc.next() + " ";
			}
			updateStatus.setText(txter);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private void walls(){
		ArrayList<Point> temp = new ArrayList<Point>();
		
		for(int x = 0; x < dungeonMap.length; x++) {
			for(int y = 0; y < dungeonMap[x].length; y++) {
				try {
					if(Integer.parseInt(dungeonMap[x][y]) == 1) {
						temp.add(new Point(y, x));
					}
				}
				catch(Exception e) {}
			}
		}
		
		walls = new ArrayList<Point>();
		for(int x = 0; x < temp.size(); x++) {
			walls.add(temp.get(x));
		}
		
	}
	
	private void treasure(){
		ArrayList<Point> temp = new ArrayList<Point>();
		
		for(int x = 0; x < dungeonMap.length; x++) {
			for(int y = 0; y < dungeonMap[x].length; y++) {
				if(dungeonMap[x][y].equals("T")) {
					temp.add(new Point(y, x));
				}
			}
		}
		
		treasure = new ArrayList<Point>();
		for(int x = 0; x < temp.size(); x++) {
			treasure.add(temp.get(x));
		}
	}
	
	private void end(){
		ArrayList<Point> temp = new ArrayList<Point>();
		
		for(int x = 0; x < dungeonMap.length; x++) {
			for(int y = 0; y < dungeonMap[x].length; y++) {
				if(dungeonMap[x][y].equals("E")) {
					temp.add(new Point(y, x));
				}
			}
		}
		
		end = new ArrayList<Point>();
		for(int x = 0; x < temp.size(); x++) {
			end.add(temp.get(x));
		}
	}
	
	private void fight(){
		ArrayList<Point> temp = new ArrayList<Point>();
		
		for(int x = 0; x < dungeonMap.length; x++) {
			for(int y = 0; y < dungeonMap[x].length; y++) {
				if(dungeonMap[x][y].equals("F")) {
					temp.add(new Point(y, x));
				}
			}
		}
		
		fight = new ArrayList<Point>();
		for(int x = 0; x < temp.size(); x++) {
			fight.add(temp.get(x));
		}
	}
	
	private void reset() {
		removeAll();
		gameOver = false;
		fightScene = false;
		setupFight = false;
		inventory = false;
		inventoryScene = false;
		shopScene = false;
		coins = 0;
		health = 100;
		helmetProt = 10;
		chestProt = 10;
		pantsProt = 10;
		shoesProt = 10;
		strength = 10;
		dungeon = 1;
		lootBox = 10;
		lootRewards = "";
		
		setBackground(Color.WHITE);
		
		addKeyListener(new DirectionListener());
		timer = new Timer(speed, new ReboundListener());
		
		leftB = new JButton("W");
		rightB = new JButton("E");
		upB = new JButton("N");
		downB = new JButton("S");
		//inventoryB = new JButton("I");
		lootB = new JButton("Loot Box");
		actualInventoryB = new JButton("Inventory");
		shopB = new JButton("Shop");
		
		leftB.setBackground(Color.WHITE);
		rightB.setBackground(Color.WHITE);
		upB.setBackground(Color.WHITE);
		downB.setBackground(Color.WHITE);
		//inventoryB.setBackground(Color.white);
		lootB.setBackground(Color.white);
		actualInventoryB.setBackground(Color.white);
		shopB.setBackground(Color.white);
		
		updateStatus = new JLabel();
		statsP = new JLabel("Stats:");
		coinsP = new JLabel("Coins: " + coins);
		healthP = new JLabel("Health: " + health);
		strengthP = new JLabel("Strength: " + strength);
		helmetProtP = new JLabel("Helmet: " + helmetProt);
		chestProtP = new JLabel("ChestPlate: " + chestProt);
		pantsProtP = new JLabel("Pants: " + pantsProt);
		shoesProtP = new JLabel("Shoes: " + shoesProt);
		dungeonL = new JLabel("Dungeon: " + dungeon);
		
		upB.setBounds(75, 350, 50, 50);
		rightB.setBounds(125, 400, 50, 50);
		downB.setBounds(75, 450, 50, 50);
		leftB.setBounds(25, 400, 50, 50);
		//inventoryB.setBounds(75, 400, 50, 50);
		updateStatus.setBounds(200, 375, 1000, 25);
		statsP.setBounds(0, 0, 200, 25);
		coinsP.setBounds(0, 25, 200, 25);
		healthP.setBounds(0, 50, 200, 25);
		strengthP.setBounds(0, 75, 200, 25);
		helmetProtP.setBounds(0, 100, 200, 25);
		chestProtP.setBounds(0, 125, 200, 25);
		pantsProtP.setBounds(0, 150, 200, 25);
		shoesProtP.setBounds(0, 175, 200, 25);
		lootB.setBounds(25, 250, 150, 25);
		actualInventoryB.setBounds(200, 0, 100, 25);
		shopB.setBounds(300, 0, 100, 25);
		dungeonL.setBounds(0, 200, 200, 25);
		
		leftB.addActionListener(new ButtonListener());
		rightB.addActionListener(new ButtonListener());
		upB.addActionListener(new ButtonListener());
		downB.addActionListener(new ButtonListener());
		//inventoryB.addActionListener(new ButtonListener());
		lootB.addActionListener(new ButtonListener());
		actualInventoryB.addActionListener(new ButtonListener());
		shopB.addActionListener(new ButtonListener());
		
		lootB.setVisible(true);//false for full game
		actualInventoryB.setVisible(false);
		shopB.setVisible(false);
		
		add(lootB);
		
		setLayout(null);
		
		add(dungeonL);
		add(leftB);
		add(rightB);
		add(upB);
		add(downB);
		//add(inventoryB);
		add(actualInventoryB);
		add(shopB);
		
		add(updateStatus);
		add(statsP);
		add(coinsP);
		add(healthP);
		add(strengthP);
		add(helmetProtP);
		add(chestProtP);
		add(pantsProtP);
		add(shoesProtP);
		
		getDungeonMap("src\\Dungeons\\Dungeon" + dungeon + ".txt");
		updateStatus.setText("GAME OVER!");
		walls();
		treasure();
		end();
		fight();
	}
	
}
	
	

