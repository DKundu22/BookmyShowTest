package com.Bookmyshow.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com.Base.Base;

public class MovieLanguages extends Base{
	//POM for extracting movie and their languages 
	By movies=By.xpath("//a[text()='Movies']");
	By name=By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div/div/div/div/div[2]/a/div/div[3]/div[1]/div");
	By lang=By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div/div/div/div[2]/a/div/div/div[3]/div");

	// Extract all the languages for movies
    @Test(priority =3)
	public void movie() throws InterruptedException {
		exttest = report.createTest("Extract languages for movies. ");
		wait(30, movies);
		//selecting the movies button
		driver.findElement(movies).click();
		//store the movie and movie languages in list
		List<WebElement> langs=driver.findElements(lang);
		List<WebElement> names=driver.findElements(name);
		for(int j=0;j<names.size();++j){
			System.out.println(names.get(j).getText()+" - "+langs.get(j).getText());
		}
		exttest.log(Status.PASS, "Languages are extracted Successfully for different movies");
		Thread.sleep(3000);
	}
}