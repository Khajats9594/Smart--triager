package exceptionTests;

import org.testng.annotations.Test;

import annotation.FrameworkAnnotation;
import enums.CategoryType;

public class ExceptionTest {
	
	@Test(groups = "smoke", description = "Compare Strings")
	@FrameworkAnnotation(author="Tom", category=CategoryType.SANITY)
    public void testNullPointerException() {
        String str = null;
        int length = str.length(); // This will throw a NullPointerException
    }

    @Test(groups = "smoke", description = "Compare Strings")
    @FrameworkAnnotation(author="Tom", category=CategoryType.SANITY)
    public void testArithmeticException() {
        int result = 10 / 0; // This will throw an ArithmeticException (division by zero)
    }

    @Test(groups = "smoke", description = "Compare Strings")
    @FrameworkAnnotation(author="Jerry", category=CategoryType.SMOKE)
    public void testArithmeticException2() {
        int result = 10 / 0; // This will throw an ArithmeticException (division by zero)
    }

    @Test(groups = "smoke", description = "Compare Strings")
    @FrameworkAnnotation(author="Jerry", category=CategoryType.SMOKE)
    public void testIndexOutOfBoundsException() {
        int[] array = new int[5];
        int value = array[10]; // This will throw an IndexOutOfBoundsException
    }

    @Test(groups = "smoke", description = "Compare Strings")
    @FrameworkAnnotation(author="Jerry", category=CategoryType.SMOKE)
    public void testMultipleExceptions() {
        String str = null;
        int length = str.length(); // This will throw a NullPointerException

        int result = 10 / 0; // This will throw an ArithmeticException (division by zero)
    }

}
