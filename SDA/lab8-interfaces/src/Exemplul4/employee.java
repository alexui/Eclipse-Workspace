package Exemplul4;

class employee implements customer
{
	int tax_now;
	double tax_rate;
	employee(int a,double b)
	{
	tax_now=a;
	tax_rate=b;
	}
	public void info()
	{
	double rate;
	rate=tax*tax_now*tax_rate;
	System.out.println("Tax calculated as :"+rate);
	}
	public void show()
	{
	System.out.println("show method invoked");
}
}
