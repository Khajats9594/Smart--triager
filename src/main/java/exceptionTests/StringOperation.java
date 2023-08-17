package exceptionTests;

import org.testng.annotations.Test;

import annotation.FrameworkAnnotation;
import enums.CategoryType;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class StringOperation {
	

    @Test(groups = "smoke", description = "Compare Case Sensitive Strings")
    @FrameworkAnnotation(author="Tom", category=CategoryType.SMOKE)
    public void shouldCompareCaseSensitiveString() {

        // 1. Arrange
        String firstString = "Hello";
        String secondString = "hello";

        // 2. Act
        int i = firstString.compareTo(secondString);

        // 3. Assert
        assertEquals(i, 0, "Comparison of Strings failed");

    }

    @Test(groups = "regression", description = "Compare Case Sensitive Strings")
    @FrameworkAnnotation(author="Tom", category=CategoryType.SMOKE)
    public void shouldCompareCaseSensitiveString2() {

        // 1. Arrange
        String firstString = "Hello";
        String secondString = "hello";

        // 2. Act
        int i = firstString.compareTo(secondString);

        // 3. Assert
        assertEquals(i, 0, "Comparison of Strings failed");

    }

    @Test(groups = "regression", description = "Compare Case Sensitive Strings")
    @FrameworkAnnotation(author="Tom", category=CategoryType.SMOKE)
    public void shouldCompareCaseSensitiveString3() {

        // 1. Arrange
        String firstString = "Hello";
        String secondString = "hello";

        // 2. Act
        int i = firstString.compareTo(secondString);

        // 3. Assert
        assertEquals(i, 0, "Comparison of Strings failed");

    }

    @Test(groups = "regression", description = "Compare Case Sensitive Strings")
    @FrameworkAnnotation(author="Tom", category=CategoryType.SMOKE)
    public void shouldCompareCaseSensitiveString4() {

        // 1. Arrange
        String firstString = "Hello";
        String secondString = "hello";

        // 2. Act
        int i = firstString.compareTo(secondString);

        // 3. Assert
        assertEquals(i, 0, "Comparison of Strings failed");

    }


  

    @Test(groups = "smoke", description = "Compare Strings")
    @FrameworkAnnotation(author="Tom", category=CategoryType.SANITY)
    public void testStringLength() {
        String str = "Hello, TestNG!";
        int length = str.length();
        assertEquals(length, 13, "Incorrect string length");
    }

    @Test(groups = "smoke", description = "Compare Strings")
    @FrameworkAnnotation(author="Tom", category=CategoryType.SANITY)
    public void testStringConcatenation() {
        String str1 = "Hello";
        String str2 = "TestNG";
        String result = str1 + ", " + str2;
        assertEquals(result, "Hello, TestNG", "Concatenation failed");
    }

    @Test(groups = "smoke", description = "Compare Strings")
    @FrameworkAnnotation(author="Jerry", category=CategoryType.SANITY)
    public void testStringSubstring() {
        String str = "TestNG is awesome";
        String subStr = str.substring(9, 16);
        assertEquals(subStr, "awesome", "Substring mismatch");
    }

    @Test(groups = "smoke", description = "Compare Strings")
    @FrameworkAnnotation(author="Jerry", category=CategoryType.SANITY)
    public void testStringUpperCase() {
        String str = "testng";
        String upperCase = str.toUpperCase();
        assertEquals(upperCase, "TESTNG", "Uppercase conversion failed");
    }

    @Test(groups = "smoke", description = "Compare Strings")
    @FrameworkAnnotation(author="Jerry", category=CategoryType.SANITY)
    public void testStringLowerCase() {
        String str = "TESTNG";
        String lowerCase = str.toLowerCase();
        assertEquals(lowerCase, "testnG", "Lowercase conversion failed");
    }

    @Test(groups = "smoke", description = "Compare Strings")
    @FrameworkAnnotation(author="Jerry", category=CategoryType.SANITY)
    public void testStringContains() {
        String str = "Welcome to TestNG";
        boolean contains = str.contains("TestNG");
        assertTrue(contains, "Substring not found");
    }

}
