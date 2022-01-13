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
}
