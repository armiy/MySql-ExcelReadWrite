package ExcelReadWriteProject2;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WriteExcel {
    public static void excelRead(String name,String sex, String age, String phone, String email, int rowNum){


        try{
            Object [][] arrayToWrite = new Object[1][5];
            arrayToWrite[0][0] = name;
            arrayToWrite[0][1] = sex;
            arrayToWrite[0][2] = age;
            arrayToWrite[0][3] = phone;
            arrayToWrite[0][4] = email;

            String filePath = "src/test/ExcelFile/Book1.xlsx";
            FileInputStream fileInputStream = new FileInputStream(filePath);

            Workbook workbook1 = WorkbookFactory.create(fileInputStream);
            Sheet sheet1 = workbook1.getSheet("Arma");

            int row = arrayToWrite.length+rowNum;
            int col = arrayToWrite[0].length+rowNum;
            System.out.println(row+","+col);

            for(int r=rowNum;r<row;r++){
                Row rows = sheet1.createRow(r);
                for(int c=0;c<col-rowNum;c++){
                    Cell cell = rows.createCell(c);
                    Object value = arrayToWrite[r-rowNum][c];
                    if(value instanceof String)
                        cell.setCellValue((String)value);
                    if(value instanceof Integer)
                        cell.setCellValue((Integer)value);
                    if(value instanceof Boolean)
                        cell.setCellValue((Boolean)value);
                }
            }
            String filePath2 = "src/test/ExcelFile/Book1.xlsx";
            FileOutputStream outputStream = new FileOutputStream(filePath2);
            workbook1.write(outputStream);
            workbook1.close();
            outputStream.close();


        }
    catch(Exception e)
    {
        System.out.println(e);
    }

    }

    public static void main(String[] args) {
        excelRead("Hiwot",
                "Female","50",
                "251123456","hiwot@gmail.com",5);
    }
    }

