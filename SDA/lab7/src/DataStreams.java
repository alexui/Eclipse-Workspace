import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class DataStreams {

	public static String datafile="invoicedata.txt";
	static final double[] prices={1.2,2.5,6.4,4.2,5.5};
	static final int[] units={12,4,5,2,1};
	static final String[] prod={"Java TShirt","Java Glass","Java BackPack","Java Cap","Java Badge"};
	
	public static void main(String[] args) throws IOException {
	
	//Scanner in;
	//PrintWriter out;
		
/*		try {
			int a; 
			double d;
			String s;
			in = new Scanner(new BufferedReader(new FileReader(datafile)));
			out= new PrintWriter(new OutputStreamWriter(System.out));//sau BufferedWriter cu exceptii
			a=in.nextInt();
			d=in.nextDouble();
			s=in.next();
			//System.out.println(a+" "+d+" "+s);
			out.write(String.valueOf(a));
			out.flush();
			out.format("%na=%d , d=%f, s=%s",a,d,s);
			out.flush();
			in.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 	*/
		
	DataInputStream DataIn = new DataInputStream(new BufferedInputStream(new FileInputStream(datafile)));
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	DataOutputStream o = new DataOutputStream(new BufferedOutputStream(System.out));
	try {
		int b;
		String s=null;
		b=DataIn.readInt();
		double d;
		d=DataIn.readDouble();
	//	s=DataIn.readUTF();
	//	s=br.readLine();
	//	System.out.println("s="+s);
		System.out.println("b="+b+" d="+d+" s="+"");
		o.writeInt(b);
		DataIn.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
			
	}

}
