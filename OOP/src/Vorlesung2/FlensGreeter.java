package Vorlesung2;

public class FlensGreeter extends Greeter { // flensgreeter erbt von der
											// Basisklasse und übernimmt alles
											// von ihr
	public FlensGreeter(String name) { // abgeleitet
		super(name); // das eigene Objekt, aber die Basisklasse, kontruktor der
						// basisklasse
	} // überschreibt nur eine

	@Override // angewöhnen! // überschreiben alles geerbt, aber diese
				// überschreiben, neu
				// definieren, alt ignorieren
	public String getMessage() {
		return "moin und " + super.getMessage(); // meckert wegen private
		// lösung: protected!!
		// this. --> methode ruft
		// methode auf -->
		// stackoverflowerror
	}

	public String fooBar() {
		return "test";
	}
}
