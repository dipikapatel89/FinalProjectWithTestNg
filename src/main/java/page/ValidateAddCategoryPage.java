package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import util.BrowserFactory;
import util.PropertyLoader;

public class ValidateAddCategoryPage {

    WebDriver driver;
	
	public ValidateAddCategoryPage(WebDriver driver)
	{
		this.driver= driver;
		
	}
	
	@FindBy(how=How.CSS,using="input[name=\"categorydata\"]") WebElement addCategoryElement;
	@FindBy(how=How.CSS,using="input[value=\"Add category\"]") WebElement addCategoryButtonElement;
	@FindBy(how=How.XPATH,using="//select[@name='category']") WebElement categoryDropdwonElement;
	@FindBy(how=How.CSS, using = "select[name*='due_month']") WebElement monthDropdownElement;
	
	public void addCategory(String category)
	{
		addCategoryElement.sendKeys(category); 
		addCategoryButtonElement.click();
	}
	
	public void checkDuplicateCategory(String category)
	{
		Select s=new Select(categoryDropdwonElement);
		List<WebElement> li=s.getOptions();
		System.out.println("List of category size:" +li.size());	
		int size = li.size();
		Assert.assertEquals(li.get(size-1).getText(), category, "The category you want to add already exists");
	}
	
	public void checkMonthAvailable()
	{
		/*Select s=new Select(monthDropdownElement);
		List<WebElement> li=s.getOptions();
		
		
		// assert true if dropdown contains all months from MONTHS_LIST list
				PropertyLoader prop = new PropertyLoader();
				List<String> MONTHS_LIST = prop.getMonthsList();

				//Assert.assertTrue(li.containsAll(MONTHS_LIST), "Month check");*/
		
		monthDropdownElement.click();

		// get the select dropdown element
		Select dropDown = new Select(monthDropdownElement);
		
		// read all the otions from select element
		List<WebElement> options = dropDown.getOptions();

		// add all months from dropdown to a list
		List<String> monthsdropdown = new ArrayList();

		for (int i = 0; i < options.size(); i++) {
			monthsdropdown.add(options.get(i).getText());
		}

		// assert true if dropdown contains all months from MONTHS_LIST list
		PropertyLoader prop = new PropertyLoader();
		List<String> MONTHS_LIST = prop.getMonthsList();

		Assert.assertTrue(monthsdropdown.containsAll(MONTHS_LIST), "Month check");
	}
}
