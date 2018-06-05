package interfaces_abstract_classes;
public class Verkäufer extends Mitarbeiter {

	public Verkäufer(String name) {
		super(name);
	}

	//Die abstracte Methode _muss_ implementiert werden
	@Override
	protected double getGehalt(){
		return 6000;
	}
}
