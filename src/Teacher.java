
import java.io.PrintWriter;

//Teacher class implements the interface class CVSPrintable
public class Teacher implements CSVPrintable {
    //private fields to store teacher info
    private String name;
    private int teacherID;
    private int phone;

    // Constructor with parameters to initialize Teacher object
    public Teacher(String name, int teacherID, int phone) {
        this.name = name;
        this.teacherID = teacherID;
        this.phone = phone;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getID() {
        return teacherID;
    }

    @Override
    public void csvPrintln(PrintWriter out) {
        out.println(name + "," + teacherID + "," + phone);
    }
}
