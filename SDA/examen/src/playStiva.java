import java.io.*;
public class playStiva {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stiva a = new Stiva(20);
		a.push(4);
		a.push(5);
		a.push(6);
		a.push(1);
		a.push(6);
		System.out.println("Stiva:");
		a.afisare(); System.out.println();
		a.pop();
		a.afisare();
		a.popCoada(); 
		System.out.println();
		a.afisare();
	}

}