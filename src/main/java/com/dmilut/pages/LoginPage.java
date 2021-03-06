package com.dmilut.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "passp-field-login")
    private WebElement loginField;

    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
    private WebElement loginButton;

    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    private WebElement passwordField;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPassword(String passwd) {
        passwordField.sendKeys(passwd);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}


