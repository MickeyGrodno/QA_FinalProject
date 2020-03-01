package com.automationpractice.test;

import com.automationpractice.fixture.DataFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Execution(ExecutionMode.CONCURRENT)
public class MainPageTest extends DataFixture {
    @Test
    public void womenButtonMenuIsDisplayedTest() {
        assertTrue(mainPage.womenButtonMenuIsDisplayed());
    }

    @Test
    public void dressesButtonMenuIsDisplayedTest() {
        assertTrue(mainPage.dressesButtonMenuIsDisplayed());
    }

    @Test
    public void summerDressUrlSameTest() {
        assertTrue(mainPage.summerDressUrlSame());
    }
}
