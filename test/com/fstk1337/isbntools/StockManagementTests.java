package com.fstk1337.isbntools;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StockManagementTests {

    @Test
    public void testCanGetACorrectLocatorCode() {
        ExternalISBNDataService testService = new ExternalISBNDataService() {

            @Override
            public Book lookup(String isbn) {
                return new Book(isbn, "Of Mice And Men", "J. Steinbeck");
            }
        };
        StockManager stockManager = new StockManager();
        stockManager.setService(testService);
        String isbn = "0140177396";
        stockManager.getLocatorCode(isbn);
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }
}
