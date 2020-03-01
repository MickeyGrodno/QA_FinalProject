package com.automationpractice.fixture;

import com.automationpractice.pageobject.MainPage;
import com.automationpractice.pageobject.MyAccountPage;
import com.automationpractice.pageobject.ShoppingCartPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;

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
        capabilities.setCapability("enableVideo", true);
//        capabilities.setCapability("enableVNC", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "http://localhost:4444/wd/hub/";

        open(startPageUrl);
    }

    @Attachment(value = "Video HTML", type = "text/html", fileExtension = ".html")
    public static String videoInHtml(String sessionId) {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + "http://127.0.0.1:4444/video/" + sessionId + ".mp4"
                +"' type='video/mp4'></video></body></html>";
    }

    @AfterEach
    public void afterTest() {
        WebDriverRunner.closeWindow();
    }
}
