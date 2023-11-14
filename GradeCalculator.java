import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numSubjects = 5;
        int totalMarks = 0;
        int[] marks = new int[numSubjects];
        String[] subjects = {"Maths", "Science", "English", "Social Science" , "Hindi"};
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in " + subjects[i] + ": ");
            marks[i] = input.nextInt();
            totalMarks += marks[i];
        }
        double averagePercentage = (double) totalMarks / numSubjects;
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+ (Outstanding)";
        } else if (averagePercentage >= 80) {
            grade = "A (Excellent)";
        } else if (averagePercentage >= 70) {
            grade = "B+ (Very Good)";
        } else if (averagePercentage >= 60) {
            grade = "B (Good)";
        } else if (averagePercentage >= 50) {
            grade = "C+ (Above Average)";
        } else if (averagePercentage >=40) {
            grade = "C (Average)";
        } else {
            grade = "F (Needs Improvement)";
        }
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);
    }
}