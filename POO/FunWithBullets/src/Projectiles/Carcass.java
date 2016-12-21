package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.Rhombus;
import Shapes.Square;

public class Carcass extends HeatedShot{

	public Carcass(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
		this.shape = new Square();
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {

		if(dist<0) return;
			
		computeDistance(2, currentTime);
		
		if(dist>=shapeChangingDist){
			this.ref = newRef(2, shapeChangingDist, this.ref);
			shooterPosition=shooterPosition.translate(0, shapeChangingDist);
			super.shape=new Rhombus();
			super.ref=this.ref;
			super.shoot(dist-shapeChangingDist, shooterPosition);
		}
		else{
			this.ref = newRef(2, dist, this.ref);
			shooterPosition=shooterPosition.translate(0, dist);
			hitScreenAction(shooterPosition, this.ref);
		}
	}
}
