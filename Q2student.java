package cpm.projectday23;
//Student Grade Management SystemDescription: Manage student details, courses, and calculate grades.

//Features:Classes: Student, Course, Grade.Methods: Add student/course, assign grades, calculate GPA.Collections framework (ArrayList/HashMap) for data storage.

import java.util.*;
class Course {
    private String courseCode;
    private String courseTitle;

    public Course(String courseCode, String courseTitle) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    @Override
    public String toString() {
        return courseCode + " - " + courseTitle;
    }
}

class Student {
    private int studentId;
    private String studentName;
    private Map<Course, Double> courseGrades; // Maps courses to grades

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseGrades = new HashMap<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void assignGrade(Course course, double grade) {
        courseGrades.put(course, grade);
        System.out.println("Grade " + grade + " assigned for course " + course.getCourseTitle() + " to " + studentName);
    }

    public double calculateGPA() {
        if (courseGrades.isEmpty()) {
            return 0.0;
        }
        double totalGrades = 0;
        for (double grade : courseGrades.values()) {
            totalGrades += grade;
        }
        return totalGrades / courseGrades.size();
    }

    public void displayGrades() {
        System.out.println("Grades for " + studentName + ":");
        for (Map.Entry<Course, Double> entry : courseGrades.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + studentName + ", GPA: " + calculateGPA();
    }
}

public class Q2student {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Course pythonCourse = new Course("CS201", "Python Programming");
        Course oopCourse = new Course("CS202", "Object-Oriented Programming");
        Course mlCourse = new Course("CS203", "Machine Learning");

        // Create a student with a new name
        Student student = new Student(2, "John");

        // Assign grades
        student.assignGrade(pythonCourse, 92.5);
        student.assignGrade(oopCourse, 88.0);
        student.assignGrade(mlCourse, 79.5);

        // Display grades and GPA
        student.displayGrades();
        System.out.println("GPA: " + student.calculateGPA());

        scanner.close();
    }
}
