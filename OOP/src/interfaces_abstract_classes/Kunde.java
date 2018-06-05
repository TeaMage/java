package interfaces_abstract_classes;
public class Kunde extends Person implements INewsletter {
	public int KNr;
	
	public Kunde(String name, int KNr) {
		super(name);
		this.KNr = KNr;
	}

	//Die in INewsletter angegebene Methoden müssen in der Klasse implementiert werden
	@Override
	public void sendMail(String text) {
		System.out.println("send: " + text);
	}

}
