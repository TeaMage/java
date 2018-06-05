package zettel1;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrameB extends MyFrameA {

	public void setLabels(String[] labels) {
		for (int i = 0; i < labels.length; i++) {
			JLabel label = new JLabel(labels[i]);
			this.add(label);
		}

	}

	

}
