import java.util.Scanner;


public class Account {
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    Account(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    void deposit(int amount) {
        if(amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if(amount != 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if(previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if(previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction was made");
        }
    }

    void calculateInterest(int years) {
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is" + (100 * interestRate));
        System.out.println("After " + years + " years, the balance is " + newBalance);
    }

   void showBalance() {
        System.out.println("The balance is " + balance);
    }

    void showMenu() {
        System.out.println("1. Show Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Get Previous Transaction");
        System.out.println("5. Calculate Interest");
        System.out.println("6. Quit");
    }

    void showMenu(Scanner input) {
        int choice = 1;
        while(choice != 6) {
            System.out.println("Enter a choice: ");
            choice = input.nextInt();
            switch(choice) {
                case 1:
                    showBalance();
                    break;
                case 2:
                    System.out.println("Enter an amount to deposit: ");
                    int amount = input.nextInt();
                    deposit(amount);
                    break;
                case 3:
                    System.out.println("Enter an amount to withdraw: ");
                    amount = input.nextInt();
                    withdraw(amount);
                    break;
                case 4:
                    getPreviousTransaction();
                    break;
                case 5:
                    System.out.println("Enter the number of years: ");
                    int years = input.nextInt();
                    calculateInterest(years);
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

