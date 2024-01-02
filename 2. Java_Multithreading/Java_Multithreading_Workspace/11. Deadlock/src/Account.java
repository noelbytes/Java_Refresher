
public class Account {
	private int balance = 10000;
	
	public void deposit(int amount) {
		balance += amount;
	}
	
	public void withdraw(int amount) {
		balance -= amount;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public static void transfer(Account account1, Account account2, int amount, String thread) {
		System.out.println("Amount for " + thread + " = " + amount);
		account1.withdraw(amount);
		account2.deposit(amount);
	}
}
