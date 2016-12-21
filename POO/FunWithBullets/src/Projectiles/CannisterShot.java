package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Rhombus;

public class CannisterShot extends HeatedShot{

	public CannisterShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
		this.shape = new Rectangle();
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {

		if(dist<0) return;
		
		computeDistance(3, currentTime);
		
		if(dist>=shapeChangingDist){
			this.ref = newRef(3, shapeChangingDist, this.ref);
			shooterPosition=shooterPosition.translate(-shapeChangingDist, 0);
			super.shape=new Rhombus();
			super.ref=this.ref;
			super.shoot(dist-shapeChangingDist, shooterPosition);
		}
		else{
			this.ref = newRef(3, dist, this.ref);
			shooterPosition=shooterPosition.translate(-dist, 0);
			hitScreenAction(shooterPosition, this.ref);
		}
	}
}
