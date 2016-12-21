package lab6;

public class Account {

	protected double balance;
	
	public Account(double a)
	{
		balance =a;
	}
	
	public Account()
	{
		balance = 0.0;
	}
	
	public void deposit( double amount )
	{
	balance += amount;
	}
	
	public double withdraw( double amount )
	{
	// See if amount can be withdrawn
	if (balance >= amount)
	{
	balance -= (amount + comission(amount));
	return amount;
	}
	else
	// Withdrawal not allowed
	return 0.0;
	}
	
	private double comission (double amount)
	{
		return ((5*amount)/100);
	}
	
	public double interest ()
	{
		return ((5*balance)/100);
	}
	
	public double getbalance()
	{
	return balance;
	}
}
