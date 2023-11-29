package techproed.tests.day23_excel;

import org.testng.annotations.Test;
import techproed.utilities.ExcelReader;

public class C01_ExcelTest {

    @Test
    public void test01() {
        String dosyaYolu="src\\test\\java\\techproed\\resources\\mysmoketestdata.xlsx";
        String sayfaIsmi="customer_info"; //excel'deki sayfa ismi bu
        ExcelReader excelReader = new ExcelReader(dosyaYolu,sayfaIsmi);
        System.out.println(excelReader.getCellData(0, 0)); //username
        System.out.println(excelReader.getCellData(0, 1)); //password

        String email = excelReader.getCellData(1,0);
        String password = excelReader.getCellData(1,1);

        System.out.println(email + " " + password);
    }


}
