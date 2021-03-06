import lib.ieris19.util.economy.Money;

public class Manual {

	public static void main(String[] args) {
		testPrecision();
		basicTesting();
		testSet();
		System.out.println(5D);
		Money money = new Money(50.50);
		System.out.println(money.getAmount());
		System.out.println(money);
		money.subtractMoney(0.50, true);
		System.out.println(money.getAmount());
		System.out.println(money);
	}

	public static void testSet() {
		Money wallet = new Money(5);
		System.out.println(wallet);
		wallet.setAmount(5.4);
		System.out.println(wallet);
		wallet.setAmount(5.00521);
		System.out.println(wallet);
		System.out.println("True value: " + wallet.getAmount());
	}

	public static void testPrecision() {
		Money account = new Money(0);
		for (int i = 0; i < 10000; i++) {
			System.out.println(account.getAmount());
			account.addMoney(0.2545);
		}
	}

	public static void basicTesting() {
		Money wallet = new Money(100);
		Money account = new Money(300);
		System.out.println("Account: " + account);
		System.out.println("Wallet: " + wallet);
		Money.transfer(wallet, account, 50.2512);
		System.out.println(wallet);
		System.out.println(account);
		wallet.addMoney(100);
		System.out.println(wallet);
		System.out.println(account);
	}
}
/*
	System.out.println(wallet);
			try {
				wallet.setBalance(Integer.MAX_VALUE);
			} catch (Exception exception) {
				exception.printStackTrace(System.err);
			}
			System.out.println("Why is the stack trace later?");
			int max = Integer.MAX_VALUE;
			max = max + 1000000000;
			System.out.println(max);
*/