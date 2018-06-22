package lab01;

import javax.swing.*;
import java.awt.*;

public class MyFrameB extends MyFrameA {
	public void setLabels(String label) {
		JLabel myLabel = new JLabel(label);
		this.add(myLabel);
	}

	public MyFrameB() {
		super();
		setLayout(new FlowLayout());
	}
}
