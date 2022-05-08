package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataF {public static String getTestData(int row,int cell,String SheetName) throws EncryptedDocumentException, IOException{
	FileInputStream file = new FileInputStream("C:\\Users\\Dell\\Downloads\\Praful.xlsx");
	
	String value= WorkbookFactory.create(file).getSheet(SheetName).getRow(row).getCell(cell).getStringCellValue();

	return value;

}

}
