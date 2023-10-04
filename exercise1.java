import java.util.Scanner;

class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int accountNumber = 0;
        double initialBalance = 0.0;

        boolean validAccountNumber = false;
        boolean validInitialBalance = false;

        // Input validation loop for account number
        while (!validAccountNumber) {
            try {
                System.out.print("Enter account number: ");
                accountNumber = scanner.nextInt();
                validAccountNumber = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric account number.");
                scanner.next(); // Clear the invalid input
            }
        }

        scanner.nextLine(); // Consume newline character

        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();

        // Input validation loop for initial balance
        while (!validInitialBalance) {
            try {
                System.out.print("Enter initial balance: $");
                initialBalance = scanner.nextDouble();
                if (initialBalance >= 0) {
                    validInitialBalance = true;
                } else {
                    System.out.println("Invalid input. Please enter a non-negative initial balance.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid numeric initial balance.");
                scanner.next(); // Clear the invalid input
            }
        }

        BankAccount account = new BankAccount(accountNumber, accountHolderName, initialBalance);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nBank Account Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1/2/3/4): ");
            
            int choice = 0;
            boolean validChoice = false;

            // Input validation loop for choice
            while (!validChoice) {
                try {
                    System.out.print("Enter your choice (1/2/3/4): ");
                    choice = scanner.nextInt();
                    if (choice >= 1 && choice <= 4) {
                        validChoice = true;
                    } else {
                        System.out.println("Invalid choice. Please enter a valid option (1/2/3/4).");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid numeric choice.");
                    scanner.next(); // Clear the invalid input
                }
            }


            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid numeric amount.");
                        scanner.next(); // Clear the invalid input
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        account.withdraw(withdrawalAmount);
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid numeric amount.");
                        scanner.next(); // Clear the invalid input
                    }
                    break;
                case 3:
                    System.out.println("Account Balance: $" + account.getBalance());
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Thank you for using our bank services!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }
}
