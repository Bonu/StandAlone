package in.bonu.java8.newfeatures.app1;

public class TestApp {

	public static void main(String[] args) {
		TestInterface ti = () -> System.out.println("Java SE 8");
		ti.test();
	}

}
