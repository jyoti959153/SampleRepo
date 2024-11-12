package com.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
public String getDataFromExcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
{
FileInputStream fis=new FileInputStream("./Testdata/CRMTestScriptData.xlsx");
Workbook wb = WorkbookFactory.create(fis);
String data = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
wb.close();
return data;
}

public void setDataBackToExcel(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, IOException
{
FileInputStream fis=new FileInputStream("./Testdata/CRMTestScriptData.xlsx");
Workbook wb = WorkbookFactory.create(fis);
 wb.getSheet(sheetname).getRow(rownum).createCell(cellnum);

FileOutputStream fos=new FileOutputStream("./Testdata/CRMTestScriptData.xlsx");
wb.write(fos);
wb.close();
}

public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException
{
FileInputStream fis=new FileInputStream("./Testdata/CRMTestScriptData.xlsx");
Workbook wb = WorkbookFactory.create(fis);
int rowcount = wb.getSheet(sheetname).getLastRowNum();
wb.close();
return rowcount;
}
}
