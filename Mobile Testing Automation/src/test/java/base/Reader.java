package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Reader {
	 public String path(String object) throws IOException {
		 Properties obj = new Properties();
		 FileInputStream objfile = new FileInputStream("src/test/java/data/repo.properties");
		 obj.load(objfile);
		 String xpath = obj.getProperty(object);
		 return xpath;
	 }
}
