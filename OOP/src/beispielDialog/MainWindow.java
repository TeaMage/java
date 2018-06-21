package beispielDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class MainWindow extends JFrame{
	
	private JFileChooser fileChooser;
	
	public MainWindow(){
		super();
		this.setSize(500,500);
		this.fileChooser = new JFileChooser();
		this.fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		JButton b = new JButton();
		b.setText("click");
		b.addActionListener(new ActionListener(){

			{
				
			}
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (fileChooser.showDialog(MainWindow.this, "choose file") == JFileChooser.APPROVE_OPTION){
					File f = fileChooser.getSelectedFile();
					JFrame fr = new JFrame();
					fr.setSize(600, 600);
					fr.add(new ImageViewPanel(f));
					fr.setVisible(true);
				}
			}
			
		});
		this.add(b);
		this.setVisible(true);
	}

}



