import Calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCalculator {
    private Calculator calc = new Calculator();

    @Test
    public void testAdd() {
        Assert.assertEquals(5.0, calc.add(2, 3), "Invalid result of summ");
    }

    @Test
    public void testAddNegative() {
        Assert.assertFalse(5.5 == calc.add(2, 3), "Invalid negative test of summ");
    }

    @Test
    public void testSub() {
        Assert.assertEquals(11.55, calc.sub(20, 8.45), "Invalid result of subtraction");
    }

    @Test
    public void testSubNegative() {
        Assert.assertFalse(11.0 == calc.sub(20,10), "Invalid negative test of subtraction");
    }

    @Test(dataProvider = "dataProviderForMul")
    public void testMulDataFromDataProvider(double a, double b, double expectedResult) {
        double result = calc.mul(a, b);
        Assert.assertEquals(result, expectedResult, "Invalid test of multiplier");
    }

    @Test
    public void testMulNegative() {
        Assert.assertFalse(10.99 == calc.mul(1,10), "Invalid negative test of multiplier");
    }

    @Test
    public void testDiv() {
        Assert.assertEquals(4.0, calc.div(8,2), "Invalid test of div");
    }

    @Test
    public void testDivNegative() {
        Assert.assertFalse(5.0 == calc.div(11,2.5),"Invalid negative test of div");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testDivNullPointerException() {
        calc.div(11, 0);
        System.out.println("Invalid test testDivNullPointerException. Expected NullPointerException");
    }

    @DataProvider(name = "dataProviderForMul")
    public Object[][] dataProvider() {
        return new Object[][]{
                {10, 10, 100.0},
                {0, 5, 0.0},
                {48, 0, 0.0},
                {3,-5,-15.0}};
    }
}
