/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservice;

import abstraction.InputStrategy;
import abstraction.OutputStrategy;
import java.io.File;
import java.util.LinkedHashMap;

/**
 *
 * @author jryder
 */
public class FileService {
    
    InputStrategy inputStrategy;
    OutputStrategy outputStrategy;
    
    
    /**
     * The default construction requires a string to determine what file is being
     * read or written. The constructor then initialized both an input and an output
     * strategy.  
     * 
     * @param fileName 
     */
    public FileService(String fileName){
        
        //String is passed in first and then converted to an actual file
        File file = new File(fileName); //need to create exception handling here!!!
        
        //set properties
        inputStrategy = new CsvInput();
        inputStrategy.setFile(file);
        
        outputStrategy = new CsvOutput();
        outputStrategy.setFile(file);
    }
     
    
    
    
    
    public String readFileAsString(){
        inputStrategy.readFile();
        return "test";
    }   
    
    public LinkedHashMap readFileAsLinkedHashMap(){
        //Need to add code here!       
        return new LinkedHashMap();
    }
    
    
    public void writeFile(){
        outputStrategy.writeFile(new String()); //:D
    }

    public static void main(String[] args) {
        System.out.println("Test");
    }
    
    
    
    
}
