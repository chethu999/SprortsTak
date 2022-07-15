package sportstak;

import java.awt.AWTException;
import java.awt.Robot;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBaseListener;
import flow.sportstak.BrokenLinksFlow;
import flow.sportstak.HomePageFlow;
import flow.sportstak.SportsTakFlow;
import page.sportstak.HomePage;


public class SportsTakTest2 extends TestBaseListener {

	SportsTakFlow sportsTakFlow;
	HomePageFlow homePageFlow;
	BrokenLinksFlow brokenLinksFlow;
	HomePage homePage;
	
	@BeforeClass
	public void launch() {
		sportsTakFlow= new SportsTakFlow();
		homePageFlow= new HomePageFlow();
		brokenLinksFlow= new BrokenLinksFlow();
		homePage=new HomePage();
	}
	
	
	@Test
	public void openUrlAndChangeLanguage_Test() {
		
		homePageFlow.navigateToHamburgerMenu();
		sportsTakFlow.changeLanguage();
		
	}
	
	@Test
	public void changeBackLanguage_Test() {
		
		homePageFlow.navigateToHamburgerMenu();
		Assert.assertEquals(sportsTakFlow.verifyLanguage(), "भाषा बदलें");
		sportsTakFlow.changeLanguage();
		
	}
	
	@Test
	public void verifyBrokenLinksHomepage_Test() {
		homePageFlow.navigateToHomePage();
		brokenLinksFlow.verifyBrokenLinks();
	}
	
	@Test
	public void verifyBrokenLinksBuzz_Test() {
		homePageFlow.navigateToBuzz();
		click(homePage.getThirdPage());
		brokenLinksFlow.verifyBrokenLinks();
	}
	
	@Test
	public void changeTheme_Test() {
		String colorBeforeChange=sportsTakFlow.captureThemeColour();
		homePageFlow.navigateToHamburgerMenu();
		sportsTakFlow.changeTheme();
		String colorAfterChange=sportsTakFlow.captureThemeColour();
		Assert.assertNotEquals(colorBeforeChange, colorAfterChange, "Theme not Changed Successfully");
	}
	
}
