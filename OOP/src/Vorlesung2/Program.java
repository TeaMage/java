package Vorlesung2;

import javax.swing.*;
import java.awt.FlowLayout;
//import Vorlesung3.*;

public class Program {

	public static void main(String[] args) {

		Greeter g = new Greeter("Ben");	
		
		JFrame j = new JFrame();
		j.setTitle("Greetings... ");
		j.setSize(500, 500);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel l = new JLabel(g.getMessage()); 
		j.add(l); // hinzufügen von label zu fenster
		j.setLayout( new FlowLayout()); // anordnung von label
		j.setVisible(true);
		
		
		
		
		
		
		//Vorlesung3.Program2.fooBar(); // explizit
		//Program2.fooBar();
	}

}
