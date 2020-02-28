package com.automationpractice.test;

import com.automationpractice.fixture.DataFixture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateNewOrderTest extends DataFixture {
    @Test
    public void createAndCheckOrderTest() {
        String orderName;
        mainPage.addAllDressesToCart();
        mainPage.goToShoppingCartPage();
        orderName = shoppingCartPage.createOrderAndGetOrderName();
        assertTrue(myAccountPage.orderIsPresent(orderName));
    }
}



