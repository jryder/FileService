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

    private File file;
    private String[] headers;
    private List<LinkedHashMap<String, String>> list;

    
    public List<LinkedHashMap<String, String>> getList() {
	return list;
    }

    
    public void setList(List<LinkedHashMap<String, String>> list) {
	this.list = list;
    }
    
    @Override
    public void setFile(File file) {
	this.file = file;
    }

   
    
    @Override
    public void readFile() {

	list = new ArrayList();

	BufferedReader in = null;


	//open the file and begin reading
	try {
	    in = new BufferedReader(new FileReader(file));

	    //set some basic variableage
	    String line = "";
	    int i = 0;

	    //loop through all the rows and add to the list
	    while (line != null) {
		i++;
		line = in.readLine();  // strips out any carriage return chars
		if (line != null) {

		    //if it is the first row, set the headers, otherwise load the row
		    if (i == 1) {
			setHeaders(line);
		    } else {
			LinkedHashMap hm = splitLine(line);
			list.add(hm);
		    }
		}
	    }
	} catch (IOException ioe) {
	    System.out.println("Error");
	} finally {
	    try {
		in.close();
	    } catch (Exception e) {
	    }
	}
    }

    
    
    
    /**
     *
     * @param s
     * @return Array of headers
     */
    private void setHeaders(String s) {
	//clear
	headers = null;
	headers = s.split(",");
    }

    
    
    
    private LinkedHashMap<String, String> splitLine(String s) {
	LinkedHashMap<String, String> link = new LinkedHashMap();

	//split the row text
	String[] rows;
	rows = s.split(",");


	//insert row for each field with the header name
	for (int i = 0; i < headers.length; i++) {
	    link.put(headers[i], rows[i]);
	}

	return link;
    }

    
    public static void main(String[] args) {
	CsvInput c = new CsvInput();
	File f = new File("src/test_comma_only.csv"); //normally pass this in through GUI
	
	//3 steps: set, read, get
	c.setFile(f);
	c.readFile();
	c.getList(); //demonstration only
	
	//make sure that the thing worked
	System.out.println(c.getList());
	
	
    }

    @Override
    public File getFile() {
	return this.file;
    }
}
