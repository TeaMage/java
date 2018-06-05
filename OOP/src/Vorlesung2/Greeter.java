package Vorlesung2;

public class Greeter {
	String name;
	public String getMessage() {
		return "Hallo " + getName();		// nicht variable direkt --> kontrolle
	}
	protected String getName() {				// eig auch public, braucht man aber nicht
		return name;
	}
	private void setName (String name) {
		this.name = name;			// this wichtig // zentraler punkt für filtern von sonderzeichen, großschreibung, etc..
	}
	public Greeter() {			// Konstruktor bauen methode die aufgerufen wird bei objekterzeugung
								// gleicher name wie klasse, kein rückgabewert
								// gibt das objekt zurück
								// falls keiner angegeben, wird der leere gebaut
	}
	public Greeter(String name) {			// überladen
		setName(name);
	}
}
