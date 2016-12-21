package Shapes;

import Constants.Symbols;
import Screen.Screen;

public class Square extends Rectangle{

	@Override
	public void draw(Screen screen, int ref, Point centerGrav) {

		v11=new Point(centerGrav.getX()-ref, centerGrav.getY()-ref);
		v12=new Point(centerGrav.getX()+ref, centerGrav.getY()-ref);
		v21=new Point(centerGrav.getX()-ref, centerGrav.getY()+ref);
		v22=new Point(centerGrav.getX()+ref, centerGrav.getY()+ref);
		
		screen.drawLineOnScreen(v11, v12, Symbols.SQUARE_SYMBOL);
		screen.drawLineOnScreen(v11, v21, Symbols.SQUARE_SYMBOL);
		screen.drawLineOnScreen(v12, v22, Symbols.SQUARE_SYMBOL);
		screen.drawLineOnScreen(v21, v22, Symbols.SQUARE_SYMBOL);
	}
}
