
import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    // Method to add a new student to the database
    public void addStudent(Student student) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO students (id, first_name, last_name, email, midterm1_score, midterm2_score, assignment_scores) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, student.getId());
            statement.setString(2, student.getFirstName());
            statement.setString(3, student.getLastName());
            statement.setString(4, student.getEmail());
            statement.setInt(5, student.getMidterm1Score());
            statement.setInt(6, student.getMidterm2Score());
            // Convert assignment scores array to string
            String assignmentScoresString = arrayToString(student.getAssignmentScores());
            statement.setString(7, assignmentScoresString);
            statement.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Helper method to convert array to string
    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    // Method to fetch a student by ID from the database
    public Student getStudentById(int id) {
        Student student = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM students WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                student = extractStudentFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    // Helper method to extract student from ResultSet
    private Student extractStudentFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        int midterm1Score = resultSet.getInt("midterm1_score");
        int midterm2Score = resultSet.getInt("midterm2_score");
        String email = resultSet.getString("email");
        String[] assignmentScoresString = resultSet.getString("assignment_scores").split(",");
        int[] assignmentScores = new int[assignmentScoresString.length];
        for (int i = 0; i < assignmentScoresString.length; i++) {
            assignmentScores[i] = Integer.parseInt(assignmentScoresString[i]);
        }
        return new Student(id, firstName, lastName, midterm1Score, midterm2Score, assignmentScores);
    }

    // Method to remove a student by ID from the database
    public void removeStudentById(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
