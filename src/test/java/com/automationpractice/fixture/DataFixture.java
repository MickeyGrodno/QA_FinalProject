package com.automationpractice.fixture;

import com.automationpractice.pageobject.MainPage;
import com.automationpractice.pageobject.MyAccountPage;
import com.automationpractice.pageobject.ShoppingCartPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfigurationStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
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
    public void beforeTest() {

        Configuration.baseUrl = startPageUrl;
        Configuration.browser = "chrome";
        Configuration.headless = true;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setAcceptInsecureCerts(false);
        Configuration.remote = "http://localhost:4444/wd/hub/";
        Configuration.browserCapabilities = capabilities;

//        Configuration.browser = "chrome";

        open(startPageUrl);
    }

    @AfterEach
    public void afterTest(){
        WebDriverRunner.closeWindow();
    }
}
