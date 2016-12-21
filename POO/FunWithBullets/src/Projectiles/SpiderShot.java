package Projectiles;

import ProcessingManagers.TimeManager;
import Screen.Screen;
import Shapes.Point;
import Shapes.PointedShape;
import Shapes.Rectangle;

public class SpiderShot extends SimpleShell{

	public SpiderShot(Screen screen, int ref, TimeManager currentTime) {
		super(screen, ref, currentTime);
		this.shape=new Rectangle();
	}

	@Override
	public void shoot(int dist, Point shooterPosition) {

		if(dist<0) return;
							
		computeDistance(7, currentTime);
		
		if(dist>=shapeChangingDist){
			this.ref = newRef(7, shapeChangingDist, this.ref);
			shooterPosition=shooterPosition.translate((int)Math.round(Math.sin(shapeChangingDist*(Math.PI)/2)),(int)Math.round(Math.cos(shapeChangingDist*(Math.PI)/2)));
			super.shape=new PointedShape();
			super.ref=this.ref;
			super.shoot(dist-shapeChangingDist, shooterPosition);
		}
		else
			{
			this.ref = newRef(7, dist, this.ref); 
			shooterPosition=shooterPosition.translate((int)Math.round(Math.sin(dist*(Math.PI)/2)),(int)Math.round(Math.cos(dist*(Math.PI)/2)));
			hitScreenAction(shooterPosition, this.ref);
			}
	}
	
	
	protected void computeDistance(int id,TimeManager currentTime)
	{
		shapeChangingDist = 42 + (id*id*currentTime.getH()+id*currentTime.getMin()+currentTime.getSec())%42;
	}
	
	protected int newRef(int id,int dist,int ref)
	{
		int d_ref=-1*(dist/10)-id;
		return ref+d_ref;
	}
}
