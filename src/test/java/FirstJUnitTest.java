

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import framework.Helper;



public class FirstJUnitTest {
    
    private static WebDriver driver;
    
    public FirstJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
         //Initialize driver
        driver = new ChromeDriver();
        
        
        //Maximize Chrome browser
        driver.manage().window().maximize();
        
        // Test step 1: Go to URL
        driver.get("http://bvtest.school.cubes.rs/login");
        
        
        // Test step 2: Enter email in email field
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("qa@cubes.rs");
        
        // Test step 3: Enter password in password field
        WebElement passwodField = driver.findElement(By.name("password"));
        passwodField.sendKeys("cubesqa");
        
        
        //Test step 4: Click on login button
        WebElement loginButton = driver.findElement(By.className("btn-primary"));
        loginButton.click();
    }
    
    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }
    
    @Before
    public void setUp() {
        System.out.println("Hi, I'm setUp method");
    }
    
    @After
    public void tearDown() {
        System.out.println("Hi, I'm tearDown method");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
        System.out.println("Hi, I'm hello method");
     }
     
     
     @Test
     public void TestLogin() {
         System.out.println("Hi, I'm testLogin method");
              
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();
        
        
         assertEquals("Url's doesn't match.", expectedUrl, actualUrl);
        
     }

     @Test
     public void testAddNewCattegory() {
            System.out.println("Hi, I'm testAddNewCattegory method");
            
  
        //Test case: add new category
        
        //Test step 1: Go to categories page 
        WebElement categoriesLink = driver.findElement(By.linkText("Categories"));
        categoriesLink.click();
        
        //Test step 2: Click on 'Add category' button
        WebElement addCategoryLink = driver.findElement(By.className("pull-right"));
        addCategoryLink.click();
        
                
        //Test step 3: Enter title in title field
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.sendKeys(Helper.getRandomText());
        
        
        
        //Test step 4: Click on save button
        WebElement saveButton = driver.findElement(By.id("save-category-button"));
        saveButton.click();
        
        
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: #" + driver.getCurrentUrl() + "#");
        
        
        String expectedURL = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        
         assertEquals("Url's does not match.", expectedURL, actualUrl);
         
         String expectedMessageSnippet = "Filip-";
         WebElement alertMessageElement = driver.findElement(By.className("alert-success")); 
         String alertMessageText = alertMessageElement.getText();
         
         
         assertTrue("Alert message doen't contain expected string", alertMessageText.contains(expectedMessageSnippet));
       
        
        

     }
     
}
