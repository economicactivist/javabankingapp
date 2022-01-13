public class FirstBank{
    public static void main(String[] args) {
        System.out.println("First Bank");
        Account tim = new Account("Tim", "12345");
        tim.deposit(100);
        tim.showMenu();
    
    }
}


