package gui;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ExcelFilter  extends FileFilter {
    final static String xls = "xls";
    final static String xlsx = "xlsx";

 
    
    // Accept all directories and all gif, jpg, or tiff files.
    public boolean accept(File f) {

        if (f.isDirectory()) {
            return true;
        }

        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            String extension = s.substring(i+1).toLowerCase();
            if (xls.equals(extension) ||
            		xlsx.equals(extension) ) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }
    
    // The description of this filter
    public String getDescription() {
        return "Archivos Microsoft Excel";
    }
}
