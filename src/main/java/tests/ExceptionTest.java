package tests;

import java.util.stream.Stream;

import org.testng.annotations.Test;

public class ExceptionTest {
	
	@Test(groups = "smoke", description = "Compare Strings")
    public void testNullPointerException() {
        String str = null;
        String nullCheck = Stream.of(str)
        	  .filter(s->!s.equals(null))
        	  .findAny()
        	  .orElseThrow();
    }

}
