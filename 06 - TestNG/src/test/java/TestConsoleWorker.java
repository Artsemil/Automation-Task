import Calculator.ConsoleWorker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestConsoleWorker {
    private ConsoleWorker consoleWorker = new ConsoleWorker();

    @Test(dataProvider = "dataProviderForIsNumber")
    public void testIsNumber(String number, boolean expectedResult) {
        Assert.assertEquals(consoleWorker.isNumber(number), expectedResult, "Invalid test for isNumber checking "  + number + " is not a number.");
    }

    @DataProvider(name = "dataProviderForIsNumber")
    public Object[][] dataProviderNumber() {
        return new Object[][]{
                {"0", true},
                {"13", true},
                {"-110", true},
                {"55.55", true},
                {"22.ss", false},
                {"1/2", false},
                {" ", false},
                {"hello", false},
                {"55t", false}};
    }

    @Test(dataProvider = "dataProviderForIsOperation")
    public void testIsOperation(String operation, boolean expextedResult) {
        Assert.assertEquals(consoleWorker.isOperation(operation), expextedResult, "Invalid test for is oPeration checking: " + operation + " incorrect operation.");
    }

    @DataProvider(name = "dataProviderForIsOperation")
    public Object[][] dataProviderOperation() {
        return new Object[][]{
                {"/", true},
                {"*", true},
                {"-", true},
                {"+", true},
                {" ", false},
                {"-+", false},
                {"0", false}};
    }
}
