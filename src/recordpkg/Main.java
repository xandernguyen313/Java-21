package recordpkg;



public class Main {
	
	
	public static void main(String[] args) {
		Person p1 = new Person("Adam", 22);
		Person p2 = new Person("Adam", 22);
		
		System.out.println(p1.equals(p2));
	}
}
