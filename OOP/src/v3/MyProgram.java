package v3;

import javax.swing.*;



import java.awt.GridLayout;

public class MyProgram {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		int y = 5;
		int x = 5;
		f.setTitle("W�rfel");
		f.setSize(600, 600);
		f.setLayout(new GridLayout(y, x));
		for (int i = 0; i < y * x; i++) {
			JPanel p = new MyPanel(); // polymorphie --> JPanel p = new
										// MyPanel() Parameter vom Typ m�glichst
										// weit oben, minimum an funktionalit�t
										// bereitstellen, abstrakter oder
										// konkreter

			f.add(p);

		}

		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
