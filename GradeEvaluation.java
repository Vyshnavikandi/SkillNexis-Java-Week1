import java.util.Scanner;

public class GradeEvaluation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student marks (0-100): ");
        int marks = scanner.nextInt();

        if (marks >= 90 && marks <= 100) {
            System.out.println("Grade: A");
        }
        else if (marks >= 75) {
            System.out.println("Grade: B");
        }
        else if (marks >= 50) {
            System.out.println("Grade: C");
        }
        else if (marks >= 0) {
            System.out.println("Grade: Fail");
        }
        else {
            System.out.println("Invalid marks!");
        }

        scanner.close();
    }
}