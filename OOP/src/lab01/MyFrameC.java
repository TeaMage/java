package lab01;

import javax.swing.*;

public class MyFrameC extends MyFrameA {

	public void setLabels(int[] labels) {
		for (int i = 0; i < labels.length; i++) {
			JLabel myLabel = new JLabel(Integer.toString(labels[i]));
			this.add(myLabel);
		}

	}

	public MyFrameC(String title, int[] numbers) {
		super();
		setTitle(title);
		setLabels(numbers);
	}

	public MyFrameC(int title, int[] numbers) {
		super();
		setTitle(title);
		setLabels(numbers);
	}

	public MyFrameC(int title, int[] numbers, int size) {
		super();
		setTitle(title);
		setLabels(numbers);
		setSize(size, size);
	}

	public MyFrameC(String title, int[] numbers, int size) {
		super();
		setTitle(title);
		setLabels(numbers);
		setSize(size, size);
	}
}
