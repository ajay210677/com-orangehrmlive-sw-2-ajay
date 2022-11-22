package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


    public class LoginTest extends BaseTest {
        String baseURL = "https://opensource-demo.orangehrmlive.com/";

        @Before
        public void setUp() {
            openBrowser(baseURL);
        }

        @Test
        public void userShouldLoginSuccessfullyWithValidCredentials() {
            //Search username and enter in field
            driver.findElement(By.name("username")).sendKeys("Admin");

            //Search password and enter in field
            driver.findElement(By.name("password")).sendKeys("admin123");

            // login button and click
            driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();

            //Verify dashboard text after login
            String expectedMessage = "Dashboard";

            // Log out text element and get the text
            WebElement actualTextMessageElement = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
            String actualMessage = actualTextMessageElement.getText();

            //Validate actual and expected
            Assert.assertEquals("Text message not found", expectedMessage, actualMessage);
        }

        @After
        public void tearDown() {
           // closeBrowser();
        }

}
