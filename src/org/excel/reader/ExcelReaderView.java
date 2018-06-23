/**
 * @Copyrights G. Vaidhyanathan
 */
package org.excel.reader;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * @author G. Vaidhyanathan
 */
@SuppressWarnings("serial")
public class ExcelReaderView extends JPanel {

  private final JTable table;
  private final ExcelTableModel tableModel;

  public ExcelReaderView() {
    setLayout(new BorderLayout());
    tableModel = new ExcelTableModel();
    table = new JTable(tableModel);
    table.setAutoCreateColumnsFromModel(true);

    add(getFileInput(), BorderLayout.NORTH);
    add(new JScrollPane(table));
  }

  public JPanel getFileInput() {
    JPanel fileInputPanel = new JPanel(new GridBagLayout());
    fileInputPanel
        .add(new JLabel("Select File:"), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.NORTHWEST,
                                                                GridBagConstraints.NONE, new Insets(3, 3, 3, 3), 0, 0));
    JTextField field = new JTextField();
    fileInputPanel.add(field, new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.NORTHWEST,
                                                     GridBagConstraints.HORIZONTAL, new Insets(3, 3, 3, 3), 0, 0));
    
    JButton actionFile = new JButton("..."); //$NON-NLS-1$
    fileInputPanel.add(actionFile, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(3, 1, 3, 1), 0, 0));

    
    return fileInputPanel;
  }

  public static void main(String[] args) throws Exception {
    EventQueue.invokeLater(new Runnable() {

      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceBusinessBlueSteelLookAndFeel"); //$NON-NLS-1$
          JFrame.setDefaultLookAndFeelDecorated(true);
          JDialog.setDefaultLookAndFeelDecorated(true);
          ExcelReaderView view = new ExcelReaderView();

          JFrame frame = new JFrame("Excel Reader"); //$NON-NLS-1$
          frame.setContentPane(view);
          frame.pack();
          frame.setVisible(true);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (Exception ex) {
          // TODO Auto-generated catch block
          ex.printStackTrace();
        }
      }

    });

  }

}
