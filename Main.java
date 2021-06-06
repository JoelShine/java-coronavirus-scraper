package joel.selenium;

import java.util.*;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hello_world {

public static void main(String[]args) throws InterruptedException{
	System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
    options.setHeadless(true);

	WebDriver driver=new ChromeDriver(options);

	driver.get("https://www.worldometers.info/coronavirus/");
	//driver.manage().window().maximize();
	
	//Thread.sleep(5000);
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
	String covid_world_cases = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div/div[4]/div/span")).getText();
	System.out.println("Total world wide covid cases = "+covid_world_cases);
	
	String covid_world_death = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div/div[6]/div/span")).getText();
	System.out.println("Total world wide covid deaths = "+covid_world_death);
	
	String covid_world_recovery = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div/div[7]/div/span")).getText();
	System.out.println("Total covid cases recovered worldwide = "+covid_world_recovery);
	
	do {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Please input the country you want for the information (Type exit to quit) - ");
		
		String country=sc.nextLine();
		if (country.contains("exit")) {
			System.out.println("Thank You for using corona web scraper !");
			System.exit(0);
		}
		else {
			driver.get("https://www.worldometers.info/coronavirus/country/"+country);
			
			String covid_cases = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div/div[4]/div/span")).getText();
			System.out.println("Total covid cases in "+country+" = "+covid_cases);
			
			String covid_death = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div/div[6]/div/span")).getText();
			System.out.println("Total covid deaths in "+country+" = "+covid_death);
			
			String covid_recovery = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div/div[6]/div/span")).getText();
			System.out.println("Total covid cases recovered in "+country+" = "+covid_recovery);
		}
		
	}while(true);
	}

}
