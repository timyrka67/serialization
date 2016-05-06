package serialization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;

import serialization.Ex1Write.Event;

public class Ex4Read {

	public static void main(String[] args) {

		File myFile = new File("/home/timur/JSON/Ex4.json");
		FileInputStream fIn;
		ArrayList<Object> listEvent;

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
			System.out.println("\n In string " + json);

			Gson gson = new Gson();
			Type collectionType = new com.google.gson.reflect.TypeToken<ArrayList<Object>>() {
			}.getType();

			listEvent = gson.fromJson(json, collectionType);
			System.out.println("Double check listEvent.get(1)" + listEvent.get(1));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
