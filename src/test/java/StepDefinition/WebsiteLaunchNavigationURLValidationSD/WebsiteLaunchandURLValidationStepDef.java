package StepDefinition.WebsiteLaunchNavigationURLValidationSD;
import java.time.DayOfWeek;
//import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Date;

import org.junit.Assert;

public class WebsiteLaunchandURLValidationStepDef {
	
	WebDriver driver;
	
	@Given("^User launch the BBC website$")
	public void User_launch_the_BBC_Website()
	{
		
    	//Launching Chrome driver
		System.setProperty("webdriver.chrome.driver", "/Users/anjalisingh/Desktop/CucumberSetups/chromedriver");
    	driver = new ChromeDriver();
    	driver.get("https://www.BBC.com");
    	driver.manage().window().maximize();
    	
    	
	}
	
	@And("^User validates the Home page$")
    public void User_validates_the_Home_Page() throws InterruptedException
    {
    //Providing Consent
	driver.findElement(By.xpath("//p[@class='fc-button-label'and  text()='Consent']")).click();
		
	String Home = driver.getTitle();
    Assert.assertEquals(Home, "BBC - Homepage");
    System.out.println("BBC clicked");
    	
    }

	
	
	@When("^User clicks on Each navigation link$")
	public void User_clicks_on_Each_navigation_links()
	{
		
		
	//Accepting Cookies
	driver.findElement(By.xpath("//span[@data-region-filter='eu' and text()='Yes, I agree']")).click();
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	//Clicking on the News URL on BBC Web-site
	WebElement NewsLink =	driver.findElement(By.xpath("//a[@href='https://www.bbc.com/news']//span[text()='News']"));
	NewsLink.click();
    System.out.println("NEWS clicked");
	String NewsPageTitle = driver.getTitle();
	
	//Validating the Page Title
	Assert.assertEquals("Home - BBC News", NewsPageTitle);
	
	//Closing the Sing in modal
	
	//Clicking on the Sport Navigation Link
	WebElement SportsLink =	driver.findElement(By.xpath("//a[@href='https://www.bbc.com/sport']//span[text()='Sport']"));
	SportsLink.click();
	System.out.println("Sports Link clicked");
	String SportsPageTitle = driver.getTitle();
	Assert.assertEquals("BBC Sport | Scores, Fixtures, News | Live Sport", SportsPageTitle);
	
	//Clicking on the Reels Navigation Link
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));
	WebElement ReelsLink =	driver.findElement(By.xpath("//a[@href='https://www.bbc.com/reel'and text()='Reel']"));
	ReelsLink.click();
	System.out.println("Reels Link clicked");
	String ReelsPageTitle = driver.getTitle();
	Assert.assertEquals("Home - BBC Reel", ReelsPageTitle);
	
	//Clicking on WorkLife Navigation Link
	WebElement WorkLifeLink =	driver.findElement(By.xpath("//a[@href='https://www.bbc.com/worklife']//span[text()='Worklife']"));
	WorkLifeLink.click();
	//switching to different tab
	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs2.get(1));
	System.out.println("Worklife Link clicked");
	String worklifePageTitle = driver.getTitle();
	Assert.assertEquals("Home - BBC Worklife", worklifePageTitle);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));
	
	
	//Clicking on Travel Navigation Link
	WebElement TravelLink =	driver.findElement(By.xpath("//a[@href='https://www.bbc.com/travel']//span[text()='Travel']"));
	TravelLink.click();
	System.out.println("Travel Link clicked");
	String TravelPageTitle = driver.getTitle();
	Assert.assertEquals("Home - BBC Travel", TravelPageTitle);
	
	//Clicking on Future Navigation Link
	WebElement FutureLink =	driver.findElement(By.xpath("//a[@href='https://www.bbc.com/future']//span[text()='Future']"));
	FutureLink.click();
	System.out.println("Future Link clicked");
	String FuturePageTitle = driver.getTitle();
	Assert.assertEquals("Home - BBC Future", FuturePageTitle);
	}
	
	
	@Then("^User Land on the Individual pages$")
	public void User_Land_on_the_Individual_pages()
	{
		//Covered in the Above step definition
		
	}
	
	
	@When("^User Validates the current Day and Date$")
	public void User_validates_the_current_Day_and_Date()
	{
	driver.findElement(By.xpath("//span[@data-region-filter='eu' and text()='Yes, I agree']")).click();
	String ActualDate = driver.findElement(By.xpath("(//h2[@class='module__title'])[1]")).getText();
	//System.out.println(ActualDate);
	String[] ArryString = ActualDate.split("[ \n,]");
    
	//Getting Today's Day
	LocalDate today = LocalDate.now();
	DayOfWeek dayOfWeek = today.getDayOfWeek();
	
	Assert.assertEquals(ArryString[3].toLowerCase(), dayOfWeek.name().toLowerCase());
	
    //Getting Today's Date;
	Month CurrentMonth = today.getMonth();
	int TodaysDate = today.getDayOfMonth();
	
	//validating day and  Month
	Assert.assertEquals(TodaysDate, Integer.parseInt(ArryString[5]));
	Assert.assertEquals(ArryString[6].toLowerCase(),CurrentMonth.name().toLowerCase());
	
	
	}
	
	@When("^User clicks on NEWS Navigation Link$")
	public void User_clicks_on_NEWS_Navigation_Link()
	{
		WebElement NewsLink =	driver.findElement(By.xpath("//a[@href='https://www.bbc.com/news']//span[text()='News']"));
		NewsLink.click();
		//getting the current URL and validating it with the expected one
		String NEWSURL = driver.getCurrentUrl();
		Assert.assertEquals(NEWSURL, "https://www.bbc.com/news");
	}
	
	@When("^User Search in the Search bar$")
	public void User_Search_in_the_search_bar()
	{
		//User clicks on the search bar button
		driver.findElement(By.xpath("//a[@id='orbit-search-button']")).click();
		
		//user clicks and enter the string in search bar
		
		WebElement Searchbar = driver.findElement(By.xpath("//input[@id='search-input']"));
		Searchbar.click();
		Searchbar.clear();
		Searchbar.sendKeys("Houghton Mifflin Harcourt");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		
	}
	
	@Then("^User validates the Search results$")
	public void User_validates_the_Search_results()
	{
		List<WebElement> Searchresult = driver.findElements(By.xpath("//main[@id='main-content']//a[@href]//span//p//span"));
	    for(WebElement s : Searchresult)
	    {
	    	System.out.println(s.getText());
	    }
	}
	
	@After
	public void User_close_the_Browser()
	{
		driver.quit();
	}
}
