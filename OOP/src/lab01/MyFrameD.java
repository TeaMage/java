package lab01;

public class MyFrameD extends MyFrameA {
	public void setPanels(MyPanel[] panels) {
		for (int i = 0; i < panels.length; i++) {
			add(panels[i]);
		}
	}
}
