package eShipslogin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ForwardShipment {
	@Test
	public void createShipmentForward() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://qa-eshipz.herokuapp.com/");
		driver.findElement(By.id("email")).sendKeys("automation@eshipz.com");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.id("login-submit")).click();
		if(driver.getTitle().contains("eShipz")) {
			System.out.println("My HomePage is displayed..");
		}else {
			System.out.println("HomePage is not displayed..");	
		}
		WebElement createShipment = driver.findElement(By.xpath("(//a[contains(text(),'Create Shipment')])"));
		Actions builder = new Actions(driver);
		builder.moveToElement(createShipment).perform();
		driver.findElement(By.linkText("Forward")).click();
		WebElement senderPincode = driver.findElement(By.id("sender_pincode"));
		senderPincode.clear();
		senderPincode.sendKeys("560001");
		WebElement ReceiverAddress = driver.findElement(By.xpath("//select[@title='Please Select Receiver Warehouse']"));
		Select obj = new Select(ReceiverAddress);
		obj.selectByIndex(1);
		driver.findElement(By.xpath("//label[text()[normalize-space()='Is Return Address Different from Shipper Address']]")).click();
		WebElement RTOAddress = driver.findElement(By.xpath("//select[@title='Please Select RTO Warehouse']"));
		Select obj1 = new Select(RTOAddress);
		obj1.selectByIndex(1);
		driver.findElement(By.id("receiver_name")).sendKeys("Ram");
		driver.findElement(By.xpath("(//input[@id='company_name'])[2]")).sendKeys("TCS");
		driver.findElement(By.id("receiver_street1")).sendKeys("Address Line1");
		driver.findElement(By.id("receiver_city")).sendKeys("Bangalore");
		WebElement receiverCountry = driver.findElement(By.xpath("//select[@ng-change='countrySelect(order.shipment.country,order)']"));
		Select obj2 = new Select(receiverCountry);
		obj2.selectByVisibleText("India");
		WebElement receiverState = driver.findElement(By.xpath("(//input[@placeholder='Enter State name'])[2]"));
		receiverState.clear();
		receiverState.sendKeys("KA");
		WebElement receiverPincode = driver.findElement(By.id("receiver_pincode"));
		receiverPincode.clear();
		receiverPincode.sendKeys("400001");
		WebElement receiverPhnNum = driver.findElement(By.id("receiver_phone"));
		receiverPhnNum.clear();
		receiverPhnNum.sendKeys("8787878787");
		driver.findElement(By.xpath("(//input[@id='sender_name'])[2]")).sendKeys("Sudheera");
		driver.findElement(By.xpath("(//input[@id='sender_street1'])[2]")).sendKeys("Address Line 3");
		driver.findElement(By.xpath("(//input[@id='sender_city'])[2]")).sendKeys("Bombay");
		WebElement RTOCountryCode = driver.findElement(By.xpath("//select[@ng-change='RtocountrySelect(order.shipment.return_to_country,order)']"));
		Select obj3 = new Select(RTOCountryCode);
		obj3.selectByVisibleText("India");
		WebElement RTOstate = driver.findElement(By.xpath("(//label[text()='Country'])[3]/following::input"));
		RTOstate.clear();
		RTOstate.sendKeys("MH");
		driver.findElement(By.xpath("(//input[@id='sender_pincode'])[2]")).sendKeys("411044");
		WebElement senderPhnNum = driver.findElement(By.xpath("(//input[@id='sender_phone'])[2]"));
		senderPhnNum.clear();
		senderPhnNum.sendKeys("6767676767");
		driver.findElement(By.xpath("(//input[@id='sender_email'])[2]")).sendKeys("abcd@gmail.com");
		WebElement RTOAddressType = driver.findElement(By.xpath("//select[@ng-model='order.shipment.return_to.type']"));
		Select obj4 = new Select(RTOAddressType);
		obj4.selectByIndex(1);	
		driver.findElement(By.id("customer_ref")).sendKeys("2456245");
		
		WebElement shipmentType = driver.findElement(By.xpath("//select[@ng-model='order.is_document']"));
		Select obj5 = new Select(shipmentType);
		obj5.selectByVisibleText("Document");
		WebElement courierPurpose = driver.findElement(By.xpath("//select[@ng-model='order.shipment.courier_purpose']"));
		Select obj6 = new Select(courierPurpose);
		obj6.selectByVisibleText("Personal");
		driver.findElement(By.xpath("//button[text()[normalize-space()='Fetch Services']]")).click();
		WebElement courierService = driver.findElement(By.xpath("//select[@ng-model='selectedService']"));
		courierService.click();
		Select obj7 = new Select(courierService);
		obj7.selectByIndex(1);
		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		//driver.findElement(By.xpath("//i[text()='exit_to_app']")).click();
			
	}

}
