package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	static Properties prop;

	public TestBase() {
		prop = new Properties();
		String path = System.getProperty("user.dir") + "//src//test//resources//configFolder//config.properties";
		FileInputStream fin;
		try {
			fin = new FileInputStream(path);
			prop.load(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void initialize() {
		String strBrowser = prop.getProperty("browser");
		if (strBrowser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (strBrowser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
	}
	public static void exit() {
		driver.close();
	}
}
