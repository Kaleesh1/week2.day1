package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLeadAssign2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();	
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("F1");		
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Charles");		
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Lec");	
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Charlie");	
		driver.findElement(By.name("departmentName")).sendKeys("Engineering");
		driver.findElement(By.id("createLeadForm_description")).sendKeys(" Marc Hervé Perceval Leclerc a Monégasque racing driver"
				+ "\n"
				+ "With Sauber having finished last Leclerc led the charge to improve its finishing position in the constructors' championship to eighth, and was the higher ranked of the two Sauber drivers. ");	
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("Charls@libertymedia.com");
		WebElement stateProv = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dropdwn = new Select(stateProv);
		dropdwn.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		String title = driver.getTitle();
		System.out.println("After initial lead creation:  "+title);
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Formula");		
		driver.findElement(By.id("createLeadForm_firstName")).clear();		
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Sebastian");		
		driver.findElement(By.name("submitButton")).click();
		String title1 = driver.getTitle();
		System.out.println("After Update: "+title1);
	}

}
