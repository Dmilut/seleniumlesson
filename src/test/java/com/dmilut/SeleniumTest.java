package com.dmilut;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class SeleniumTest {

    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://passport.yandex.ru/auth");
    }

    @Test
    public void loginPageIsLoaded() {

        assertNotNull(driver.getTitle());

    }


    @Test
    @Disabled
    public void loginTest() {

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

