
package pages;

import framework.Configuration;
import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage {
    
    private WebDriver driver;
    private final By emailFieldLocator = By.name("email");
    private final By passwordFieldLocator = By.name("password"); 
    private final By remembermeCheckBoxLocator = By.name("remember");
    private final By LoginButtonLocator = By.className("btn-primary");
    private final By InvalidEmailInvalidPasswordLogin = By.className("btn btn-primary");
    private final By EmailMessageLocator = By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[1]/div/span/strong");
    private final By PasswordMessageLocator = By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[2]/div/span/strong");
    private final By EmailMessageBlock = By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[1]/div/span/strong");
    private final By EmailMessageAttention = By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[1]/div/span/strong");
    
    
    
    

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    

    
    public void enterEmailOfValidUser() {
       driver.findElement (emailFieldLocator).sendKeys(Configuration.validAdminUserEmail);
       
    }
    
    public void enterEmailOfNonExistingUser() {
       driver.findElement (emailFieldLocator).sendKeys(Helper.getRandomEmail());
    }
   
    public void enterEmail(String email) {
        driver.findElement (emailFieldLocator).sendKeys(email);
    }
    
    
    public void enterPasswordOfValidUser() {
       driver.findElement (passwordFieldLocator).sendKeys(Configuration.validAdminUserPassword);
    }    
    
    public void enterPasswordOfNonExistingUser() {
       driver.findElement (passwordFieldLocator).sendKeys(Helper.getRandomText());
    }
    
    public void enterPassword(String password) {
       driver.findElement (passwordFieldLocator).sendKeys(password);
    }
        
    public void clickOnRememberMe() {
       driver.findElement(remembermeCheckBoxLocator).click();
    }
 
    public void clickLoginButton() {
       driver.findElement(LoginButtonLocator).click();
    }
    
   
    public String getEmailMessaageText() {
       return driver.findElement(EmailMessageLocator).getText();
       
    }
    
    public String getPasswordMesageText() {
       return driver.findElement(PasswordMessageLocator).getText();
    }
    
    
    public String getEmailMessageText() {
        return driver.findElement(EmailMessageBlock).getText();
    }  
    
    
    public String getEmailMessageTx() {
        return driver.findElement(EmailMessageAttention).getText();
    }
        
  }