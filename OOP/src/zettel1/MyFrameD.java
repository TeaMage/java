package zettel1;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.GridLayout;

import javax.swing.JLabel;

public class MyFrameD extends JFrame {
	public void setPanels(int number) {
		for (int i = 0; i < number; i++) {
			JPanel panel = new MyPanel();
			this.add(panel);
		}

	}

	public MyFrameD() {
		setVisible(true);
		setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
