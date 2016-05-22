package serialization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import serialization.TestWrite.Animal;
import serialization.TestWrite.Cat;
import serialization.TestWrite.Dog;

public class TestRead {

	public static void main(String[] args) {
		File myFile = new File("/home/timur/JSON/TestWrite.json");
		FileInputStream fIn;
		List<Object> list = new ArrayList<Object>();
	
		try {
			fIn = new FileInputStream(myFile);
			InputStreamReader isr = new InputStreamReader(fIn);
			BufferedReader bufferedReader = new BufferedReader(isr);
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line);
			}
			String json = sb.toString();
			RuntimeTypeAdapterFactory<Animal> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
				    .of(Animal.class, "type")
				    .registerSubtype(Dog.class, "dog")
				    .registerSubtype(Cat.class, "cat");
			Gson gson = new GsonBuilder().setPrettyPrinting().setVersion(1.0).registerTypeAdapterFactory(runtimeTypeAdapterFactory).create();
			Type listType = new TypeToken<List<Animal>>(){}.getType();
			List<Object> fromJson = gson.fromJson(json, listType);
			for (Object animal : fromJson) {
			    if (animal instanceof Dog) {
			        System.out.println(animal + " DOG");
			    } else if (animal instanceof Cat) {
			        System.out.println(animal + " CAT");
			    } else if (animal instanceof Animal) {
			        System.out.println(animal + " ANIMAL");
			    } else {
			        System.out.println("Class not found");
			    }
			}

		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}