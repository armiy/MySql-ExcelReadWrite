package ExcelReadWriteProject2;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadExcel {

    public static void readExcel(){


        try{
            String filePath = "src/test/ExcelFile/EmloyeeList.xlsx";
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            int row = sheet.getLastRowNum()+1;
            int col = sheet.getRow(1).getLastCellNum();

            for(int r=0;r<row;r++){
                Row rows = sheet.getRow(r);
                for(int c=0;c<col;c++){
                    Cell cell = rows.getCell(c);
                    switch (cell.getCellType()){
                        case STRING: System.out.print(cell.getStringCellValue());break;
                        case NUMERIC: System.out.print(cell.getNumericCellValue());break;
                        case BOOLEAN: System.out.print(cell.getBooleanCellValue());break;
                        case BLANK: System.out.print(cell.getColumnIndex());break;

                    }

                    System.out.print("|");
                }
                System.out.println();
            }


        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        readExcel();

    }
}
