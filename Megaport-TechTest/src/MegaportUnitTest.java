import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MegaportUnitTest {
	Megaport megaport;
	
	@BeforeEach
	void setUp() {
		megaport = new Megaport();
	}
	
	@Test
	@DisplayName("Null input file.")
	void testNullInputFile() throws IOException {
		assertEquals(megaport.sortNames(null), null);
	}
	
	@Test
	@DisplayName("Successful test case")
	void testSortFunction() throws IOException {
		ArrayList<String> string = new ArrayList<String>();
		string.add("BAKER, THEODORE");
		string.add("KENT, MADISON");
		string.add("SMITH, ANDREW");
		string.add("SMITH, FREDRICK");
		assertEquals(megaport.sortNames("names.txt"), string);
	}
	
	@Test
	@DisplayName("FileNotFoundException/ Invalid input test case")
	void shouldThrowFNFExceptionWithProperMessage() throws IOException {
		try {
			megaport.sortNames("blahblah.txt");
			fail();
		}
		catch (FileNotFoundException ex){
			assertEquals("File not found. Invalid input.", ex.getMessage());
		}
	  }
	
	@Test
	@DisplayName("Invalid names check")
	void shouldThrowInvalidContentInFileError() throws IOException {
		try {
			megaport.sortNames("invalidInput.txt");
			fail();
		}
		catch (IllegalArgumentException ex){
			assertEquals("File should contain valid names only.", ex.getMessage());
		}
	  }
}
