package ExcelReadingAndWriting;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

public class WritingOnExcel {
    public static void writingExcel(){
        Object [][] my2DArray = {{"Name","Age","Gender","Phone","Address"},
                {"Armachen",45,"Male",123456,"456 AddisAbaba"},
                {"Anani",20,"Male",56897,"654 Merkat"},{"Lulu",15,"Male",452137,"897 Kazanchis"}};
        try{

            XSSFWorkbook workbook2 = new XSSFWorkbook();
            XSSFSheet sheet = workbook2.createSheet("Sheet2");
            int rows = my2DArray.length;
            int col = my2DArray[0].length;
            System.out.println(rows+" "+col);

            for(int r=0;r<rows;r++){
                XSSFRow row = sheet.createRow(r);
                for(int c=0;c<col;c++){
                    XSSFCell cell = row.createCell(c);
                    Object value = my2DArray[r][c];
                    if(value instanceof String)
                        cell.setCellValue((String)value);
                    if(value instanceof Integer)
                        cell.setCellValue((Integer) value);
                    if(value instanceof Boolean)
                        cell.setCellValue((Boolean)value);
                }
            }
            String filePath = "C:/Users/armac/Desktop/Book1.xlsx";
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook2.write(outputStream);
            outputStream.close();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        writingExcel();
    }
}
