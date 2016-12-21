
public class RectExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Rectangle myR = new Rectangle();
		System.out.println("Coordinates myR: "+myR.origin.x+" , "+myR.origin.y);
		System.out.println(myR.height+" , "+ myR.width);
		
		Rectangle yourR = new Rectangle(4,5);
		System.out.println("Dimensions yourR:"+yourR.width+" , "+yourR.height);
		System.out.println("Diagonal: "+yourR.getDiagonal());
		
		Point oneOrigin = new Point(2,4);
		System.out.println("Coordinates myR: "+myR.origin.x+" , "+myR.origin.y);
		
		Rectangle hisR = new Rectangle(oneOrigin,10,7);
		System.out.println("Dimensions hisR: "+hisR.width+" , "+hisR.height);
		System.out.println("Coordinates hisR: "+hisR.origin.x+" , "+hisR.origin.y);
		
		Rectangle herR = new Rectangle(40,67);
		herR.origin = new Point (5,7);
		System.out.println("Dimensions herR: "+herR.width+" , "+herR.height);
		System.out.println("Coordinates herR: "+herR.origin.x+" , "+herR.origin.y);
		
		System.out.println("Area = "+ Integer.toString(herR.getArea(6,8)));
		
		
	
	}

}
