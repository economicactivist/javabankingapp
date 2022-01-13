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

    void showMenu() {
        char option = '\0';
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome" + customerName + "!");
        System.out.println("Enter 1 to make a deposit");
        System.out.println("Enter 2 to make a withdrawal");
        System.out.println("Enter 3 to see your previous transaction");
        System.out.println("Enter 4 to calculate your interest");
        System.out.println("Enter 5 to exit");
        option = input.next().charAt(0);
       
        switch(option) {
            case '1':
                System.out.println("Enter the amount to deposit");
                int amount = input.nextInt();
                deposit(amount);
                showMenu();
                break;
            case '2':
                System.out.println("Enter the amount to withdraw");
                amount = input.nextInt();
                withdraw(amount);
                showMenu();
                break;
            case '3':
                getPreviousTransaction();
                showMenu();
                break;
            case '4':
                System.out.println("Enter the number of years");
                int years = input.nextInt();
                calculateInterest(years);
                showMenu();
                break;
            case '5':
                System.out.println("Thank you for banking with us!");
                break;
            default:
                System.out.println("Invalid option");
                showMenu();
                break;
        }
    }
}

