


package abstraction;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * 
 * @author jryder
 * 
 *
 */
public interface InputStrategy {
    
    public abstract void setFile(File file);
    public abstract void readFile();
    public abstract File getFile();
    public List<LinkedHashMap<String, String>> getList();
    
   
}
