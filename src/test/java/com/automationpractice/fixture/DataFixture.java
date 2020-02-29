package com.automationpractice.fixture;

import com.automationpractice.pageobject.MainPage;
import com.automationpractice.pageobject.MyAccountPage;
import com.automationpractice.pageobject.ShoppingCartPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfigurationStrategy;

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
        Configuration.baseUrl = startPageUrl;
        Configuration.remote = "http://localhost:4444/wd/hub/";
//        Configuration.browser = "chrome";
        Configuration.browser = "internet explorer";
        Configuration.browserSize = "1920x1080";
//        Configuration.browserVersion = "80.0.3987.106";
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setBrowserName("chrome");
//        capabilities.setVersion("80.0.3987.106");
//        capabilities.setPlatform(Platform.ANY);
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//        Configuration.browserCapabilities = capabilities;
        open("");
    }

    @AfterEach
    public void afterTest(){
        WebDriverRunner.closeWindow();
    }
}
