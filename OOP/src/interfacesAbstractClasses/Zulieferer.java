package interfacesAbstractClasses;

//Zulieferer erbt von Person
public class Zulieferer extends Person {

	public Zulieferer(String name) {
		super(name);
	}
	
	public void zahlen(double wert){
		System.out.println("Überweise: " + wert);
	}

}
