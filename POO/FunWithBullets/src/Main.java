import java.io.FileWriter;
import java.io.IOException;

import Constants.ProjectileNames;
import ProcessingManagers.TimeManager;
import Projectiles.*;
import Screen.Screen;
import Shapes.Point;


public class Main {

	public static void main(String[] args) {
		
				
		if (args.length != 1) {
			System.err.println("Usage: java -cp <classpath> Index <text file> <word file>");
			System.exit(1);
		}
		
		Screen screen;
		Projectile p;
		String projectile;
		FileParser in = new FileParser(args[0]);
		in.open();
		
		int x = in.getNextInt();
		int y = in.getNextInt();
		int n = in.getNextInt();
		screen = new Screen(x,y);
		int ref,h,m,s,dist,posx,posy;
		for(int i=0;i<n;i++)
		{
			projectile = in.getNextWord();
			ref=in.getNextInt();
			h=in.getNextInt();
			m=in.getNextInt();
			s=in.getNextInt();
			dist = in.getNextInt();
			posx=in.getNextInt();
			posy=in.getNextInt();
			
			switch(projectile){
			
			case ProjectileNames.CANNISTER_SHOT: 
				p = new CannisterShot(screen, ref, new TimeManager(h,m,s));
				p.shoot(dist, new Point(posx, posy));
				break;
			case ProjectileNames.CARCASS:
				p = new Carcass(screen, ref, new TimeManager(h,m,s));
				p.shoot(dist, new Point(posx, posy));
				break;
			case ProjectileNames.CHAIN_SHOT:
				p = new ChainShot(screen, ref, new TimeManager(h,m,s));
				p.shoot(dist, new Point(posx, posy));
				break;
			case ProjectileNames.HEATED_SHOT:
				p = new HeatedShot(screen, ref, new TimeManager(h,m,s));
				p.shoot(dist, new Point(posx, posy));
				break;
			case ProjectileNames.SHRAPNEL:
				p = new Shrapnel(screen, ref, new TimeManager(h,m,s));
				p.shoot(dist, new Point(posx, posy));
				break;
			case ProjectileNames.SIMPLE_SHELL:
				p = new SimpleShell(screen, ref, new TimeManager(h,m,s));
				p.shoot(dist, new Point(posx, posy));
				break;
			case ProjectileNames.SPIDER_SHOT:
				p = new SpiderShot(screen, ref, new TimeManager(h,m,s));
				p.shoot(dist, new Point(posx, posy));
				break;
			case ProjectileNames.TRI_GRAPE_SHOT:
				p = new TriGrapeShot(screen, ref, new TimeManager(h,m,s));
				p.shoot(dist, new Point(posx, posy));
				break;
			default: 
				try {
					throw new Exception();
				} catch (Exception e) {
					System.err.println("Unexisting project name.");
				}
		
			}
		}
		
		in.close();
		
		try {
			FileWriter out = new FileWriter(args[0]+"_out");
		
			int i,j;
			for(i=0;i<screen.getScreen().length;i++)
				{
				for(j=0;j<screen.getScreen()[0].length;j++)
					{
					out.write(screen.getScreen()[i][j]);
					out.flush();
					}
				out.write("\r\n");
				}
			
			out.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
