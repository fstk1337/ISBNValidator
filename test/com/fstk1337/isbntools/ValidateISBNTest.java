package com.fstk1337.isbntools;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateISBNTest {

    @Test
    public void checkAValidShortISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449116");
        assertTrue(result, "first value");
        result = validator.checkISBN("0140177396");
        assertTrue(result, "second value");
    }

    @Test
    public void checkAValidLongISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9780593230572");
        assertTrue(result, "first value");
        result = validator.checkISBN("9780399592553");
        assertTrue(result, "second value");
    }

    @Test
    public void checkAnInvalidShortISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test
    public void checkAnInvalidLongISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9780593230574");
        assertFalse(result);
    }

    @Test
    public void ShortISBNNumbersEndingInAnXAreValid() {
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result);
    }

    @Test
    public void nineDigitISBNsAreNotAllowed() {
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class, () -> {
            validator.checkISBN("123456789");
        });
    }

    @Test
    public void nonNumericISBNsAreNotAllowed() {
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class, () -> {
            validator.checkISBN("helloworld");
        });
    }
}