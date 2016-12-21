package lab6;

public class Tema4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create an empty account 
		Account my_account = new Account(); 
		// Deposit money 
		my_account.deposit(250.00); 
		// Print current balance
		System.out.println ("Current balance " + my_account.getbalance());
		// interest
		System.out.println("Interest 5% : "+my_account.interest());
		// Withdraw money + comission
		my_account.withdraw(80.00);
		// Print remaining balance 
		System.out.println ("Remaining balance " + my_account.getbalance());
		
	}

}
