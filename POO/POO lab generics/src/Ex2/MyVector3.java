package Ex2;


public class MyVector3 implements Sumabil{
	
		private float x,y,z;
		
		public MyVector3(float x,float y,float z){
			this.x=x;
			this.y=y;
			this.z=z;
		}
		
		public float getX() {
			return x;
		}
		
		public float getY() {
			return y;
		}
	
	
		public float getZ() {
			return z;
		}
	
		@Override
		public String toString(){
			return "["+x+","+y+","+z+"]";
		}
	
	@Override
	public void addValue(Sumabil value) {
		if(value instanceof MyVector3 ){
			
			x+=((MyVector3) value).getX();
			y+=((MyVector3) value).getY();
			z+=((MyVector3) value).getZ();
		}
	}

	

}
