import java.io.*;

// Step 1: Student class implementing Serializable
class Student implements Serializable {
    private static final long serialVersionUID = 1L;  // Recommended

    private int studentID;
    private String name;
    private String grade;

    // Constructor
    public Student(int studentID, String name, String grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    // Method to display student info
    public void displayInfo() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
    }
}

// Step 2: Main class for serialization & deserialization
public class SerializationDemo {
    public static void main(String[] args) {
        String filename = "student.ser";

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            Student student1 = new Student(101, "Ayush Rana", "A");
            oos.writeObject(student1);
            System.out.println("Serialization successful. Object saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Student deserializedStudent = (Student) ois.readObject();
            System.out.println("\nDeserialization successful. Student details:");
            deserializedStudent.displayInfo();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
