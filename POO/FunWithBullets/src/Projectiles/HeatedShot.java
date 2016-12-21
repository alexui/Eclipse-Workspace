package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Rhombus;

public class HeatedShot extends SpiderShot{

	public HeatedShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
		this.shape = new Rhombus();
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {

		if(dist<0) return;

		computeDistance(6, currentTime);
		
		if(dist>=shapeChangingDist){
			this.ref = newRef(6, shapeChangingDist, this.ref);
			shooterPosition=shooterPosition.translate(0, (int)Math.round(Math.cos(shapeChangingDist*(Math.PI)/2)));
			super.shape=new Rectangle();
			super.ref=this.ref;
			super.shoot(dist-shapeChangingDist, shooterPosition);
		}
		else{
			this.ref = newRef(6, dist, this.ref);
			shooterPosition=shooterPosition.translate(0, (int)Math.round(Math.cos(dist*(Math.PI)/2)));
			hitScreenAction(shooterPosition, this.ref);
		}
			
	}
	
}
