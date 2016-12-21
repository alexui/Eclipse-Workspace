package Exemplul4;

import java.io.*;
public class office
{
public static void main(String[] args) throws IOException
	{
	BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("enter the current tax rate");
	int t_rate=Integer.parseInt(b.readLine());
	System.out.println("enter the current tax rate in Decimal");
	double tr=Double.parseDouble(b.readLine());
	employee obj=new employee(t_rate,tr);
	obj.info();
	obj.show();
	}
}
