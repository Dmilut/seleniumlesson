package com.dmilut;

import com.dmilut.pages.LoginPage;
import com.dmilut.pages.ProfilePage;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.dmilut.util.PropertiesManager.getProperty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class LoginTest {

    public static Logger log = Logger.getLogger(LoginTest.class);

    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(getProperty("loginpage"));
        log.info("Application launched");
    }

    @Test
    @Disabled
    public void loginPageIsLoaded() {

        assertNotNull(driver.getTitle());
    }

    @Test
    public void loginTest() {
        loginPage.inputLogin(getProperty("login"));
        loginPage.clickLoginButton();
        loginPage.inputPassword(getProperty("password"));
        loginPage.clickLoginButton();

        assertEquals(getProperty("login"), profilePage.getUserName());
    }

    @Test
    @Disabled
    public void loginTest1() {
        WebElement loginField = driver.findElement(By.id("passp-field-login"));
        loginField.sendKeys("login");
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div[2]/div[3]/div/div/div[1]/form/div[3]/button"));

        loginBtn.click();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}

