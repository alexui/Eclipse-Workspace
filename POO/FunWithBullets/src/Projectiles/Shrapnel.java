package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Square;

public class Shrapnel extends SpiderShot{

	public Shrapnel(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
		this.shape = new Square();
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {

		if(dist<0) return;
		
		computeDistance(5, currentTime);
		
		if(dist>=shapeChangingDist){
			this.ref = newRef(5, shapeChangingDist, this.ref);
			shooterPosition=shooterPosition.translate((int)Math.round(Math.sin(shapeChangingDist*(Math.PI)/2)),0);
			super.shape=new Rectangle();
			super.ref = this.ref;
			super.shoot(dist-shapeChangingDist, shooterPosition);
		}
		else{
			this.ref = newRef(5, dist, this.ref);
			shooterPosition=shooterPosition.translate((int)Math.round(Math.sin(dist*(Math.PI)/2)),0);
			hitScreenAction(shooterPosition, this.ref);
		}
	}
}
