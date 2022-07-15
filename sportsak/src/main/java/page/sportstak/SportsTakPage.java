package page.sportstak;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBaseListener;

public class SportsTakPage {

	@FindBy(xpath = "//div[@class='sidebar__dropdown ']//following-sibling::button//p")
	WebElement changeLanguage;
	
	@FindBy(xpath = "//p[text()='Theme']")
	WebElement theme;
	
	public WebElement getTheme() {
		return theme;
	}

	public SportsTakPage() {
		PageFactory.initElements(TestBaseListener.getDriver(), this);
	}

	public WebElement getChangeLanguage() {
		return changeLanguage;
	}

}
