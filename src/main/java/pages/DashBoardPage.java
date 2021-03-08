package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends PageBase {

	public DashBoardPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="ss")
	WebElement SearchElement;
	
	@FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]")
	WebElement FirstSearchElement;
	
	@FindBy(xpath="//*[@id=\"b2indexPage\"]")
	WebElement Datepicker;
	
	@FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div[1]/select")
	WebElement MonthSelectElement;
	
	@FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[2]/div/div/div[2]/svg")
	WebElement ArrowElement;
	
	
	@FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div[2]/select")
	WebElement StartDate;
	
	@FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[2]/div[1]/div[3]/div/div/div/div/div[1]/div[2]/select")
	WebElement EndDate;
	
	
	@FindBy(className = "sb-searchbox__button")
	WebElement searchBtn;
	
	
	

	public void setOption(WebElement dropdownList, String value) {
		
			getSelectOptions(dropdownList).getOptions().parallelStream()
					.filter(option -> option.getAttribute("textContent").toLowerCase().contains(value.toLowerCase()))
					.findFirst().ifPresent(option -> getSelectOptions(dropdownList)
							.selectByVisibleText(option.getAttribute("textContent")));
		
	}
//	public void SetDate(String MonthDate, String dayDate) {
//		clickButton(Datepicker);
//		//Thread.sleep(2000);
//		while(true) {
//			String Month= MonthElement.getText();
//			System.out.println(Month);
////			if(Month.equals(Month)) {
//				break;
//			}
//			else {
//				ArrowElement.click();		
//				//*[@id="frm"]/div[1]/div[2]/div[2]/div/div/div[3]/div[1]/table/tbody/tr/td[contains(text(),day)]/span/span
//			}
			
			
//			}
//		
//			}
//	
	public void SearchDetails(String SearchValue, String month, String start, String end) {
		setTextElementText(SearchElement,SearchValue);
		clickButton(FirstSearchElement);
		setOption(MonthSelectElement, month);
		setOption(StartDate, start);
		setOption(EndDate,end);
		clickButton(searchBtn);
	}
	


}
