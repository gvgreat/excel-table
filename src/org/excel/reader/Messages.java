package org.excel.reader;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Messages externalization for this package
 */
public class Messages  {

  private static final String BUNDLE_NAME = "org.excel.reader.excel"; //$NON-NLS-1$
  private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

  /**
   * Constructor.
   */
  private Messages() {
    // Do nothing.
  }
  
  public static final String getString(String key) {
    try {
      return BUNDLE.getString(key);
    } catch (MissingResourceException ex) {
      return ""; //$NON-NLS-1$
    }
  }
}
