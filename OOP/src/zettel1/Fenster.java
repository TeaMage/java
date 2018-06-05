package zettel1;

import javax.swing.*;

import java.awt.*;

import java.util.Scanner;
import java.util.Random;

public class Fenster {
	public static void main(String[] args) {
// im frame klassen im konstruktor jbutton übergeben
		Scanner scanner = new Scanner(System.in);

		System.out.println("Titel: ");
		String title = scanner.next();

		for (int i = 0; i < 10; i++) {
			Random zufall = new Random();
			int zufallszahl = zufall.nextInt(4);
			switch (zufallszahl) {
				case 0:
					MyFrameA frameA = new MyFrameA();
					frameA.setTitle("a");
					JButton a = new JButton();
					a.setText("close");
					a.addActionListener(new MyActionListener());
					frameA.add(a);
					break;
				case 1:
					MyFrameB frameB = new MyFrameB();
					frameB.setTitle("b");
					JButton b = new JButton();
					b.setText("close");
					b.addActionListener(new MyActionListener());
					frameB.add(b);
					break;
				case 2:
					MyFrameC frameC = new MyFrameC();
					frameC.setTitle("c");
					JButton c = new JButton();
					c.setText("close");
					c.addActionListener(new MyActionListener());
					frameC.add(c);
					break;
				case 3:
					MyFrameD frameD = new MyFrameD();
					frameD.setTitle("d");
					frameD.setPanels(4);
					frameD.setLayout(new GridLayout(2, 2));
					JButton d = new JButton();
					d.setText("close");
					d.addActionListener(new MyActionListener());
					frameD.add(d);
					break;
				default:
			}
		}
		boolean weiter = true;
		while (weiter) {
			System.out.println("Neuer Titel? :");
			String y = scanner.next();
			if (y.equals("ja")) {
				System.out.println("Titel :");
				title = scanner.next();
				Frame[] frames = Frame.getFrames();
				for (int i = 0; i < 10; i++) {
					frames[i].setTitle(title);
				}
			} else {
				weiter = false;
			}

		}
		scanner.close();

	}
}
