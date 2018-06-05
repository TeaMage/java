package v6;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Fahrzeug[] fa = new Fahrzeug[3];
		fa[0] = new Fahrzeug();
		fa[0].Name = "Bobby Car";
		fa[1] = new Auto();
		fa[1].Name = "Smart";
		((Auto) fa[1]).vMax = 140;
		fa[2] = new Schiff();
		fa[2].Name = "Fischkutter";
		((Schiff) fa[2]).vMax = 5;

		// for (int i = 0; i < 3; i++) {
		// System.out.println(fa[i].Name);
		// }
		for (Fahrzeug f : fa) {
			if (f instanceof Auto) { // filtern
				System.out.println(f.Name); // for each Schleife -- sollte man
											// immer nutzen -- nicht auf arrays
											// beschränkt -- gibt auch linkliste
											// --> eher eine kette, List5 ist
											// interface!!
			}

		}
		List<Auto> al = new FahrzeugList<Auto>(); // ArrayList<Fahrzeug> al =
													// new ArrayList<>();
		Fahrzeug f = new Fahrzeug();
		f.Name = "Bobby Car";
		// al.add(f);
		Auto a = new Auto();
		f.Name = "Smart";
		a.vMax = 140;
		al.add(a);
		Schiff s = new Schiff();
		s.Name = "Fischkutter";
		s.vMax = 5;
		al.add(s);
		for (Auto fz : al) {

			System.out.println(fz.vMax);

		}
		System.out.println(((FahrzeugList) al).getFastest().vMax);

	}

}
