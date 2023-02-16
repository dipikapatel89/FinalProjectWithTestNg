package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.ValidateAddCategory;
import util.BrowserFactory;

public class ValidateCategoryTest {

	WebDriver driver;
	String category="testCategory8";
	
	
	
	/*@BeforeClass
	public void readConfig() {
		//InputStream //BufferedReader //FileReader //Scanner
		
		try {
			InputStream input = new FileInputStream("C:\\\\Users\\\\Sandip\\\\selenium\\\\ExlProjectSess8\\\\src\\\\main\\\\java\\\\config\\\\config.properties");
			Properties prop = new Properties();
			prop.load(input);
			//browser = prop.getProperty("browser");
			//System.out.println("Used Browser: " + browser);
			//url = prop.getProperty("url");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}*/
	@Test
	public void checkAddCategory()
	{
		driver=BrowserFactory.init();
		ValidateAddCategory validateaddcategory=PageFactory.initElements(driver,ValidateAddCategory.class);
		validateaddcategory.addCategory(category);
		//BrowserFactory.tearDown();	
	}
	
	@Test
	public void checkDuplicatecategory()
	{
		driver=BrowserFactory.init();
		ValidateAddCategory validateaddcategory=PageFactory.initElements(driver,ValidateAddCategory.class);
		System.out.println("helelllo");
		validateaddcategory.checkDuplicateCategory(category);
		//BrowserFactory.tearDown();
	}
	
}
