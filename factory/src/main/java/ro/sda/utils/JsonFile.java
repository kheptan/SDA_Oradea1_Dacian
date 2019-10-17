package ro.sda.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFile {
	private static Path path;
	private static BufferedReader bufferedReader;
	private static Map<Integer,String> worktools = new HashMap<>();
	
	public static void getFile() throws IOException {
	    try {
	    	String workDirPath = System.getProperty("user.dir");
		    URL url = JsonFile.class.getClass().getResource("/worktools.txt");
			path = Paths.get(url.toURI());
			bufferedReader=Files.newBufferedReader(path,Charset.forName("UTF-8"));
		} catch (URISyntaxException e) {
			System.out.println("File not found!");
		}
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
			tools.iterator().forEachRemaining(e->
			{
				JSONObject entry=(JSONObject) e;
				String name = (String) entry.get("name");
				Integer id = (int)(long) entry.get("id");
				worktools.put(id, name);
			});
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		displayTools();
	}
    public static void displayTools() {
    	System.out.println("Json imported with following items");
    	System.out.println("-----------------------------");
    	worktools.entrySet()
    	.forEach(e->System.out.println(e.getValue()));
    }

	public static Map<Integer, String> getWorktools() {
		return worktools;
	}
}
	
