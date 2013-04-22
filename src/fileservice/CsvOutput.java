package fileservice;

import abstraction.OutputStrategy;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

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

    @Override
    public void writeFile(List<LinkedHashMap<String, String>> linkedHashMap) throws IOException {

	boolean append = true;
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(this.file, append)));
	String printString = "";


	//loop through all rows
	for (LinkedHashMap h : linkedHashMap) {
	    //loop through all the values
	    Collection c = h.values();
	    Iterator itr = c.iterator();
	    int i = 0;
	    while (itr.hasNext()) {
		printString = printString + itr.next();
		i++;
		//print commas inbetween
		if (i != h.size()) {
		    printString = printString + ",";
		} else {
		    printString = printString + "\n";;
		}
	    }
	}


	out.println(printString);
	out.close();
    }

    @Override
    public File getFile() {
	return this.file;
    }

    public static void main(String[] args) throws IOException {

	//get list from existing file
	CsvInput in = new CsvInput();
	File f = new File("src/test_comma_only.csv"); //normally pass this in through GUI

	//3 steps: set, read, get
	in.setFile(f);
	in.readFile();
	in.getList(); //demonstration only

	CsvOutput c = new CsvOutput();
	f = new File("src/test_output.csv"); //normally pass this in through GUI

	c.setFile(f);

	c.writeFile(in.getList());


    }
}
