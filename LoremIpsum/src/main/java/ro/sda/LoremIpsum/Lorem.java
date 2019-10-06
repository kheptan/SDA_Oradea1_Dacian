package ro.sda.LoremIpsum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.thedeanda.lorem.LoremIpsum;

public class Lorem {

	public static void main(String[] args){
		Path path = Paths.get("/Users/kp/Desktop/Java.txt");
		
		try {
			//createRandomsToFile(path);
			BufferedReader reader = Files.newBufferedReader(path);
			
			//String[] c = reader.lines().collect(StringBuilder::new,StringBuilder::append,StringBuilder::append).toString().split(" ");
			long counter = reader.lines().map(s-> s.split(" "))
			         .count();
			System.out.println(counter);
			
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public static void createRandomsToFile(Path path) {
		try {
			BufferedWriter writer = Files.newBufferedWriter(path);
			writer.write(LoremIpsum.getInstance().getWords(3,30));
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
