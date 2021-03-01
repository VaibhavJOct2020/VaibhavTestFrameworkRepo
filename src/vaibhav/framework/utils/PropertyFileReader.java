package vaibhav.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
	private Properties prop;
	
	public PropertyFileReader(String path) {
		//String path = "";
		File file = new File(path);
		FileInputStream fis;
		try {
				fis = new FileInputStream(file);
				prop = new Properties();
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}	
	public String getValue(String key) {
		return prop.getProperty(key);
	}
	
}
