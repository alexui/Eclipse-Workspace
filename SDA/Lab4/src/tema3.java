import java.awt.Color;

public class tema3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Picture pic=new Picture();
		pic.load("D:\\Documente\\Picture (1).jpg");
		int i,j;
		for(i=0;i<pic.getWidth();i++)
			for(j=0;j<pic.getHeight();j++)
				{
				Color original = pic.getColorAt(i, j);
				Color negative = new Color(255-original.getRed(),255-original.getBlue(),//
						255-original.getGreen());
				pic.setColorAt(i, j, negative);
				}
		// se poate da reload pic.reload
		//pic.reload();

	}

}
