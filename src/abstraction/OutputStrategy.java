/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstraction;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author jryder
 */
public interface OutputStrategy {
    public abstract void setFile(File filename);
    public abstract void writeFile(List<LinkedHashMap<String, String>> linkedHashMap) throws IOException;
    //public abstract void writeFile(String string)throws IOException ;  add this later
    public abstract File getFile();
}
