package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	protected WebDriver driver;
	public Actions action;
	// create constructor 
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	protected static void clickButton(WebElement button) {
		button.click();
	}
	protected static void setTextElementText(WebElement textElment, String value) {
		textElment.clear();
		textElment.sendKeys(value);
	} 
	public Select getSelectOptions(WebElement dropdownList) {
		return new Select(dropdownList);
	}

	public void waitElement(WebElement Element , WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}


}
