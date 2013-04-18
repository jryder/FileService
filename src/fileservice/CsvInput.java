/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import abstraction.InputStrategy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

/**
 *
 * @author jryder
 */
public class CsvInput implements InputStrategy {

    File file;
    LinkedHashMap hash;

    
    @Override
    public void setFile(File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
    
    
    
    @Override
    public void readFile() {

        BufferedReader in = null;
        
        try {
            in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            while (line != null) {
                line = in.readLine();  // strips out any carriage return chars
                if (line != null) {
                }
            }
        } catch (IOException ioe) {
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }
    }


    
}
