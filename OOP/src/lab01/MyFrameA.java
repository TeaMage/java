package lab01;

import javax.swing.*;

public class MyFrameA extends JFrame {

	public void setTitle(int title) {
		setTitle(Integer.toString(title));
	}

	public MyFrameA() {
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
