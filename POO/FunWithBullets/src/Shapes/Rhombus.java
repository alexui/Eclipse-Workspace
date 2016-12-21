package Shapes;

import Constants.Symbols;
import Screen.Screen;

public class Rhombus extends BasicShape{

	private Point 
				vsus,
				vjos,
				vstanga,
				vdreapta;

	@Override
	public void draw(Screen screen, int ref, Point centerGrav) {

		vsus=new Point(centerGrav.getX(), centerGrav.getY()-2*ref);
		vjos=new Point(centerGrav.getX(), centerGrav.getY()+2*ref);
		vdreapta=new Point(centerGrav.getX()+ref, centerGrav.getY());
		vstanga=new Point(centerGrav.getX()-ref, centerGrav.getY());
		
		screen.drawLineOnScreen(vsus,vstanga, Symbols.RHOMBUS_SYMBOL);
		screen.drawLineOnScreen(vsus,vdreapta, Symbols.RHOMBUS_SYMBOL);
		screen.drawLineOnScreen(vstanga,vjos, Symbols.RHOMBUS_SYMBOL);
		screen.drawLineOnScreen(vdreapta,vjos, Symbols.RHOMBUS_SYMBOL);
	}
}
