import org.example.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Main calculator;

    @Before
    public void setup() {
        calculator = new Main();
    }

    @Test
    public void testSquareRoot() {
        // Test for positive number
        double result = calculator.sqrt(16);
        Assert.assertEquals(4.0, result, 0.001);

        // Test for zero
        result = calculator.sqrt(0);
        Assert.assertEquals(0.0, result, 0.001);

        try {
            calculator.sqrt(-3);
            Assert.fail("Expected IllegalArgumentException for negative input");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }

    }

    @Test
    public void testFactorial() {
        // Test for positive integer
        int result = calculator.factorial(5);
        Assert.assertEquals(120, result);

        // Test for zero (special case)
        result = calculator.factorial(0);
        Assert.assertEquals(1, result);

        // Test for negative integer (expecting exception or specific error handling)
        try {
            calculator.factorial(-3);
            Assert.fail("Expected IllegalArgumentException for negative input");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testNaturalLogarithm() {
        // Test for positive number
        double result = calculator.naturalLog(10);
        Assert.assertEquals(2.302585, result, 0.001);

        // Test for one (ln(1) = 0)
        result = calculator.naturalLog(1);
        Assert.assertEquals(0.0, result, 0.001);

        // Test for zero (ln(0) should raise an error)
        try {
            calculator.naturalLog(0);
            Assert.fail("Expected IllegalArgumentException for ln(0)");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }

        // Test for negative number (ln(negative) should raise an error)
        try {
            calculator.naturalLog(-10);
            Assert.fail("Expected IllegalArgumentException for ln(negative number)");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testPower() {
        // Test with positive base and positive exponent
        double result = calculator.power(2, 3);
        Assert.assertEquals(8.0, result, 0.001);

        // Test with positive base and zero exponent (should return 1)
        result = calculator.power(5, 0);
        Assert.assertEquals(1.0, result, 0.001);

        // Test with negative base and positive exponent
        result = calculator.power(-2, 3);
        Assert.assertEquals(-8.0, result, 0.001);

        // Test with positive base and negative exponent
        result = calculator.power(2, -3);
        Assert.assertEquals(0.125, result, 0.001);
    }
}