package Data_Driven;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;

public class ExcelCode {

    public static FileInputStream ip;
    public  static XSSFWorkbook workbook;
    public static XSSFSheet sheet;

    @DataProvider(name="ARegister")
    public Object[][] getAmazonRegisterDta() throws Exception{
        Object [][] data= ExcelCode.readFromExeclSheetARegister("Register");
        return data;
    }
    public static Object[][] readFromExeclSheetARegister(String sheetName) throws Exception {
        //5. Create the Object of FileInputStream class and pass the path of the Excel sheet in its Constructor
        ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\Data_Driven\\Book1.xlsx");
        //6. Create the Object of XSSFWorkbook class
        workbook = new XSSFWorkbook(ip);
        //7. use the workbook reference to address individual sheet
        sheet = workbook.getSheet(sheetName);
        //8. identify the rows and cols of the sheet
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();
        //9. Create a 2-Dimensional Object Array and then return the Object Array
        Object[][] data = new Object[rows][cols];
        for(int i=0 ; i<rows ; i++) {
            XSSFRow row = sheet.getRow(i+1);
            for(int j=0 ; j<cols ; j++) {
                XSSFCell cell = row.getCell(j);
                CellType celltype = cell.getCellType();

                switch(celltype) {
                    case STRING:
                        data[i][j] = cell.getStringCellValue();
                        break;

                    case NUMERIC:
                        data[i][j] = Integer.toString((int)cell.getNumericCellValue());
                        break;

                    case BOOLEAN:
                        data[i][j] = cell.getBooleanCellValue();
                        break;

                }
            }
        }

        return data;

    }

}
