package com.automationpractice.test;

import com.automationpractice.fixture.DataFixture;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class CartTest extends DataFixture {
    @Test
    public void addProductInCartTest() {
        int allAddedDresses;
        allAddedDresses = mainPage.addAllDressesToCart();
        assertEquals(allAddedDresses, mainPage.goToShoppingCartPage().getNumberOfProductsInCart());
    }

    @Disabled
    @Test
    public void addZeroQuantityOfProductsTest() {
        mainPage.addFirstProductInCartWithSetQuantity("0");
        assertEquals(0, mainPage.goToShoppingCartPage().getNumberOfProductsInCart());
    }

    @Test
    public void correctAmountInCartTest() {
        double allProdPrice, totalProduct;
        mainPage.addAllDressesToCart();
        allProdPrice = mainPage.goToShoppingCartPage().getAllProductsPrice();
        totalProduct = shoppingCartPage.getTotalProductsPrice();
        assertEquals(allProdPrice, totalProduct);
    }

    @Test
    public void correctAmountInCartWithSetQuantityProductTest() {
        double allProdPrice, totalProduct;
        mainPage.addAllDressesToCart();
        allProdPrice = mainPage.goToShoppingCartPage().setProductQuantity("5").getAllProductsPrice();
        totalProduct = shoppingCartPage.getTotalProductsPrice();
        assertEquals(allProdPrice, totalProduct);
    }

    @Test
    public void deleteAllProductTest() {
        mainPage.addAllDressesToCart();
        shoppingCartPage = mainPage.goToShoppingCartPage().deleteAllProducts();
        assertEquals(0, shoppingCartPage.getNumberOfProductsInCart());
    }

}
