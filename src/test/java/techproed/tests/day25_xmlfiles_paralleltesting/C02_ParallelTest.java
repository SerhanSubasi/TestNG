package techproed.tests.day25_xmlfiles_paralleltesting;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_ParallelTest {

    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("OpenSourceUrl"));
        Driver.closeDriver();
    }

    @Test
    public void test02() {
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("OpenSourceUrl"));
        Driver.closeDriver();
    }





}