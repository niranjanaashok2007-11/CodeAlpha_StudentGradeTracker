import java.util.ArrayList;
import java.util.List;

public class GradeTracker {
    private List<Student> students;

    public GradeTracker() {
        students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public Student findStudent(String rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber().equalsIgnoreCase(rollNumber)) {
                return s;
            }
        }
        return null;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void printSummaryReport() {
        if (students.isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }
        System.out.println("\n===== SUMMARY REPORT =====");
        System.out.printf("%-10s %-15s %-10s %-10s %-10s%n",
                "Roll No", "Name", "Average", "Highest", "Lowest");
        for (Student s : students) {
            System.out.printf("%-10s %-15s %-10.2f %-10.2f %-10.2f%n",
                    s.getRollNumber(), s.getName(), s.getAverage(), s.getHighest(), s.getLowest());
        }
        System.out.println("===========================\n");
    }

    public double getClassAverage() {
        if (students.isEmpty()) return 0.0;
        double total = 0;
        for (Student s : students) total += s.getAverage();
        return total / students.size();
    }
}