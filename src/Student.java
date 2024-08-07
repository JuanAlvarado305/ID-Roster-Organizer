
import java.io.PrintWriter;

//Superclass or parent class to TA
//Student class implements the interface class that is in its own interface .java file
public class Student implements CSVPrintable {
    private String name;
    private int studentID;
    public long phone;

    //Class constructor with 3 parameters
    public Student(String name, int studentID, long phone) {
        this.name = name;
        this.studentID = studentID;
        this.phone = phone;
    }

    @Override
    public String getName() {
        return name;
    }

    //gets overridden by child class TA
    @Override
    public int getID() {
        return studentID;
    }

    //gets overridden by child class TA
    @Override
    public void csvPrintln(PrintWriter out) {
        out.println(name + "," + studentID + "," + phone);
    }
}