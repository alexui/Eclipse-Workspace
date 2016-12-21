package Shapes;

import Constants.Symbols;
import Screen.Screen;

public class Triangle extends BasicShape{

	private Point 
				vsus,
				vdreapta,
				vstanga;


	@Override
	public void draw(Screen screen, int ref, Point centerGrav) {

		vsus=new Point(centerGrav.getX(), centerGrav.getY()-2*ref);
		vdreapta=new Point(centerGrav.getX()+ref, centerGrav.getY()+ref);
		vstanga=new Point(centerGrav.getX()-ref, centerGrav.getY()+ref);
		
		screen.drawLineOnScreen(vsus, vstanga, Symbols.TRIANGLE_SYMBOL);
		screen.drawLineOnScreen(vsus, vdreapta, Symbols.TRIANGLE_SYMBOL);
		screen.drawLineOnScreen(vstanga, vdreapta, Symbols.TRIANGLE_SYMBOL);
	}
}
