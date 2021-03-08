package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashBoardPage;
import pages.HotelFilterationPage;

public class HotelFilterationTest extends TestBase{
	DashBoardPage DashboardObject;
	HotelFilterationPage HotelFilterationObject;

	@Test(alwaysRun = true,priority = 1)
		public void Search() {
		DashboardObject= new DashBoardPage(driver);
		DashboardObject.SearchDetails("Riyadh", "April 2021", "1", "7");
		Assert.assertTrue(driver.getCurrentUrl().contains("searchresults"));
	}
	@Test(dependsOnMethods = "Search")
	public void hotelFilteration() throws InterruptedException{
		HotelFilterationObject = new HotelFilterationPage(driver);
		HotelFilterationObject.filterHotels();
		HotelFilterationObject.Print_top_reviewed();
		Assert.assertNull(HotelFilterationPage.topReviewedLink.getAttribute("checked"));
		
	}
	
}
