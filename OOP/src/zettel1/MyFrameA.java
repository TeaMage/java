package zettel1;

import javax.swing.JFrame;

public class MyFrameA extends JFrame {

	int title;

	protected void setTitle(int title) {
		super.setTitle(Integer.toString(title));
	}

	public MyFrameA() {
		setVisible(true);
		setSize(200, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
