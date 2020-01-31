package wetransfer.wetransfer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class WeTransferHomePage
{
	  WebDriver driver = null;
	
			 
	@Given("Open home page")
		public void open_Home_page(DataTable dt)  {  
		System.out.println("------------");
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\manju.bala\\Gecko\\geckodriver.exe");
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\manju.bala\\Gecko\\chromedriver.exe");
    	List<String> list = dt.asList(String.class);
    	String browser = list.get(0);
    	if(browser.equalsIgnoreCase("chrome")) {
    		driver = new ChromeDriver();
        } 
    	else if(browser.equalsIgnoreCase("firefox")) {
        	driver = new FirefoxDriver();
    	}
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(list.get(1));
       
        
    }
		
	@When("click on upload")
    public void click_on_upload(DataTable da) {
        WebElement agreeButton = driver.findElement(By.xpath("//button[@type='button'][contains(.,'I agree')]"));
        agreeButton.click();
        WebElement emailTo = driver.findElement(By.xpath("//input[@name='autosuggest']"));
        List<String> list = da.asList(String.class);
        emailTo.sendKeys(list.get(0));
        WebElement yourEmail = driver.findElement(By.xpath("//input[@name='email']"));
        yourEmail.sendKeys(list.get(1));
        WebElement textMessage = driver.findElement(By.xpath("//textarea[@class='textarea__field']"));
        textMessage.sendKeys(list.get(2));
        
    }
    
    
    @When("file uploaded")
    public void file_uploaded() throws AWTException, InterruptedException  {
    	WebElement upload = driver.findElement(By.xpath("//h2[contains(.,'Add your files')]"));
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("arguments[0].click();", upload);
    	Thread.sleep(1500);
    	StringSelection ss = new StringSelection("D:\\ManjuBala\\Docsss\\110-fisted-hand-sign.png");
    	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
    	
    	Robot robot = new Robot();

    	robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(500);
    	robot.keyPress(KeyEvent.VK_V);
    	 Thread.sleep(500);
    	robot.keyRelease(KeyEvent.VK_V);
    	 Thread.sleep(500);
    	robot.keyRelease(KeyEvent.VK_CONTROL);
    	 Thread.sleep(1000);

    	robot.keyPress(KeyEvent.VK_ENTER);
    	 Thread.sleep(500);
    	robot.keyRelease(KeyEvent.VK_ENTER);
    	 Thread.sleep(500);
         WebElement transferButton = driver.findElement(By.cssSelector(".transfer__button"));
         Thread.sleep(500);
         
         jse.executeScript("arguments[0].click();", transferButton);
         Thread.sleep(2000);
           WebElement verifyText = driver.findElement(By.xpath("//h2[@class='email-verification__title']/following-sibling::p[1]"));
        String verification = verifyText.getText();
        System.out.println(verification);
        verification.contains("Just one quick check to make sure you’re really you. We’ve sent a verification code to manju.ostwal88@gmail.com");
        Assert.assertEquals("verify text adter upload file", "Just one quick check to make sure you’re really you. We’ve sent a verification code to" + "\n" +
        		 "manju.ostwal5@gmail.com", verification);
       
        
    }
    
    @Then("Email code verification")
    public void Email_code_verification(DataTable da) throws InterruptedException {
    	List<String> list = da.asList(String.class);
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1)); //switches to new tab
	    driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin\"");
	    driver.findElement(By.id("identifierId")).sendKeys(list.get(0));
	    Thread.sleep(3000);
	    driver.findElement(By.className("CwaK9")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(list.get(1));
	    driver.findElement(By.className("CwaK9")).click(); 
	    Thread.sleep(3000);
	    List<WebElement> unreademail = driver.findElements(By.className("zE"));
	    System.out.println("Total No. of Unread Mails: " + unreademail.size());

	    //  logic starts here to get email

	    for(int i=0;i<unreademail.size();i++){

	    System.out.println(unreademail.get(i).getText());
	    
	    }
	    String code = unreademail.get(0).getText();
	    driver.switchTo().window(tabs.get(0)); // switch back to main screen   
	    Thread.sleep(3000);
	    //enter code received in mail
	    driver.findElement(By.xpath("//input[@name='verification-code']")).sendKeys(code);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@type='submit']"));
	    driver.quit(); 
        
             
    
    
        }
}
