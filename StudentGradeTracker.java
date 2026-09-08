import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    static class Student {
        String name;
        int grade;

        Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("======================================");
        System.out.println("       STUDENT GRADE TRACKER");
        System.out.println("======================================");

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfStudents; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            int grade;

            while (true) {
                System.out.print("Enter grade (0 - 100): ");
                grade = scanner.nextInt();

                if (grade >= 0 && grade <= 100) {
                    break;
                }

                System.out.println(
                    "Invalid grade! Please enter a value between 0 and 100."
                );
            }

            scanner.nextLine();
            students.add(new Student(name, grade));
        }

        int highest = students.get(0).grade;
        int lowest = students.get(0).grade;
        int total = 0;

        for (Student student : students) {
            total += student.grade;

            if (student.grade > highest) {
                highest = student.grade;
            }

            if (student.grade < lowest) {
                lowest = student.grade;
            }
        }

        double average = (double) total / students.size();

        System.out.println("\n======================================");
        System.out.println("          STUDENT SUMMARY REPORT");
        System.out.println("======================================");

        System.out.printf("%-20s %-10s%n", "Student Name", "Grade");
        System.out.println("--------------------------------------");

        for (Student student : students) {
            System.out.printf("%-20s %-10d%n",
                    student.name, student.grade);
        }

        System.out.println("--------------------------------------");
        System.out.printf("Average Grade : %.2f%n", average);
        System.out.println("Highest Grade : " + highest);
        System.out.println("Lowest Grade  : " + lowest);

        System.out.println("======================================");
        System.out.println("       Report Generated Successfully");
        System.out.println("======================================");

        scanner.close();
    }
}
