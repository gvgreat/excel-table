/**
 * @Copyrights G. Vaidhyanathan
 */
package org.excel.reader;

import java.io.File;

import javax.swing.table.DefaultTableModel;

/**
 * @author G. Vaidhyanathan
 *
 */
@SuppressWarnings("serial")
public class ExcelTableModel extends DefaultTableModel{
  public final ExcelReader reader;
  
  public ExcelTableModel() {
    super();
    reader = new ExcelReader(new File("test.xls")); //$NON-NLS-1$
    
    setColumnIdentifiers(reader.getHeader().toArray());
    dataVector.addAll(reader.getValues());
  }
}
