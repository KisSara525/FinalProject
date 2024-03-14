package TestCases;

public class HomeTests {

    public void testHomePageTitle() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        // Verify homepage title
        // Example: Assert.assertEquals(homePage.getTitle(), "Expected Title");
    }

}
