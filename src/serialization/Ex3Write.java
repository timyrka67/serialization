package serialization;

import java.awt.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Ex3Write {

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
			this.setName(name);
			this.a = a;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		A a = new A();
		Event event1 = new Event(5, 1.2, "test1", a);
		Event event2 = new Event(3, 3.2, "test2", a);
		ArrayList<Event> list = new ArrayList<Event>();
		list.add(event1);
		list.add(event2);

		
		

		String string = gson.toJson(list);

		try (FileWriter file = new FileWriter("/home/timur/JSON/Ex3.json")) {
			file.write(string);
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + string);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}