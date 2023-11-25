package techproed.tests.day20_annotations_softassert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C05_SoftAssertion {

    /*
    Testteki failler tüm testi durdurmasın istiyorsak softAssertion kullanırız.
     */

    @Test
    public void softAssertionTest() {
        // Öncelikle SoftAssert classından bir object oluşturmalıyız.
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(2,2); //pass
        softAssert.assertTrue(2>3,"2,3'ten büyük olmaıydı"); //fail
        softAssert.assertFalse(3>2,"3,2'den büyük olmamalıydı"); //fail
        softAssert.assertNotEquals("java","java","Farklı olmalılardı"); //fail


        softAssert.assertAll(); // Bunu yapmazsak test fail olsa bile geçer. ŞART!
        /*
        AssertAll methodu kendisinden önce yapılan tüm sorf assertinları değerlendirir.
        Eğer herhangi bir method fail olmuşsa test başarısız olur, classkın kalan kısmı çalıştırılmaz.
         */

        System.out.println("Mesela bu çalıştırılmayacak çünkü yukarıda fail aldık.");
    }


}
