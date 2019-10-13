package ro.sda.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFile {
	private static Path path;
	private static BufferedReader bufferedReader;
	
	public static void getFile() throws IOException {
		path = Paths.get("/Users/kp/worktools.txt");
	    bufferedReader=Files.newBufferedReader(path,Charset.forName("UTF-8"));
	}
	
	public static Stream<String> bufferToStream() {
		return bufferedReader.lines();
	}
	
	public static void closeBuffer() throws IOException {
		bufferedReader.close();
	}
	
	public static void jsonParser() {
		JSONParser parser = new JSONParser();
		try {
			JSONObject ob = (JSONObject) parser.parse(bufferedReader);
			JSONArray tools = (JSONArray) ob.get("WorkTools");
			JSONObject entry=(JSONObject) tools.get(3);
			String name = (String) entry.get("name");
			Long id = (Long) entry.get("id");
			System.out.println(name+ " " + id);
			
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
	
