package interfacesAbstractClasses;

// Mitarbeiter erbt von Person und implementiert das Interface INewsletter
public abstract class Mitarbeiter extends Person implements INewsletter, IBezahlbar {

	public String B�ro;
	
	public Mitarbeiter(String name) {
		super(name);
	}
	
	public void zahlen(double wert){
		System.out.println("�berweise: " + wert);
	}
	
	public void lohnabrechnung(){
		double brutto = getGehalt(); // die Methode getGehalt kann verwendet werden, obwohl sie in dieser Klasse nicht implementiert wird. Sie ist aber als abstract definiert
		double netto = brutto / 2;
		zahlen(netto);
	}

	protected abstract double getGehalt(); //abstracte Methoden (k�nnen nur in abstracten Klassen existieren) m�ssen in abgeleiteten Klassen implementiert werden, k�nnen aber in dieser Klasse schon aufgerufen werden
	
	//Die in INewsletter angegebene Methoden m�ssen in der Klasse implementiert werden
	@Override
	public void sendMail(String text) {
		System.out.println("send: " + text);
	}

}
