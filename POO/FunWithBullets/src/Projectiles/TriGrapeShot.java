package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.Square;
import Shapes.Triangle;

public class TriGrapeShot extends Shrapnel {

	public TriGrapeShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
		this.shape = new Triangle();
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {

		if(dist<0) return;
		
		computeDistance(1, currentTime);
		
		if(dist>=shapeChangingDist){
			this.ref = newRef(1, shapeChangingDist, this.ref);
			shooterPosition=shooterPosition.translate(shapeChangingDist, 0);
			super.shape=new Square();
			super.ref=this.ref;
			super.shoot(dist-shapeChangingDist, shooterPosition);
		}
		else{
			this.ref = newRef(1, dist, this.ref);
			shooterPosition=shooterPosition.translate(dist, 0);
			hitScreenAction(shooterPosition, this.ref);
		}
	}
}
