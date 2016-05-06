package serialization;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Ex1Write {
	static class Event {
		private int IntNumber;
		private double DoubleNumber;
		private String name;

		public Event() {

		}

		public Event(int IntNumber, double DoubleNumber, String name) {
			this.IntNumber = IntNumber;
			this.DoubleNumber = DoubleNumber;
			this.name = name;
		}
	}

	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		Event event = new Event(5, 1.2, "test1");

		String string = gson.toJson(event);
		// System.out.println("Object " + event);

		try (FileWriter file = new FileWriter("/home/timur/JSON/Ex1.json")) {
			file.write(string);
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + string);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}