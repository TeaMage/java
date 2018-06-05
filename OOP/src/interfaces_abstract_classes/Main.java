package interfaces_abstract_classes;

public class Main {

	public static void main(String[] args) {
		Person[] p = new Person[5];
		p[0] = new Verk�ufer("Verk�ufer 1");
		p[1] = new Kunde("Kunde 1", 0);
		p[2] = new Entwickler("Entwickler 1");
		p[3] = new Zulieferer("Zulieferer 1");
		p[4] = new Verk�ufer("Verk�ufer 1");

		for (int i = 0; i < p.length; i++) {
			if (p[i] instanceof INewsletter) { // Pr�fen, ob das Objekt (vom Typ
												// Person) auch vom Typ
												// INewsletter ist
				INewsletter n = (INewsletter) p[i]; // wenn ja, kann es in den
													// Typ gecastet werden
				n.sendMail("mail"); // und dann als INewsletter verwendet werden
			}
		}

	}

}
