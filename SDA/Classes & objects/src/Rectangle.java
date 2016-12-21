
public class Rectangle implements special{

	public int width=0;
	public int height=0;
	public Point origin;
	
	public Rectangle(Point p,int a,int b)
	{
		width =a;
		height =b;
		origin = p;
	}
	
	public Rectangle(int a,int b)
	{
		width =a;
		height =b;
		origin = new Point(0,0);
	}
	
	public Rectangle(Point p)
	{
		origin = p;
	}
	
	public Rectangle()
	{
		origin = new Point(0,0);
	}
	
	public void move(int a,int b)
	{
		origin.x=a;
		origin.y=b;
	}
	
	public int getArea()
	{
		return width * height;
	}
	
	public int getArea(int a, int b)
	{
		width = a;
		height = b;
		return width * height;
	}
	
	public double getDiagonal()
	{
		return Math.sqrt(Math.pow(width,2)+Math.pow(height, 2));
	}
}
