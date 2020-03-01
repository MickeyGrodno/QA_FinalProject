package com.automationpractice.test;

import com.automationpractice.fixture.DataFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Execution(ExecutionMode.CONCURRENT)
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



