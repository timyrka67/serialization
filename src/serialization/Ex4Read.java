package serialization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import serialization.Ex4Write.Event;
import serialization.Ex4Write.A;

public class Ex4Read {

	public static void main(String[] args) {

		File myFile = new File("/home/timur/JSON/Ex4.json");
		FileInputStream fIn;
		ArrayList<Object> list = new ArrayList<Object>();

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
			JsonParser parser = new JsonParser();
			JsonArray jsonArray = parser.parse(json).getAsJsonArray();
			Event event = gson.fromJson(jsonArray.get(0), Event.class);
			A a = gson.fromJson(jsonArray.get(1), A.class);
			list.add(event);
			list.add(a);
			System.out.println("listEvent.get(0).getClass().toString()" + list.get(0).getClass().toString());
			System.out.println("listEvent.get(1).getClass().toString()" + list.get(1).getClass().toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
