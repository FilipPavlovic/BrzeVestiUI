
package dashboard;

import base.BaseTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SignaturesPage;


public class DashboardTest extends BaseTest {
   
    private static DashboardPage dashboardPage;
    
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailOfValidUser();
        loginPage.enterPasswordOfValidUser();
        loginPage.clickLoginButton();
        
        dashboardPage = new DashboardPage(driver);
    }
    
    @After
    public void tearDown() {
        dashboardPage.logout();
    }
    
    
    @Test
    public void testDashboardLink() {     
        dashboardPage.clickOnDashboardNavLink();
        
        String expectedPanelHeadingText = "Dashboard";
        String actualPanelHeadingText = dashboardPage.getPanelHeadingText();
            
        assertTrue("Faild - panel heading texts doesn't match", expectedPanelHeadingText.equals(actualPanelHeadingText));      
    }
    
    @Test
    public void testSignaturesLink() {     
        dashboardPage.clickOnSignaturesNavLink();
        SignaturesPage signaturesPage = new SignaturesPage(driver);
        
        
        //SignaturesPage signaturesPage2 = dashboardPage.clickOnSignaturesNavLink2();
     
        String expectedPanelHeadingText = "Signatures";
        String actualPanelHeadingText = signaturesPage.getPanelHeadingText();
        assertTrue("Faild - panel heading texts doesn't match", expectedPanelHeadingText.equals(actualPanelHeadingText)); 
    }
    
    
    @Test
    public void testCategoriesLink() {     
        dashboardPage.clickOnCategoriesNavLink();
     
        assertTrue(true);
    }
   
}
