


package abstraction;

import java.io.File;
//import java.util.LinkedHashMap;

/**
 * 
 * @author jryder
 * 
 *
 */
public interface InputStrategy {
    
   
    public abstract void setFile(File file);
    public abstract void readFile();

    
   
}
