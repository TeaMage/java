package zettel1;

import javax.swing.JFrame;

import javax.swing.JLabel;

public class MyFrameC extends MyFrameB {

	public void setLabels(int[] labels) {
		for (int i = 0; i < labels.length; i++) {
			String s = Integer.toString(labels[i]);
			JLabel label = new JLabel(s);
			this.add(label);
		}
	}

	public MyFrameC(String title, int[] labels) {
		setTitle(title);
		setLabels(labels);
	}

	public MyFrameC(String title, int[] labels, int size) {
		setTitle(title);
		setSize(size, size);
		setLabels(labels);

	}
	public MyFrameC() {
		setVisible(true);
		setSize(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
