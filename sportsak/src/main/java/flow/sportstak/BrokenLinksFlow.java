package flow.sportstak;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TestBaseListener;
import util.SeleniumLibs;

public class BrokenLinksFlow extends SeleniumLibs {

	public void verifyBrokenLinks(){

		HttpURLConnection huc = null;
		int respCode = 200;
		String url="";

		List<WebElement> links = TestBaseListener.getDriver().findElements(By.tagName("a"));

		Iterator<WebElement> it = links.iterator();

		while(it.hasNext()){

			url = it.next().getAttribute("href");

			System.out.println(url);


			try {
				huc = (HttpURLConnection)(new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if(respCode >= 400){
					System.out.println(url+" is a broken link");
				}
				else{
					System.out.println(url+" is a valid link");
				}

			}
			catch (MalformedURLException e) {
				e.printStackTrace();
				} catch (IOException e) {
				e.printStackTrace();
				}
		}
	}
	
}
		
