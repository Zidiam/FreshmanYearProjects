import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.*;

class Customer{
	private String name;
	private int orderNumber;
	private static Random rand = new Random();
	
	Customer(int orderNumber, String name){
		this.orderNumber = orderNumber;
		this.name = name;
	}
	
	Customer(String name){
		this.name = name;
		this.orderNumber = rand.nextInt(10000) + 1000;
	}
	
	Customer(int orderNumber){
		this.orderNumber = orderNumber;
		this.name = "Unknown" + rand.nextInt(10000) + 1000;
	}
	
	Customer(){
		this.orderNumber = rand.nextInt(10000) + 1000;
		this.name = "Unknown" + this.orderNumber;
	}
	
	public String toString() {
		return "Name: " + this.name + ", Order Number: " + this.orderNumber;
	}
}

public class QueuePanel extends JPanel{
	
	private JButton aButton, sButton;
	private JTextField customerName, customerNumber;
	private Queue<Customer> customers = new LinkedList<Customer>();
	private JLabel name, number;
	
	public QueuePanel() {
		this.setPreferredSize(new Dimension(500, 500));
		
		aButton = new JButton("Add");
		sButton = new JButton("Serve");
		
	    customerName = new JTextField(15);
	    customerNumber = new JTextField(15);
	    
	    name = new JLabel("Name:");
	    number = new JLabel("Number:");
	    
	    aButton.addActionListener(new ButtonListener());
	    sButton.addActionListener(new ButtonListener());
	    
	   	this.setLayout(null);
	   	
	   	aButton.setBounds(430, 0, 70, 25);
	   	sButton.setBounds(0, 0, 70, 25);
	   	customerName.setBounds(430, 25, 70, 25);
	   	customerNumber.setBounds(430, 50, 70, 25);
	   	name.setBounds(390, 25, 70, 25);
	   	number.setBounds(390, 50, 70, 25);
	   	
	   	this.setBackground(Color.ORANGE);
	   	
	   	this.add(customerName);
	   	this.add(customerNumber);
	   	this.add(aButton);
	   	this.add(sButton);
	   	this.add(name);
	   	this.add(number);
	}
	
	private void updateList() {
		this.removeAll();
		this.add(customerName);
		this.add(customerNumber);
	   	this.add(aButton);
	   	this.add(sButton);
	   	this.add(name);
	   	this.add(number);
		
		int y = 0;
		if(customers.size() == 1) {
			String ss = customers.peek().toString();
			JLabel temp = new JLabel(ss);
			temp.setBounds(75, 0, 400, 25);
			add(temp);
		}
		else {
			Iterator<Customer> ot = customers.iterator();
			while(ot.hasNext()) {
				JLabel temp = new JLabel(ot.next().toString());
				temp.setBounds(75, y, 400, 25);
				y += 25;
				System.out.println(temp);
				add(temp);
			}
		}
		
		update(getGraphics());
		
	}

	private class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource() == aButton){
				if(!customerName.getText().equals("") && !customerNumber.getText().equals("")) {
					Customer temp = new Customer(Integer.parseInt(customerNumber.getText()), customerName.getText());
		            customers.add(temp);
		            updateList();
				}
				else if(!customerName.getText().equals("")) {
					Customer temp = new Customer(customerName.getText());
		            customers.add(temp);
		            updateList();
				}
				else if(customerName.getText().equals("") && customerNumber.getText().equals("")) {
					Customer temp = new Customer();
		            customers.add(temp);
		            updateList();
				}
				else if(!customerNumber.getText().equals("")) {
					Customer temp = new Customer(Integer.parseInt(customerNumber.getText()));
		            customers.add(temp);
		            updateList();
				}
					
			}
			if(ae.getSource() == sButton){
				if (customers.size() >= 1){
		            customers.remove();
		            updateList();
				}
			}
		}
	}
}


    

