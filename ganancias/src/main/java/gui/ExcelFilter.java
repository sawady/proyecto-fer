package gui;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ExcelFilter  extends FileFilter {
    final static String xlsx = "xlsx";

    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String s = f.getName();
        int i = s.lastIndexOf('.');
        if (i > 0 &&  i < s.length() - 1) {
            String extension = s.substring(i+1).toLowerCase();
            if (     		xlsx.equals(extension) ) {
                    return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public String getDescription() {
        return "Archivos Microsoft Excel 2007";
    }
}
