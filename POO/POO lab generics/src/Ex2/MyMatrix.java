package Ex2;

public class MyMatrix implements Sumabil {

	private Float f[][];
	
	public MyMatrix(){
		f = new Float[4][4];
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
			{
				f[i][j]= (float) (Math.random()*100);
			}
	}
	
	public Float[][] getMatrix(){
		return this.f;
	}

	@Override
	public void addValue(Sumabil value) {

		if(value instanceof MyMatrix){
			for(int i=0;i<4;i++)
				for(int j=0;j<4;j++)
					f[i][j]+=((MyMatrix) value).getMatrix()[i][j];
		}
	}
	
}
