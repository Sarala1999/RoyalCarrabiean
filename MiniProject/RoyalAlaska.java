package MiniProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
public class RoyalAlaska {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String presence;
		String presence1;
		String presence2;
		System.setProperty("webdriver.chrome.driver","C:\\Users\\2095388\\Downloads\\chromedriver_win32\\chromedriver.exe");
			
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		driver.get(" https://www.royalcaribbean.com/alaska-cruises ");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		driver.findElement(By.className("email-capture__close"));
		driver.findElement(By.className("email-capture__close")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		if (driver.findElement(By.linkText("Holiday Cruises")) != null)
			presence2 = "pass";

		else
			presence2 = "fail";

		System.out.println("Holiday Cruises displays:" + presence2);
		if (presence2 == "pass")

			driver.findElement(By.linkText("Holiday Cruises")).click();

		/*
		driver.findElement(By.linkText("Holiday Cruises"));
		driver.findElement(By.linkText("Holiday Cruises")).click();*/
		
		driver.findElement(By.xpath("//*[@id=\"rciSearchHeaderIcon\"]"));
		driver.findElement(By.xpath("//*[@id=\"rciSearchHeaderIcon\"]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"rciSearchInput\"]")).sendKeys("Rhapsody of the Seas");
		driver.findElement(By.xpath("//*[@id=\"rciSearchInputIcon\"]")).click();
		
		String[] results = driver.findElement(By.xpath("//*[@id=\"siteSearchApp\"]/div[1]/div/div[2]/div"))
				.getText().split(" ");
		String f = results[1];
		String v = "";

		for (int i = 0; i < f.length(); i++) {
			if (f.charAt(i) == ',') {
				continue;
			} else {
				v += f.charAt(i);
			}
		}

		if (Integer.parseInt(v) > 300000)
			System.out.println("Search Results is greater than 300000");
		else
			System.out.println("Search Results is lesser than 300000");
		
		/*
		 * Find and click on
		 * "Deck Plans | Rhapsody of the Seas | Royal Caribbean Cruises" in the search
		 * result. Check for the Deck plan image. If the image displays, print status as
		 * Pass otherwise Fail. */
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Deck Plans | Rhapsody of the Seas | Royal Caribbean Cruises')]")).click();
		
		if (driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/img[1]")) != null)
			presence = "pass";
		else
			presence = "fail";
		System.out.println("Deck plan image displays:" + presence);

		
	/*	Select View as Deck Eight. Check the presence of Royal
		 * Suite, if it presents print the status as Pass otherwise Fail.
		 */
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"deckDropdown\"]/option[7]")).click();
		
		if (driver.findElement(By.xpath("//*[@id=\"deck-plans-template\"]/section/section[2]/section[1]/div[2]/section[5]/h4")) != null) 
		{
				presence1= "pass";
		}

		else
			presence1 = "fail";
		System.out.println("presence of Royal Suite:" + presence1);
		
		driver.close();
	}

}
