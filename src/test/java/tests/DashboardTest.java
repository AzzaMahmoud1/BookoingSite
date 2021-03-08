package tests;

import org.testng.annotations.Test;

import pages.DashBoardPage;

public class DashboardTest extends TestBase{
DashBoardPage DashboardObject;

@Test
	public void Search() {
	DashboardObject= new DashBoardPage(driver);
	DashboardObject.SearchDetails("Riyadh", "April 2021", "1", "7");
	
}
}
