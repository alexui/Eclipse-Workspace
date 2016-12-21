package DataInputStream;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.print.DocFlavor.BYTE_ARRAY;

public class Data_Input_Stream {

	
	public static void main(String[] args) throws IOException {

		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("PrimitiveData.txt"));
		DataInputStream in = null;
		long a = 1234342345;
		int b = 244;
		char c = 'c';
		String s = "alex";
		
		out.write(b);
		out.flush();
		out.close();
		
		in = new DataInputStream(new FileInputStream("PrimitiveData.txt"));
		System.out.println(in.read());
		in.close();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("PrimitiveData2.txt"));
		bw.write(String.valueOf(a));
		bw.newLine();
		bw.write(String.valueOf(b));
		bw.newLine();
		bw.flush();
		
		bw = new BufferedWriter(new FileWriter("PrimitiveData3.txt"));
		bw.write(c);
		bw.write(s);
		bw.flush();
		
		in = new DataInputStream(new FileInputStream("PrimitiveData2.txt"));
		System.out.println(Long.valueOf(in.readLine()));
		
		FileOutputStream fout = new FileOutputStream("Data.txt");
		FileInputStream fin = new FileInputStream("PrimitiveData2.txt");
		
		fout.write(fin.read());
		fout.write(fin.read());
		fout.write(fin.read());
		fout.write(fin.read());
		fout.close();
		
		fin.close();
		bw.close();
		
	}

}
