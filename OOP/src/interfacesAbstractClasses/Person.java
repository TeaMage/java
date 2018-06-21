package interfacesAbstractClasses;

//Die Klasse ist abstract, kann also nicht per new instanziiert werden
public abstract class Person {
	public String Name;
	public String EMail;
	
	public Person(String name){
		this.Name = name;
	}
}
