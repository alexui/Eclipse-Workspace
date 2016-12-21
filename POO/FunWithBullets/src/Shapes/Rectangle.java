package Shapes;

import Constants.Symbols;
import Screen.Screen;

public class Rectangle extends BasicShape{

	protected Point 
				v11,
				v12,
				v21,
				v22;
	
	

	@Override
	public void draw(Screen screen, int ref, Point centerGrav) {

		v11=new Point(centerGrav.getX()-2*ref, centerGrav.getY()-ref);
		v12=new Point(centerGrav.getX()+2*ref, centerGrav.getY()-ref);
		v21=new Point(centerGrav.getX()-2*ref, centerGrav.getY()+ref);
		v22=new Point(centerGrav.getX()+2*ref, centerGrav.getY()+ref);
		
		screen.drawLineOnScreen(v11, v12, Symbols.RECTANGLE_SYMBOL);
		screen.drawLineOnScreen(v11, v21, Symbols.RECTANGLE_SYMBOL);
		screen.drawLineOnScreen(v12, v22, Symbols.RECTANGLE_SYMBOL);
		screen.drawLineOnScreen(v21, v22, Symbols.RECTANGLE_SYMBOL);
	}
}
