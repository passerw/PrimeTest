package passer;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestPrime {
	private int input;
	private String expected;
	private Prime prime = null;
	private ByteArrayOutputStream baos = null;
	
	public TestPrime(int input, String expected) {
		this.input = input;
		this.expected = expected;
	}
	
	@Before
	public void SetUp(){
		prime = new Prime();
		baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
	}
	
	@Parameters
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][]{
			{1, "Prime: 2\r\n"},
			{5, "Prime: 2\r\nPrime: 3\r\nPrime: 5\r\nPrime: 7\r\nPrime: 11\r\n"}
		});
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void TestPrintPrimes(){
		prime.printPrimes(this.input);
		assertEquals(this.expected, baos.toString());
	}
}
