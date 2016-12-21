package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.Square;
import Shapes.Triangle;

public class ChainShot extends Shrapnel{

	public ChainShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
		this.shape=new Triangle();
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {

		if(dist<0) return;
			
		computeDistance(4, currentTime);
		
		if(dist>=shapeChangingDist){
			this.ref = newRef(4, shapeChangingDist, this.ref);
			shooterPosition=shooterPosition.translate(0, -shapeChangingDist);
			super.shape=new Square();
			super.ref = this.ref;
			super.shoot(dist-shapeChangingDist, shooterPosition);
		}
		else
		{
			this.ref = newRef(4, dist, this.ref);
			shooterPosition=shooterPosition.translate(0, -dist);
			hitScreenAction(shooterPosition, this.ref);
		}
	}
}
