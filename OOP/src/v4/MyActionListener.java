package v4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("moin" + this.i);
		
		
	}

	private int i;

	public MyActionListener(int i) {
		this.i = i;
	}

}
