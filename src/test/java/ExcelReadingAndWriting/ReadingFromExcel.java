package ExcelReadingAndWriting;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class ReadingFromExcel {

    public static void readExcel() throws FileNotFoundException {

        try {
            String excelFilePath = "src/test/ExcelFiles/EmloyeeList.xlsx";
            FileInputStream fileInput = new FileInputStream(excelFilePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through the sheet
            int rows = sheet.getLastRowNum();
            int cols = sheet.getRow(1).getLastCellNum();

            //ArrayList myarray = new ArrayList();

            for(int r=0;r<rows;r++){

                XSSFRow row = sheet.getRow(r);

                for(int c=0;c<cols;c++){

                    XSSFCell cell = row.getCell(c);

                    switch (cell.getCellType()){
                        case STRING: System.out.print(cell.getStringCellValue()); break;
                        case NUMERIC: System.out.print(cell.getNumericCellValue());break;
                        case BOOLEAN: System.out.print(cell.getBooleanCellValue());break;
                    }

                    //myarray.add(cell);

                    System.out.print(" | ");

                }
                System.out.println();
            }

        } catch (IOException var2) {
            System.out.println(var2);
        }


    }



    public static void main(String[] args) throws IOException {

        readExcel();


        }



}


