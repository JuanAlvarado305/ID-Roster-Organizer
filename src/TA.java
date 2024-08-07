
import java.io.PrintWriter;

//TA inherits fields from its parent class "Student", TA is a subclass of student
public class TA extends Student {
    private final int teacherID;

    //Class constructor with four parameters(String,int,int,long)
    public TA(String name, int studentID, int teacherID, long phone) {
        super(name, studentID, phone);
        this.teacherID = teacherID;
    }

    // Returns the student ID as integer
    @Override
    public int getID() {
        return Math.max(super.getID(), teacherID);
    }

    // Writes the "out" object's data (name, studentID, phone) to a CSV file using the PrintWriter
    @Override
    public void csvPrintln(PrintWriter out) {
        out.println(getName() + "," + getID() + "," + getPhone());
    }

    // Returns the phone number from the parent as a long
    public long getPhone() {
        return super.phone;
    }
}