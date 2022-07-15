package flow.sportstak;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.TestBaseListener;
import page.sportstak.SportsTakPage;
import util.SeleniumLibs;

public class SportsTakFlow extends SeleniumLibs {
	
	SportsTakPage sportsTakPage;
	
	public SportsTakFlow(){
		sportsTakPage= new SportsTakPage();
	}

	public void changeLanguage() {
		wait.until(ExpectedConditions.visibilityOf(sportsTakPage.getChangeLanguage()));
		click(sportsTakPage.getChangeLanguage());
		staticWait(3);
	}
	
	public void changeTheme() {
		wait.until(ExpectedConditions.visibilityOf(sportsTakPage.getTheme()));
		click(sportsTakPage.getTheme());
		staticWait(3);
	}
	
	public String verifyLanguage() {
		staticWait(2);
		String text=sportsTakPage.getChangeLanguage().getText();
		return text;
	}
	
	public String captureThemeColour() {

		WebElement t = TestBaseListener.getDriver().findElement(By.xpath("//div[@class='league responsive']"));
		String s = t.getCssValue("background-color");
		String c = Color.fromString(s).asHex();
		return c;
	}
	
}
