import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

class MyClass{
	
	public void method1(final int a,int b){
		System.out.println("a="+a);
		System.out.println("b="+b);
		//a++; error
		b++;
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
}

public class Print {

	public static void main(String[] args) throws IOException {
		
		BufferedWriter b = new BufferedWriter(new OutputStreamWriter(System.out));

		PrintWriter p = new PrintWriter(new OutputStreamWriter(System.out));
		p.print(2);
		p.write(65);
		p.close();
		

	/*	b.flush();
		b.newLine();
		b.write('a');
		b.write("alex");
		b.close();*/
		
	}
}
