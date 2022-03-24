package selenium;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
  

    private WebDriver driver;
   // WebDriverWait wait = new WebDriverWait(driver, 10);
    JavascriptExecutor js;

    
    @Before
    public void setUp(){
        System.out.println("seteando ");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


  
    
    /*
    public static ChromeOptions options = new ChromeOptions();
    public static WebDriver driver = new ChromeDriver(options);
    JavascriptExecutor js;
    */ 

    /*
    @Before
    public void setUp(){
        System.out.println("seteando ");
        options.addArguments("--headless");
        options.addArguments("--whitelisted-ips");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size=1024,768");
        System.out.println("Iniciando configuración...");

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.whitelistedIps", "");
        
        WebDriverManager.chromedriver().setup();
        
        driver.manage().window().maximize();
    }
    */


    /*
        {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender1")));
        }
        driver.findElement(By.id("id_gender1")).click();
    */

    
   // @Test
    public void google() {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).click();
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("handbook devops");
        searchbox.submit();
        try {
            Thread.sleep(1000);
            driver.findElement(By.linkText("Shopping")).click();
            Thread.sleep(1000);
            WebElement resultGrid = driver.findElement(By.className("op4oU"));
            WebElement theBook = resultGrid.findElement(By.cssSelector("div:first-child"));
            theBook.click();
        }catch(Exception e) {
            System.out.println(e);
        }
    }
      
    //@Test
    public void amazon() {
      driver.get("https://www.amazon.com/");
      driver.findElement(By.id("navFooter")).click();
      driver.findElement(By.cssSelector(".navFooterBackToTopText")).click();
      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("the phonix project");
      driver.findElement(By.id("nav-search-submit-button")).click();
    }

    @Test
    public void automationpractice() {
        driver.get("http://automationpractice.com/index.php");
        SimpleDateFormat formatter= new SimpleDateFormat("HHmm");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));

        String correo = "correo"+formatter.format(date)+"@gmail.com";
        
        try {
            Thread.sleep(1000);
         //   driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[3]/div/div[1]/div/a[1]")).click();
         
            driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[3]/div/div[2]/h5/a")).click();                         
            Thread.sleep(1000);
            WebElement contenedor_boton = driver.findElement(By.id("add_to_cart"));
            contenedor_boton.findElement(By.tagName("button")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]")).click();
            Thread.sleep(2000);
            WebElement email_input = driver.findElement(By.id("email_create"));
            email_input.sendKeys(correo);
            email_input.submit();
            Thread.sleep(2000);
            WebElement email_validate = driver.findElement(By.id("email"));

          //  String correoValidar =  email_validate.getText();

          
            String correoValidar = email_validate.getAttribute("value");

            System.out.println(" correoValidar" +  correoValidar);
            assertEquals(correo, correoValidar);

            Thread.sleep(3000);

            WebElement customer_firstname = driver.findElement(By.id("customer_firstname"));
            customer_firstname.sendKeys("pedro");

            WebElement customer_lastname = driver.findElement(By.id("customer_lastname"));
            customer_lastname.sendKeys("dias");
           
            WebElement passwd = driver.findElement(By.id("passwd"));
            passwd.sendKeys("12325oiyH_21");

            WebElement company = driver.findElement(By.id("company"));
            company.sendKeys("sin compañia");

            WebElement address1 = driver.findElement(By.id("address1"));
            address1.sendKeys("avenida siempre viva 123");

            WebElement address2 = driver.findElement(By.id("address2"));
            address2.sendKeys("dirección referencia 2");

            WebElement city = driver.findElement(By.id("city"));
            city.sendKeys("Santiago");
            
            WebElement postcode = driver.findElement(By.id("postcode"));
            postcode.sendKeys("92547");

            WebElement other = driver.findElement(By.id("other"));
            other.sendKeys("sin información adicional");

            WebElement phone = driver.findElement(By.id("phone"));
            phone.sendKeys("12345678");

            WebElement phone_mobile = driver.findElement(By.id("phone_mobile"));
            phone_mobile.sendKeys("912345678");

            
            WebElement alias = driver.findElement(By.id("alias"));
            alias.sendKeys("Sin referencia");


            Select dropdown = new Select(driver.findElement(By.id("id_state")));
            dropdown.selectByIndex(1);


            Select days = new Select(driver.findElement(By.id("days")));
            days.selectByIndex(1);

            Select months = new Select(driver.findElement(By.id("months")));
            months.selectByIndex(1);

            Select years = new Select(driver.findElement(By.id("years")));
            years.selectByIndex(1);
            
            Thread.sleep(2000);
            driver.findElement(By.id("submitAccount")).click();
          
            // PENDIENTE QUE LOS DATOS SEAN LOS MISMOS EN DIRECCIÓN

            Thread.sleep(2000);
            driver.findElement(By.name("processAddress")).click();

            Thread.sleep(2000);
            driver.findElement(By.id("cgv")).click();
            driver.findElement(By.name("processCarrier")).click();
    
            Thread.sleep(2000);
            driver.findElement(By.className("bankwire")).click();


            Thread.sleep(2000);
          //  driver.findElement(By.className("button btn btn-default button-medium")).click();
            driver.findElement(By.xpath("    /html/body/div/div[2]/div/div[3]/div/form/p/button")).click();


            // set de pruebas

            Thread.sleep(1000);
            System.out.println("correo : " + correo);
            System.out.println(" correoValidar" +  correoValidar);
            assertEquals(correo, correoValidar);
        
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }

}
