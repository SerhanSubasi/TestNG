package techproed.tests.day21_POM;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class C01_DriverIlkTest {
    @Test
    public void testtest01() {

        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get("https://facebook.com");
        Driver.getDriver().get("https://google.com");
    }

}
