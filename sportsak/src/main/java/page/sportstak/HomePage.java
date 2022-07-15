package page.sportstak;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBaseListener;

public class HomePage {
	
	@FindBy(xpath = "//span[text()='Home']")
	WebElement home;
	
	@FindBy(xpath = "(//div[@class='header']//*[local-name()='svg' and @class='MuiSvgIcon-root']/*[local-name()='path'])[1]")
	WebElement hamburgerMenu;
	
	@FindBy(xpath = "//span[text()='Buzz']")
	WebElement buzz;
	
	@FindBy(xpath = "//div[@role='tablist']//span[text()='IND-W vs SL-W']")
	WebElement thirdPage;
	
	@FindBy(xpath = "//span[text()='WebStory']")
	WebElement webStory;
	
	@FindBy(xpath = "(//img[@alt='Avatar'])[1]")
	WebElement webStories;

	public WebElement getWebStories() {
		return webStories;
	}

	public WebElement getWebStory() {
		return webStory;
	}

	public WebElement getThirdPage() {
		return thirdPage;
	}

	public WebElement getBuzz() {
		return buzz;
	}

	public HomePage() {
		PageFactory.initElements(TestBaseListener.getDriver(), this);
	}

	public WebElement getHome() {
		return home;
	}
	
	public WebElement getHamburgerMenu() {
		return hamburgerMenu;
	}

}
