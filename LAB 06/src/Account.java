public class Account {
    public int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public synchronized void withdraw(int amount) {
        try{
            if(balance >= amount) {
                balance -= amount;
                System.out.println("$" + amount + " has been withdrawn from your account!");
            } else {
                System.out.println("Insufficient Funds");
            }
            Thread.sleep(100);
        }catch(InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
    public synchronized void deposit(int amount){
        try{
            balance += amount;
            System.out.println("$" + amount + " has been deposited into your account!");
            Thread.sleep(1000);
        }catch(InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
