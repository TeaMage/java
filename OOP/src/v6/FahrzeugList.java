package v6;

import java.util.*;

public class FahrzeugList<T extends Auto> extends ArrayList<T> {
	public T getFastest() {
		T result = null;
		for (T t : this) {
			if (result == null) {
				result = t;

			} else if (t.vMax > result.vMax) {
				result = t;
			}
		}
		return result;
	}
}// Beispiel für Kovarianz!!!!

// Klasse B erbt von A

// A : +foobar(Fahrzeug) gegen die ererbung kontravarianz
// mit der vererbung kovarianz // extends immer kovarianz
// B +foobar(Auto)
// nächstes mal prinzipien / Kovarianz/kontravarianz/invarianz
// klausur quellcodew ankreuzen ob kovarianz/kontravarianz
//& viele oop prinzipien wir machen nur eins --> SOLID PRINZIPIEN --> nicht im detail erklären, verstehen
