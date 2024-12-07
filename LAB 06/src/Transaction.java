public class Transaction implements Runnable {

    public Account account;

    public Transaction(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            account.withdraw(200);
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        account.deposit(350);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println("Your new balance is: $" + account.getBalance());
    }
}
