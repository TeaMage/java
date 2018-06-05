package v4;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyProgram {

	public static void main(String[] args) {
		int X = 3;
		int Y = 3;
		JFrame f = new JFrame();
		f.setLayout(new GridLayout(X, Y));
		f.setTitle("Test");
		f.setSize(600, 600);
		ActionListener a = new MyActionListener(0);
		for (int i = 0; i < X * Y; i++) {
			JButton b = new JButton();
			b.setText("" + i);

			b.addActionListener(new MyActionListener(i));

			f.add(b);
		}
		f.setVisible(true);

	}

}
