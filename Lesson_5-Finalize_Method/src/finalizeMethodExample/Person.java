package finalizeMethodExample;

public class Person {

	public static final int MAX_AGE = 120; // constant
	private static int count;
	private int id;
	private String name;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {

		if (age >= 0 && age <= MAX_AGE) {
			this.age = age;
		}
	}

	public Person(String name) {
		super();
		this.id = ++count;
		this.name = name;
	}

	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

	//finalize() is overridden from the Object class. It is invoked automatically before the garbage collector destroys the object.
	//However, it is not guaranteed when or if this method will ever be invoked. When it is invoked, the finalizers of the objects of the sub-classes
	//are invoked in the order of the hierarchy and then the finalizers of the super classes up the hierarchy, up to the Object class finalizer. And then
	//the object is removed from the memory.
	protected void finalize() throws Throwable {
		count--;
	}

	public static int getCount() {
		return count;
	}

}
