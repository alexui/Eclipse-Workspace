
public class Kindergarten {

	/**
	 * @param args
	 */
	static long MULT(long x,long y)
	{
		long a,b,c,d,e,f;
		String X;
		String Y;
		X=String.valueOf(x);
		Y=String.valueOf(y);
		if(X.length()==1 && Y.length()==1)
			return x*y;
		a=(long)(x/Math.pow(10,(X.length()+1)/2));
		b=(long)(x%Math.pow(10,(X.length()+1)/2));
		c=(long)(y/Math.pow(10,(Y.length()+1)/2));
		d=(long)(y%Math.pow(10,(Y.length()+1)/2));
		e=MULT(a,c);
		f=MULT(b,d);
		long n = (long)(Math.pow(2,((Math.max(X.length(),Y.length())+1)/2))); 
		return e*(long)(Math.pow(10,n))//
				+(MULT(a+b,c+d)-e-f)*(long)(Math.pow(10,n/2))+f;
		
	}
	
	public static void main(String[] args) {
		

		long x,y,rez;
		x=131;
		y=50;
		rez=MULT(x,y);
		System.out.println("rez="+rez);
	}

}
