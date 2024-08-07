
//Import Printwriter package
import java.io.PrintWriter;

public interface CSVPrintable {
    // Declare a method to get name (returns String)
    String getName();

    //get the ID (returns int)
    int getID();

    // Declare a method to print CSV data to a PrintWriter
    void csvPrintln(PrintWriter out);
}