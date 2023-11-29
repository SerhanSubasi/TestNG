package techproed.tests.day24_dataprovider_xmlfiles;

import org.testng.annotations.Test;


public class C01_DataProvider {

    @org.testng.annotations.DataProvider
    public static Object[][] isimler() {
        return new Object[][]{

                {"mustafa"},{"ibrahim"},{"safa"},{"gökay"}

        };
    }




    @Test(dataProvider = "isimler")                     //  1
    public void test01(String data) {

    }


    @org.testng.annotations.DataProvider
    public static Object[][] isimlervesoyisimler() {
        return new Object[][]{

                {"ali", "can"},
                {"veli", "han"},
                {"ahmet", "can"}

        };
    }



    @Test(dataProvider = "isimlervesoyisimler")         //  2
    public void test02(String isim, String soyisim) {
        System.out.println(isim+" "+soyisim);

    }



}
