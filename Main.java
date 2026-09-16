import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeTracker tracker = new GradeTracker();
        boolean running = true;

        while (running) {
            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Score to Student");
            System.out.println("3. View Summary Report");
            System.out.println("4. View Class Average");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter roll number: ");
                    String roll = sc.nextLine().trim();
                    if (tracker.findStudent(roll) != null) {
                        System.out.println("A student with this roll number already exists.");
                        break;
                    }
                    System.out.print("Enter name: ");
                    String name = sc.nextLine().trim();
                    tracker.addStudent(new Student(name, roll));
                    System.out.println("Student added.");
                    break;

                case 2:
                    System.out.print("Enter roll number: ");
                    String rollForScore = sc.nextLine().trim();
                    Student student = tracker.findStudent(rollForScore);
                    if (student == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    System.out.print("Enter score: ");
                    try {
                        double score = Double.parseDouble(sc.nextLine().trim());
                        student.addScore(score);
                        System.out.println("Score added.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid score.");
                    }
                    break;

                case 3:
                    tracker.printSummaryReport();
                    break;

                case 4:
                    System.out.printf("Class Average: %.2f%n", tracker.getClassAverage());
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Choose 1-5.");
            }
        }
        sc.close();
    }
}