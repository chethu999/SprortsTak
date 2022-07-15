package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import base.TestBaseListener;


public class SeleniumLibs {
	
	public static WebDriverWait wait;
	
	public static void scrollUsingJavaScript(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) TestBaseListener.getDriver();
			js.executeScript("arguments[0].scrollIntoView();", element);

		} catch (Exception e) {
			Reporter.log("ERROR : Couldn't scrollUsingJavaScript. Following exception occurred: " + e.getMessage());
		}
	}
	
	private static void waitElementClickable(WebElement element) {

		try {
			TestBaseListener.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait = new WebDriverWait(TestBaseListener.getDriver(), 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			Reporter.log(
					"*Internal call* Couldn't verify element's clickability. Following exception occurred: " + e);
		}
	}
	
	public static void highLightElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) TestBaseListener.getDriver();
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		try {
			TestBaseListener.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			Reporter.log(
					"ERROR : Couldn't highLightElement the field. Following exception occurred: " + e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
	}

	public void click(WebElement element) {

	    Reporter.log("Executing Method : " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			if (element == null) {
				Assert.fail("Element to be clicked is not specified");
			}
			scrollUsingJavaScript(element);
			waitElementClickable(element);
			highLightElement(element);
			TestBaseListener.actions.moveToElement(element).click().build().perform();
		} catch (Exception e) {
			Reporter.log("ERROR : in click(). Following exception occurred: " + e.getMessage());
		}
	}
	
	public static boolean isElementPresent(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed() || element.isEnabled())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		} catch (StaleElementReferenceException e) {
			flag = false;
		}
		return flag;
	}
	
	public void mouseHoverJScript(WebElement HoverElement) {
		try {
			Reporter.log("Executing Method : " + Thread.currentThread().getStackTrace()[1].getMethodName());
			if (isElementPresent(HoverElement)) {

				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				((JavascriptExecutor) TestBaseListener.getDriver()).executeScript(mouseOverScript, HoverElement);
				TestBaseListener.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			} else {
				Reporter.log("Element was not visible to hover " + "\n");

			}
		} catch (StaleElementReferenceException e) {
			Reporter.log("Element with " + HoverElement + "is not attached to the page document" + e.getStackTrace());
		} catch (NoSuchElementException e) {
			Reporter.log("Element " + HoverElement + " was not found in DOM" + e.getStackTrace());
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Error occurred while hovering" + e.getStackTrace());
		}
	}
	
	public void staticWait(int time) {
		try {
			Reporter.log("Executing Method : " + Thread.currentThread().getStackTrace()[1].getMethodName());
			TestBaseListener.getDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		} catch (Exception e) {
			Reporter.log("ERROR : in staticWait. Following exception occurred: " + e.getMessage());
		}
	}
	
	public static void clickUsingJavaScript(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) TestBaseListener.getDriver();
			highLightElement(element);
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
