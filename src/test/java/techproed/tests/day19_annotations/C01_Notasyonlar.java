package techproed.tests.day19_annotations;

import org.testng.annotations.*;

public class C01_Notasyonlar {
@BeforeSuite
    public void beforeSuite() {
    System.out.println("Her şeyden önce BeforeSuite notasyonuna sahip olan method bir kez çalışır.");
}

    @AfterSuite
    public void afterSuite() {
        System.out.println("Her şeyden sonra AfterSuite notasyonuna sahip olan method bir kez çalışır.");
    }


    @BeforeTest
    public void BeforeTest() {
        System.out.println("Testlerden önce BeforeTest notasyonuna sahip olan method bir kez çalışır.");

    }


    @AfterTest
    public void AfterTest() {
    System.out.println("Testlerden sonra AfterTest notasyonuna sahip olan method bir kez çalışır.");
}


    @BeforeClass
    public void beforeClass() {
        System.out.println("Her classtan önce BeforeClass notasyonuna sahip olan method bir kez çalışır.");
        System.out.println("*****************************************************************************");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("*****************************************************************************");
        System.out.println("Her classtan sonra AfterClass notasyonuna sahip olan method bir kez çalışır.");
    }


    @BeforeMethod
    public void setUp() {
        System.out.println("BeforeMethod notasyonuna sahip olan method her test methodundan önce bir kez çalışır.");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Afterethod notasyonuna sahip olan method her test methodundan sonra bir kez çalışır.");
    }

    @Test
    public void test01() {
        System.out.println("test01 çalıştı.");
    }

    @Test
    public void test02() {
        System.out.println("test02 çalıştı.");
    }

    @Test
    public void test03() {
        System.out.println("test03 çalıştı.");
    }



}
