package v5;

import java.io.Serializable;

public class Rechnung implements Serializable {
	public double Betrag;
	private transient int kundennummer;

	public void setKundennummer(int knr) {
		this.kundennummer = knr;
	}

	public int getKundennummer() {
		return kundennummer;
	}
}
