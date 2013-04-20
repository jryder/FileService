/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstraction;

import java.io.File;
import java.util.LinkedHashMap;

/**
 *
 * @author jryder
 */
public interface OutputStrategy {
    public abstract void setFile(File filename);
    public abstract void writeFile(LinkedHashMap linkedHashMap);
    public abstract void writeFile(String string);
    public abstract File getFile();
}
