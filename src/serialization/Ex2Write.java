package serialization;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Ex2Write {

	static class A {
		private int IntNumberA;
		private double DoubleNumberA;
		private String nameA;

		public A() {
			this.IntNumberA = 2;
			this.DoubleNumberA = 2.2;
			this.nameA = "Name";
		}
	}

	static class Event {
		private int IntNumber;
		private double DoubleNumber;
		private String name;
		private A a;

		public Event() {

		}

		public Event(int IntNumber, double DoubleNumber, String name, A a) {
			this.IntNumber = IntNumber;
			this.DoubleNumber = DoubleNumber;
			this.name = name;
			this.a = a;
		}
	}

	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		A a = new A();
		Event event = new Event(5, 1.2, "test1", a);

		String string = gson.toJson(event);
		// System.out.println("Object " + event);

		try (FileWriter file = new FileWriter("/home/timur/JSON/Ex2.json")) {
			file.write(string);
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + string);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}