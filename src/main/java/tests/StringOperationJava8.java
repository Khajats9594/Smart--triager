package tests;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;



public class StringOperationJava8 {
	
	  @Test(groups = "smoke", description = "Compare Strings")
	  public void shouldCompareString() {

	        // 1. Arrange
	        String firstString = "Hello";
	        String secondString = "Hello";
	        
	        boolean allMatch = Arrays.stream(secondString.split(""))
	        						 .allMatch(s->Arrays.stream(firstString.split(""))
	        						 .anyMatch(str->str.equals(s)));

	        // 2. Act
	        assertEquals(allMatch, "Comparing the two string equals");

	    }
	  
	  @Test(groups = "smoke", description = "Compare Case Sensitive Strings")
	  public void shouldCompareCaseSensitiveString() {

	        // 1. Arrange
	        String firstString = "Hello";
	        String secondString = "hello";

	        // 2. Act
	        boolean allMatch = Arrays.stream(secondString.split(""))
					                 .allMatch(s->Arrays.stream(firstString.split(""))
							         .anyMatch(str->str.equalsIgnoreCase(s)));

	        // 3. Assert
	        assertEquals(allMatch, "Comparison of Strings failed");

	    }
	  
	  @Test(groups = "smoke", description = "Compare Strings")
	    public void testStringLength() {
		  
		    //1. Arrange
	        String str = "Hello, TestNG!";
	        
	        //2.act
	        Predicate<String> stringLenght = st->str.length()==13;
	        boolean test = stringLenght.test(str);
	        
	        //3. Assert
	        assertEquals(test, "Incorrect string length");
	    }
	  
	  @Test(groups = "smoke", description = "Compare Strings")
	    public void testStringConcatenation() {
		  
		  	//1. Arrange
	        String str1 = "Hello";
	        String str2 = "TestNG";
	       
	        //2.Act
	        String result = IntStream.range(0, 1)
	        		                 .mapToObj(i->str1.concat(str2))
	        		                 .collect(Collectors.joining());
	        
	        //Assert
	        assertEquals(result, "Hello, TestNG", "Concatenation failed");
	    }
	  
	  @Test(groups = "smoke", description = "Compare Strings")
	    public void testStringSubstring() {
		  	
		  	//1. Arrange
	        String str = "TestNG is awesome";
	        
	        //2. Act
	        String subString = Arrays.stream(str.split(" "))
	        						 .filter(s->s.equalsIgnoreCase("awesome"))
	        						 .findAny()
	        						 .get();
	        //3.Assert
	        assertEquals(subString, "awesome", "Substring mismatch");
	    }
	  @Test(groups = "smoke", description = "Compare Strings")
	    public void testStringUpperCase() {
		  
		  	//1.Arrange
	        String str = "testng";
	        
	        //2.Act
	        String upperCase = Stream.of(str)
	        					  .map(s->s.toUpperCase())
	        					  .findAny()
	        					  .get();
	       //3. Assert
	        assertEquals(upperCase, "TESTNG", "Uppercase conversion failed");
	    }
	  
	  @Test(groups = "smoke", description = "Compare Strings")
	    public void testStringLowerCase() {
		  
		  	//1.Arrange
	        String str = "TESTNG";
	        
	        //2.Act
	        String lowerCase = Stream.of(str)
					  			     .map(s->s.toLowerCase())
					                 .findAny()
					                 .get();
	        //3.Assert
	        assertEquals(lowerCase, "testnG", "Lowercase conversion failed");
	    }
	  
	  @Test(groups = "smoke", description = "Compare Strings")
	    public void testStringContains() {
		  	//1.Arrange
	        String str = "Welcome to TestNG";
	        
	        //2.Act
	        String contains = Arrays.stream(str.split(" "))
	                                .filter(s->s.contentEquals("TestNG"))
	                                .findAny()
	                                .get();
	        
	        //3.Assert
	        assertEquals(contains,"TestNg","Substring not found");
	    }

	

}
