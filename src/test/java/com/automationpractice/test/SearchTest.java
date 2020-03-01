package com.automationpractice.test;

import com.automationpractice.fixture.DataFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Execution(ExecutionMode.CONCURRENT)
public class SearchTest extends DataFixture {
    @Test
    public void searchForAvailableProducts() {
        assert(mainPage.searchAndFoundAnyProduct("T-shirt"));
    }

    @Test
    public void productNotFoundTest(){
        assertTrue(mainPage.searchAndNotFoundProduct("pants"));
    }
}
