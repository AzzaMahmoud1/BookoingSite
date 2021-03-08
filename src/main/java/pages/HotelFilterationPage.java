package pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelFilterationPage extends PageBase {

	public HotelFilterationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@data-id='class-5']")
	WebElement StarsCheckBox;

	@FindBy(xpath = "//*[@data-id='ht_id-204']")
	WebElement hotelBox;

	@FindBy(xpath = "//*[@data-id='review_score-80']")
	WebElement reviewScoreCheckBox;

	@FindBy(xpath = "//*[@id=\"ajaxsrwrap\"]/div[2]/div/div/div/div/ul/li[10]/a")
	WebElement listLink;


	@FindBy(xpath = "//*[@id=\"ajaxsrwrap\"]/div[2]/div/div/div/div/ul/li[10]/ul/li[4]/a")
	public static  WebElement topReviewedLink;


	@FindBy(className = "sr-hotel__title")
	List<WebElement> HotelListResults;


	@FindBy(className = "bui-review-score__badge")
	List<WebElement> Ratings;


	@FindBy(className = "bui-review-score__text")
	List<WebElement> reviewScore;

	@FindBy(className = "sr_header")
	 WebElement searchResultsHeader;

	public static boolean assertionCheck;
	public void filterHotels() throws InterruptedException {

		clickButton(hotelBox);
		clickButton(StarsCheckBox);
		//waitElement(reviewScoreCheckBox, driver);
		clickButton(reviewScoreCheckBox);
		//waitElement(topReviewedLink, driver);
		clickButton(listLink);
		clickButton(topReviewedLink);
		Thread.sleep(4000);

	}
	
	public void Print_top_reviewed() {
		List<WebElement> vlinks = HotelListResults.stream().filter(WebElement::isDisplayed).collect(Collectors.toList());
		System.out.println("The total number of the Top 5 stars Hotels with Top Reviewed are :" + vlinks.size());
		System.out.println("the top 5 rated hotels are");
		String childText="Opens in new window";
		System.out.println(String.format("%30s %25s %10s %25s %10s", "Hotel", "|", "StarsRating", "|", "Reviews"));
		System.out.println(String.format("%s", "----------------------------------------------------------------------------------------------------------------"));



		for(int i =0;i<5;i++) {
			String elementText = HotelListResults.get(i).
					getText().replaceAll(childText,"");
			String elementText2 = elementText.replaceAll("(\\r|\\n)", "");
			String rating = Ratings.get(i).getText();
			String Reviews =reviewScore.get(i).getText();

			//System.out.println(elementText2+ "  with Stars "+rating +" and reviews "+Reviews);
			System.out.println(String.format	(" %30s %25s %10s %25s %10s", elementText2, "|",rating,"|",Reviews));
		}
	}

}
