
package login;

import org.junit.Test;
import base.BaseTest;
import com.sun.source.tree.AssertTree;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import pages.LoginPage;


public class LoginTests extends BaseTest {
    
    private boolean loggedIn = false;
    
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        
        driver.get("http://bvtest.school.cubes.rs/login");
        
    }

    @Test
    public void testValidLogin() {      
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
      
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();      
        assertEquals("Url's doesn't match.", expectedUrl, actualUrl);
        
        
        DashboardPage  dashboardPage = new DashboardPage(driver);
        String expectedPanelHeadingText = "Dashboard";
        String actualPanelHeadingText = dashboardPage.getPanelHeadingText();
            
        assertTrue("Faild - panel heading texts doesn't match", expectedPanelHeadingText.equals(actualPanelHeadingText));
        
        dashboardPage.logout();
        
        
        
    }  
    
                     
    @Test
    public void testEmptyFieldsLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        
        
        String expectedUrl = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();       
        assertEquals("Url's doesn't match.", expectedUrl, actualUrl);
        
        String expectedEmailMessage = "The email field is required.";
        String actualEmailMessage = loginPage.getEmailMessaageText();
        Assert.assertTrue("Failed - Email message's doens't match", expectedEmailMessage.equals(actualEmailMessage));
        
       
       
    }
        
    
    @Test
    public void testInvalidEmailInvalidPasswordLogin() {
        LoginPage loginPage = new LoginPage(driver);      
        loginPage.enterEmailOfNonExistingUser();
        loginPage.enterPasswordOfNonExistingUser();
        loginPage.clickLoginButton();      
        // 1. Enter invalid email in Email Field  
        // 2. Enter invalid password in Password Field
        // 3. Click on Login Button
        // Exspected result: not looged in, message shown
        
        String expectedUrl = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();       
        assertEquals("Url's doesn't match.", expectedUrl, actualUrl);
        
        String expectedEmailMessage = "These credentials do not match our records.";
        String actualEmailMessage = loginPage.getEmailMessaageText();
        Assert.assertTrue("Failed - Email message's doens't match", expectedEmailMessage.equals(actualEmailMessage));
        
      
    
    }
    
 
    @Test
    public void testValidEmailInvalidPasswordLogin() {
        LoginPage loginPage = new LoginPage(driver); 
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfNonExistingUser();
        loginPage.clickLoginButton();
        // 1. Enter valid email in Email Field
        // 2. Enter invalid password in Password Field
        // 3. Click on Login Button
        // Exspected result: not looged in, message shown
        
        String expectedUrl = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();       
        assertEquals("Url's doesn't match.", expectedUrl, actualUrl);
        
        String expectedEmailMessage = "These credentials do not match our records.";
        String actualEmailMessage = loginPage.getEmailMessaageText();
        Assert.assertTrue("Failed - Email message's doens't match", expectedEmailMessage.equals(actualEmailMessage));
    
    }
    
    
    @Test
    public void testInvalidEmailValidPasswordLogin() {
        LoginPage loginPage = new LoginPage(driver); 
        loginPage.enterEmailOfNonExistingUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        // 1. Enter invalid email in Email Field
        // 2. Enter valid password in Password Field
        // 3. Click on Login Button
        // Exspected result: not looged in, message shown
        
        String expectedUrl = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();       
        assertEquals("Url's doesn't match.", expectedUrl, actualUrl);
        
        String expectedEmailMessage = "These credentials do not match our records.";
        String actualEmailMessage = loginPage.getEmailMessaageText();
        Assert.assertTrue("Failed - Email message's doens't match", expectedEmailMessage.equals(actualEmailMessage));       
    }
        
     @Test
     public void testCustomDataLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("Hello@filip.rs");
        loginPage.enterPassword("123456");
        loginPage.clickLoginButton();
     }
     
     
     @Test
     public void testValidEmailEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.clickLoginButton();
        
        
        
        String expectedPasswordMessage = "The password field is required.";
        String actualPasswordMessage = loginPage.getPasswordMesageText();
        Assert.assertTrue("Failed - Password message's doens't match", expectedPasswordMessage.equals(actualPasswordMessage));
        
        
     }
     
     
     @Test
     public void testEmptyEmailValidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        String expectedEmailMessage = "The email field is required.";
        String actualEmailMessage = loginPage.getEmailMessaageText();
        Assert.assertTrue("Failed - Email message's doens't match", expectedEmailMessage.equals(actualEmailMessage));
        
     }
     
     
     @Test
     public void  testEmptyEmailInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterPasswordOfNonExistingUser();
        loginPage.clickLoginButton();
        
        String expectedEmailMessage = "The email field is required.";
        String actualEmailMessage = loginPage.getEmailMessaageText();
        Assert.assertTrue("Failed - Email message's doens't match", expectedEmailMessage.equals(actualEmailMessage));
        
     }
    
    
}
