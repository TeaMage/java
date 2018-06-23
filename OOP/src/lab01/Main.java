package lab01;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String[] bLabels = { "FrameB" };
		int[] cLabels = { 5 };
		MyPanel[] dPanels = { new MyPanel() };
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			Random zufall = new Random();
			int zufallszahl = zufall.nextInt(4);
			switch (zufallszahl) {
			case 0:
				MyFrameA frameA = new MyFrameA();
				frameA.setTitle("A");
				break;
			case 1:
				MyFrameB frameB = new MyFrameB();
				frameB.setTitle("B");
				frameB.setLabels(bLabels);
				break;
			case 2:
				new MyFrameC("C", cLabels);
				break;
			case 3:
				MyFrameD frameD = new MyFrameD();
				frameD.setTitle("D");
				frameD.setPanels(dPanels);
				break;
			default:
			}
		}
		while (true) {
			System.out.println("Neuer Titel:");
			String newTitle = scanner.next();
			Frame[] frames = Frame.getFrames();
			for (int i = 0; i < 10; i++) {
				frames[i].setTitle(newTitle);
			}

		}
	}
}
