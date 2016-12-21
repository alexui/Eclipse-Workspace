package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.PointedShape;

public class SimpleShell extends Projectile{
	
	public SimpleShell(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
		this.shape = new PointedShape();
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {

		if (dist<0) return;
		hitScreenAction(shooterPosition, this.ref);
	}

	@Override
	protected void hitScreenAction(Point shooterPosition, int ref) {

		shape.draw(screen, ref, shooterPosition);
	}

}
