package lab01;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class MyFrameA extends JFrame {

	public void setTitle(int title) {
		setTitle(Integer.toString(title));
	}

	public MyFrameA() {
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		JButton b = new JButton();
		b.setText("EXIT");
		b.addActionListener(new MyActionListener());
		add(b);
	}
}
