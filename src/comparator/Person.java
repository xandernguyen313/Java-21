package comparator;

import java.util.Comparator;

public class Person implements Comparable<Person>{
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public int compareTo(Person o) {
		if(this.getAge() != o.getAge()) {
			return Integer.compare(this.getAge(), o.getAge());
		}
		return this.name.compareTo(o.name);
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
	}
}

class AgeComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return Integer.compare(o1.getAge(), o2.getAge());
	}
	
}