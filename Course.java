import java.util.Arrays;

public class Course {
    private String courseName;
    private String[] students;
    private int numberOfStudents;


    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new String[10]; // Initial capacity of 10
        this.numberOfStudents = 0;
    }


    public String getCourseName() {
        return courseName;
    }


    public void addStudent(String student) {
        if (numberOfStudents >= students.length) {
            String[] temp = new String[students.length * 2];
            System.arraycopy(students, 0, temp, 0, students.length);
            students = temp;
        }
        students[numberOfStudents] = student;
        numberOfStudents++;
    }


    public void dropStudent(String student) {
        int index = -1;
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            // Shift elements to the left to fill the gap
            for (int i = index; i < numberOfStudents - 1; i++) {
                students[i] = students[i + 1];
            }
            students[numberOfStudents - 1] = null;
            numberOfStudents--;
        }
    }


    public String[] getStudents() {
        return Arrays.copyOf(students, numberOfStudents);
    }


    public int getNumberOfStudents() {
        return numberOfStudents;
    }
}