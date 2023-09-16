package com.finzly.fxtrading.utility;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidationUtils {

    // Define a regular expression pattern to match valid customer names
    private static final String CUSTOMER_NAME_PATTERN = "^[a-zA-Z ]+$";

    public static String validateCustomerName(String customerName) {
        // Check if the customer name is blank (empty or just spaces)
        if (customerName == null || customerName.trim().isEmpty()) {
            return "Customer name is required";
        }

        // Use a regular expression to validate the customer name
        Pattern pattern = Pattern.compile(CUSTOMER_NAME_PATTERN);
        Matcher matcher = pattern.matcher(customerName);

        // Check if the customer name matches the pattern
        if (!matcher.matches()) {
            return "Check customer name";
        }

        // Customer name is valid
        return null;
    }
}
