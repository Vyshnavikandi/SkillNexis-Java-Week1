import java.util.Scanner;

public class BankManagement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double balance = 0;
        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("     BANK MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter deposit amount: ");
                    double deposit = scanner.nextDouble();

                    if (deposit > 0) {
                        balance = balance + deposit;
                        System.out.println("Amount deposited successfully!");
                    } else {
                        System.out.println("Invalid deposit amount!");
                    }
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdraw = scanner.nextDouble();

                    if (withdraw <= 0) {
                        System.out.println("Invalid withdrawal amount!");
                    } else if (withdraw > balance) {
                        System.out.println("Insufficient balance!");
                    } else {
                        balance = balance - withdraw;
                        System.out.println("Withdrawal successful!");
                    }
                    break;

                case 3:
                    System.out.println("Current Balance: " + balance);
                    break;

                case 4:
                    System.out.println("Thank you for using Bank Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}