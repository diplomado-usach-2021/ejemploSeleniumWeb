package selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    private WebDriver driver;
    JavascriptExecutor js;

    @Before
    public void setUp(){
        System.out.println("seteando ");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void google() {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).click();
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("handbook devops");
        searchbox.submit();
        driver.findElement(By.linkText("Shopping")).click();
        WebElement resultGrid = driver.findElement(By.className("op4oU"));
        WebElement theBook = resultGrid.findElement(By.cssSelector("div:first-child"));
        theBook.click();
    }
      
    @Test
    public void amazon() {
      driver.get("https://www.amazon.com/");
      driver.findElement(By.id("navFooter")).click();
      driver.findElement(By.cssSelector(".navFooterBackToTopText")).click();
      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("the phonix project");
      driver.findElement(By.id("nav-search-submit-button")).click();
    }
}
