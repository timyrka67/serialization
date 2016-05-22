package serialization;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class TestWrite {
	public static class Animal {
		protected String name;
		protected String type;

		public Animal(String name, String type) {
			this.name = name;
			this.type = type;
		}

	}

	public static class Dog extends Animal {
		private boolean playsCatch;

		public Dog(String name, boolean playsCatch) {
			super(name, "dog");
			this.playsCatch = playsCatch;
		}

	}

	public static class Cat extends Animal {
		private boolean chasesLaser;

		public Cat(String name, boolean chasesLaser) {
			super(name, "cat");
			this.chasesLaser = chasesLaser;
		}

	}

	public static void main(String[] args) {
		List<Object> animals = new ArrayList<>();

		animals.add(new Dog("dog1", true));
		animals.add(new Dog("dog2", false));
		animals.add(new Cat("cat1", false));


		RuntimeTypeAdapterFactory<Animal> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory.of(Animal.class, "type")
				.registerSubtype(Dog.class, "dog").registerSubtype(Cat.class, "cat");
		Gson gson = new GsonBuilder().setPrettyPrinting().setVersion(1.0)
				.registerTypeAdapterFactory(runtimeTypeAdapterFactory).create();

		String json = gson.toJson(animals);

		try (FileWriter file = new FileWriter("/home/timur/JSON/TestWrite.json")) {
			file.write(json);
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + json);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}