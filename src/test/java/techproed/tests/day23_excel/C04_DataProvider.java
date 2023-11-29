package techproed.tests.day23_excel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C04_DataProvider {

    @DataProvider
    public static Object[][] araclar() { //Obje olmasının sebebi Hz.Adem olması ve aşağıda String yerine int de girebilmemiz.
        return new Object[][]{


        };
    }


    @Test (dataProvider = "araclar")
    public void test01(String data) {
        
    }
    
    
}
