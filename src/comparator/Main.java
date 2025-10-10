package comparator;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<>();
	    people.add(new Person("Bob", 25));
	    people.add(new Person("Alice", 20));
	    people.add(new Person("Charlie", 35));
	    System.out.println("Before sorting: " + people);
	    Collections.sort(people);
	    System.out.println("After sorting: " + people);
	    Collections.sort(people, new AgeComparator());
	    System.out.println("After sorting with comparator: " + people);

	}

}
