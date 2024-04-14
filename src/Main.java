import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager databaseManager = new DatabaseManager();

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add a new student");
            System.out.println("2. List all students");
            System.out.println("3. Fetch a single student by ID");
            System.out.println("4. Change a single student information by ID");
            System.out.println("5. Remove a single student from the database by ID");
            System.out.println("6. Stats Summary");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addNewStudent(databaseManager, scanner);
                    break;
                case 2:
                    fetchStudentByID(databaseManager, scanner);
                    break;
                case 3:
                    changeStudentInfoByID(databaseManager, scanner);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
        scanner.close();
    }

    private static void addNewStudent(DatabaseManager databaseManager, Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Enter student first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter student last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter student's score for Midterm 1: ");
        int midterm1Score = scanner.nextInt();

        System.out.print("Enter student's score for Midterm 2: ");
        int midterm2Score = scanner.nextInt();

        int[] assignmentScores = new int[]{}; // You need to decide the size or dynamically handle it
        // You may want to loop through assignments to get scores

        // Create the student object and add it to the database
        Student student = new Student(id, firstName, lastName, midterm1Score, midterm2Score, assignmentScores);
        databaseManager.addStudent(student);
    }

    private static void fetchStudentByID(DatabaseManager databaseManager, Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        databaseManager.getStudentById(id);
    }

    private static void changeStudentInfoByID(DatabaseManager databaseManager, Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
    }}