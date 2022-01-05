package com.Bookmyshow.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com.Base.Base;

public class FIndSports extends Base{
	By cancel=By.id("wzrk-cancel");
	By city=By.xpath("//span[text()='Kolkata']");
	By sport=By.xpath("//a[text()='Sports']");
	By weekend=By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div/div");
	By name=By.xpath("//*[@id='super-container']/div[2]/div[4]/div[2]/div/div/div/div/a/div/div[3]/div[1]/div");
	By price=By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div/div/div/div/a/div/div[3]/div[4]/div");
    By priceSelection= By.xpath("(//div[normalize-space()='Price'])[1]");
	By zeroToFivehundred = By.xpath("(//div[contains(text(),'0 - 500')])[2]");
	
    @Test(priority =2)
	public void sports() throws InterruptedException {
		exttest = report.createTest("Display sports activities. ");
		wait(30, cancel);
		driver.findElement(cancel).click();
		driver.findElement(city).click();
		driver.findElement(sport).click();
		wait(30, weekend);
		driver.findElement(weekend).click();
		exttest.log(Status.PASS, "Weekend selected Successfully");
		wait(30, priceSelection);
		driver.findElement(priceSelection).click();
		wait(30, zeroToFivehundred);
		driver.findElement(zeroToFivehundred).click();
		exttest.log(Status.PASS, "Zero to five hundred selected successfully");
		List<WebElement> names=driver.findElements(name);
		List<WebElement> prices=driver.findElements(price);
		for(int j=0;j<names.size();++j){
			System.out.println(names.get(j).getText()+" - "+prices.get(j).getText());
		}
		exttest.log(Status.PASS, "Sport activities are displayed Successfully");
		Thread.sleep(3000);
	}
}
