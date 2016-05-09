package finalizeMethodExample;

public class PersonTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println(Person.MAX_AGE); //Since 'MAX_AGE' is static, it is accessible via tha class.
		
		System.out.println("number of persons: " + Person.getCount()); //0 is printed.
		
		//The count is incremented for the instantiation of each object.
		Person p1 = new Person("aaa");
		Person p2 = new Person("bbb");
		Person p3 = new Person("ccc");
		
		System.out.println("number of persons: " + Person.getCount()); //3 is printed.
		
		//The object that was referenced by p2 is now eligible for garbage collecting. The finalize() method of that object should be invoked
		//and decrement the count to 2.
		p2 = null;
		System.gc();
		System.out.println(p1);
		System.out.println(p2); //null is printed.
		System.out.println(p3);
		
		Thread.sleep(1000); //Pause for 1 sec to make sure the finalize() method is invoked.
		
		System.out.println("number of persons: " + Person.getCount()); //2 is printed.
		
	}
}
