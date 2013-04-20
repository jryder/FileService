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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author jryder
 */
public class CsvInput implements InputStrategy {

    File file;
    String[] headers;

    
    @Override
    public void setFile(File file) {
        this.file = file;
    }    
    
    
    
    @Override
    public void readFile() {
	
	List<LinkedHashMap<String, String>> list = new ArrayList();
	
        BufferedReader in = null;
	int i = 0;
	
        try {
            in = new BufferedReader(new FileReader(file));
            String line = "";
	    
            while (line != null) {
		
		i = i++;
                line = in.readLine();  // strips out any carriage return chars
                if (line != null) {
		    System.out.println(line);
		    LinkedHashMap hm = splitLine(line);
		    list.add(hm);
		    
                }
		
            }
        } catch (IOException ioe) {
	    System.out.println("Error");
        } /*finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }*/
    }
    
    
    /**
     * 
     * @param s
     * @return Array of headers
     */
    private void setHeaders (String s){
	//clear
	headers = null;
	headers = s.split(",");	
    }
    
    
    
    
    
    private LinkedHashMap<String,String> splitLine (String s){
	LinkedHashMap<String,String> link = new LinkedHashMap();
	
	
	//insert row for each field with the header name
	for (int i = 0;i < headers.length;i++){
	    link.put(headers[i], "test");
	}
	
	return link;
    }

    
    public static void main(String[] args) {
	CsvInput c = new CsvInput();
	File f = new File("src/test_comma_only.csv");
	c.setFile(f);
	c.readFile();
	
    }
    
    
    
}
