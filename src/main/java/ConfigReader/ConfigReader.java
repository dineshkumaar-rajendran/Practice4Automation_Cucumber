package ConfigReader;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	public Properties get_prop() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("src/main/resources/Configuration/Config.properties");
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
}