package com.automationpractice.fixture;

import com.automationpractice.pageobject.MainPage;
import com.automationpractice.pageobject.MyAccountPage;
import com.automationpractice.pageobject.ShoppingCartPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.open;


public class DataFixture {
    protected String correctEmail = "Sergei199@list.ru";
    protected String correctPassword = "11111";
    protected String startPageUrl = "http://automationpractice.com/index.php";
    protected String myAccountPageUrl = "http://automationpractice.com/index.php?controller=my-account";
    protected MainPage mainPage = new MainPage();
    protected MyAccountPage myAccountPage = new MyAccountPage();
    protected ShoppingCartPage shoppingCartPage = new ShoppingCartPage();


    @BeforeEach
    public void beforeTest() throws MalformedURLException, MalformedURLException {
//        Configuration.holdBrowserOpen = true;
//        Configuration.baseUrl = startPageUrl;
        Configuration.remote = "http://localhost:4444/wd/hub/";
//        Configuration.browserSize = "1920х1080";
        Configuration.browser = "chrome";
//        Configuration.browserVersion = "80.0.3987.106";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("80.0.3987.106");
        capabilities.setPlatform(Platform.ANY);
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
//        WebDriverRunner.setWebDriver(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities));
        open(startPageUrl);
    }

    @AfterEach
    public void afterTest(){
        WebDriverRunner.closeWindow();
    }
}
