package Shapes;

import Constants.Symbols;
import Screen.Screen;

public class PointedShape extends BasicShape {

	
	@Override
	public void draw(Screen screen, int ref, Point centerGrav) {

		screen.drawLineOnScreen(centerGrav, centerGrav, Symbols.DOT_SYMBOL);
	}

}
