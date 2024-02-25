rimport java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        calculateStudentGrade();
    }

    public static void calculateStudentGrade() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Grade Calculator");
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int totalMarks = 0;

        for (int i = 1; i <= numSubjects; i++) {
            System.out.printf("Enter marks obtained in subject %d (out of 100): ", i);
            int subjectMarks = scanner.nextInt();
            if (subjectMarks < 0 || subjectMarks > 100) {
                System.out.println("Invalid input! Marks should be between 0 and 100. Please try again.");
                i--;
            } else {
                totalMarks += subjectMarks;
            }
        }

        double averagePercentage = (double) totalMarks / numSubjects;

        System.out.printf("%nResults:%n");
        System.out.printf("Total Marks: %d%n", totalMarks);
        System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
        System.out.println("Grade: " + calculateGrade(averagePercentage));
    }

    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
