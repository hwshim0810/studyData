package java.pracextends;

public class SampleExtends {

	public static void main(String[] args) {
		SampleChild a = new SampleChild("Hello");
		SampleChild b = new SampleChild("World");
		System.out.println(a.parentMember);
		System.out.println(b.parentMember);
	}
}
