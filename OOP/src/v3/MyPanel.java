package v3;

import java.awt.Color;

import java.awt.Graphics;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	public void fooBar() {
		System.out.println("Moin!");
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g); // Funktionalität erweitern hier scheint es egal zu
		// sein, immer basicmethode aufrufen als erstes oder als letztes
		// man muss gucken was in der methode passiert
		// quellcode mitinstallieren um zu sehen wie die methode implementiert
		// ist --> eig uninteressant für uns
		g.fillRect(0, 0, 50, 50);
		g.setColor(new Color(255, 0, 0));
		g.fillRect(5, 5, 40, 40);
	}
}
