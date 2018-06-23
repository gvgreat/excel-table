/**
 * @Copyrights G. Vaidhyanathan
 */
package org.excel.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author G. Vaidhyanathan
 */
public class ExcelReader {
  private final File excelFile;

  private HSSFWorkbook workbook;

  public ExcelReader(File file) {
    excelFile = file;
    try {
      workbook = new HSSFWorkbook(new FileInputStream(excelFile));
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public List<String> getHeader() {
    List<String> header = new ArrayList<String>(1);
    if (workbook == null) {
      return header;
    }
    HSSFSheet sheet = workbook.getSheet("Sheet1"); //$NON-NLS-1$

    HSSFRow row = sheet.getRow(0);
    HSSFCell cell = null;
    short cellIndex = 0;
    while ((cell = row.getCell(cellIndex++)) != null) {
      header.add(cell.getRichStringCellValue().getString());
    }
    return header;
  }

  public List<List<String>> getValues() {
    List<List<String>> values = new Vector<List<String>>(1);

    HSSFSheet sheet = workbook.getSheet("Sheet1"); //$NON-NLS-1$

    short rowIndex = 1;
    HSSFRow row = null;
    while ((row = sheet.getRow(rowIndex++)) != null) {
      Vector<String> oneRow = new Vector<String>(1);
      HSSFCell cell = null;
      short cellIndex = 0;
      while ((cell = row.getCell(cellIndex++)) != null) {

        oneRow.add(getCellValue(cell));
      }
      values.add(oneRow);
    }
    return values;
  }

  public String getCellValue(HSSFCell cell) {
    String value = "";
    switch (cell.getCellType()) {
      case HSSFCell.CELL_TYPE_STRING:
        value = cell.getRichStringCellValue().getString();
      break;
      case HSSFCell.CELL_TYPE_NUMERIC:
        value = "" + cell.getNumericCellValue();
        try {
          value = cell.getDateCellValue().toString();
        } catch (RuntimeException ex) {
          ex.printStackTrace();
        }
      break;
      case HSSFCell.CELL_TYPE_BOOLEAN:
        value = Boolean.toString(cell.getBooleanCellValue());
      break;
    }
    return value;
  }
}
