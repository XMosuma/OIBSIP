package ATM;
import java.util.Scanner;

class ATM {
    private User currentUser;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter User PIN: ");
        String userPin = scanner.nextLine();

        authenticateUser(userId, userPin);

        if (currentUser != null) {
            performTransactions();
        }

        scanner.close();
    }

    private void authenticateUser(String userId, String userPin) {
        // Authenticate the user (You may use a database for this in a real-world scenario)
        // For simplicity, using hardcoded values
        if ("123456".equals(userId) && "7890".equals(userPin)) {
            currentUser = new User(userId, userPin, 1000.0); // Initial balance is 1000.0 for demo
            System.out.println("Login successful. Welcome, " + userId + "!");
        } else {
            System.out.println("Authentication failed. Invalid User ID or PIN.");
        }
    }

    private void performTransactions() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: $" + currentUser.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    currentUser.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: $" + currentUser.getBalance());
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    currentUser.withdraw(withdrawalAmount);
                    System.out.println("Withdrawal successful. New balance: $" + currentUser.getBalance());
                    break;
                case 4:
                    System.out.print("Enter recipient's User ID: ");
                    String recipientId = scanner.next();
                    System.out.print("Enter transfer amount: $");
                    double transferAmount = scanner.nextDouble();

                    User recipient = new User(recipientId, "", 0.0); // For demo, create a new user (replace with a real authentication process)
                    currentUser.transfer(recipient, transferAmount);

                    System.out.println("Transfer successful. New balance: $" + currentUser.getBalance());
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");
        System.out.print("Choose an option (1-5): ");
    }
}