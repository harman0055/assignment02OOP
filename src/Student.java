import java.util.Calendar;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int midterm1Score;
    private int midterm2Score;
    private int[] assignmentScores;

    // Constructor
    public Student(int id, String firstName, String lastName, int midterm1Score, int midterm2Score, int[] assignmentScores) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.midterm1Score = midterm1Score;
        this.midterm2Score = midterm2Score;
        this.assignmentScores = assignmentScores;
        this.email = generateEmail(firstName, lastName);
    }

    // Generate email
    private String generateEmail(String firstName, String lastName) {
        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String monthOfBirth = monthNames[Calendar.getInstance().get(Calendar.MONTH)];
        return firstName.toLowerCase() + monthOfBirth + lastName.toLowerCase() + "@algomail.com";
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getMidterm1Score() {
        return midterm1Score;
    }

    public void setMidterm1Score(int midterm1Score) {
        this.midterm1Score = midterm1Score;
    }

    public int getMidterm2Score() {
        return midterm2Score;
    }

    public void setMidterm2Score(int midterm2Score) {
        this.midterm2Score = midterm2Score;
    }

    public int[] getAssignmentScores() {
        return assignmentScores;
    }

    public void setAssignmentScores(int[] assignmentScores) {
        this.assignmentScores = assignmentScores;
    }
}
