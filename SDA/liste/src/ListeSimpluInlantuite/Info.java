package ListeSimpluInlantuite;
//import java.util.*;

public class Info {
	
	private int number;
	private String s;
	
	public Info(int n,String str)
	{
		this.number=n;
		this.s=str;
	}
	
	public Info()
	{
	
	}
	
	public void setInfo(int n,String str)
	{
		this.number=n;
		this.s=str;
	}
	
	public int getInfoNumber()
	{
		return this.number;
	}
	
	public String getInfoString()
	{
		return this.s;
	}
}
