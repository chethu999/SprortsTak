package flow.sportstak;

import page.sportstak.HomePage;
import util.SeleniumLibs;

public class HomePageFlow extends SeleniumLibs {
	
	HomePage homePage;
	
	public HomePageFlow() {
		homePage=new HomePage();
	}
	
	public void navigateToHamburgerMenu() {
		
		mouseHoverJScript(homePage.getHamburgerMenu());	
		click(homePage.getHamburgerMenu());
		
	}
	
	public void navigateToHomePage(){
		
		mouseHoverJScript(homePage.getHome());	
		click(homePage.getHome());
	}
	
	public void navigateToBuzz(){

		mouseHoverJScript(homePage.getBuzz());	
		click(homePage.getBuzz());
	}
	
	public void navigateToWebStory(){

		mouseHoverJScript(homePage.getWebStory());	
		click(homePage.getWebStory());
	}

}
