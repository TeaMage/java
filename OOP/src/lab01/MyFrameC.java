package lab01;

import javax.swing.*;

public class MyFrameC extends MyFrameB {
	public MyFrameC(int title, int[] numbers) {
		super();
		setTitle(title);
		for (int i = 0; i < numbers.length; i++) {
			setLabels(Integer.toString(numbers[i]));
		}
	}

	public MyFrameC(String title, int[] numbers) {
		super();
		setTitle(title);

	}

	public MyFrameC(String title, int size, int[] numbers) {
		super();
		setTitle(title);
		setSize(size, size);

	}

	public MyFrameC(int title, int size, int[] numbers) {
		super();
		setTitle(title);
		setSize(size, size);
		for (int i = 0; i < numbers.length; i++) {
			setLabels(Integer.toString(numbers[i]));
		}
	}
}
