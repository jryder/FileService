package fileservice;

import abstraction.OutputStrategy;
import java.io.File;
import java.util.LinkedHashMap;

/**
 *
 * @author jryder
 *
 *
 * // use linked list to pass into the writer // regular maps do not maintain
 * order // list<linkedhashmap<string,string>> // overload this! :D Then the
 * user can go the cheap route or the good route
 *
 *
 *
 */
public class CsvOutput implements OutputStrategy {

    File file;

    @Override
    public void setFile(File file) {
	this.file = file;
    }

    /**
     * String needs to be separated by commas
     *
     * @param string
     */
    @Override
    public void writeFile(String string) {
    }
    
    

    @Override
    public void writeFile(LinkedHashMap linkedHashMap) {
    }

    
    
    @Override
    public File getFile() {
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
