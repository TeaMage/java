package lab01;

import javax.swing.JLabel;

public class MyFrameB extends MyFrameA {
	public void setLabels(String[] labels) {
		for (int i = 0; i < labels.length; i++) {
			JLabel myLabel = new JLabel(labels[i]);
			this.add(myLabel);
		}

	}

	public MyFrameB() {
		super();

	}
}
