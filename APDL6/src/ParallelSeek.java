import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;


public class ParallelSeek {

	Random r = new Random();
	static Vector<Integer> v = new Vector<Integer>();
	static int THREADS;
	static int val;
	static int pos=-1;
	static final int N=64;
	int dif =5;
	
	public ParallelSeek(){
		for(int i=0;i<N;i++)
			v.add(0);
	}
	
	void populateVector(){
		int i;
		for(i=0;i<N;i++){
			if(i>0)
				v.set(i,new Integer(r.nextInt(dif)+(v.get(i-1))));
			else
				v.set(i,new Integer(r.nextInt(dif)));
		}
	}
	
	void printVector(){
		System.out.println(v);
	}
	
	class MyThread extends Thread{
		
		int st,dr;
				
		public MyThread(int s,int d){
			st=s;
			dr=d;
		}
		
		@Override
		public void run(){
			
			if(st<0 || dr<0)
				return;
			
			if(v.get(st)>val)
				dr=st;
			if(v.get(dr)<val)
				st=dr;
			
			if(st==dr)
				if(v.get(st)==val)
					pos=st;
		}
	}
	
	class SeekThread extends Thread{
		
		int st,dr;
		
		public SeekThread(int s,int d) {
			st=s;
			dr=d;
		}
		
		public void setMargins(int s,int d){
			st =s;
			dr=d;
		}
		
		@Override
		public void run(){
			
			if(st<0 || dr> N)
				return;
			
			if(st>dr)
				return;
			
			if(v.get(st)==val)
				pos=st;
			
			if(v.get(dr)==val)
				pos=dr;
			
			
			
		}
	}
	
	public void seek(int st,int dr,int no_thrd) throws InterruptedException{
		
		System.out.println("stanga : "+st+" dreapta :"+dr);
		
		if(st>dr)
			return;

		boolean found =false;
		int dim = dr-st;
		
		for(int i=1;i<=no_thrd;i++){
			
			if(dim/no_thrd*i < dr)
			if(val==v.get(dim/no_thrd*i))
			{
				pos=(dim/no_thrd)*i;
				found=true;
				break;
			}
		}
		
		if(!found){
			
			ArrayList<MyThread> threads = new ArrayList<MyThread>();
			for(int i=1;i<=no_thrd;i++){
				
				if(dim/no_thrd*i-1 < dr)
					threads.add(new MyThread(st, dim/no_thrd*i-1));
				else
					threads.add(new MyThread(st, dr));
				
				st = dim/no_thrd*i+1;
			}
			
			for(int i=0;i<threads.size();i++){
				threads.get(i).start();
			}
			
			for(int i=0;i<threads.size();i++){
				threads.get(i).join();
			}
						
			int newSt,newDr;
			for(int i=0;i<threads.size();i++){
				newSt = threads.get(i).st;
				newDr = threads.get(i).dr;
				
				if(newSt!=newDr){
					seek(newSt,newDr,no_thrd);
					break;
				}
			}
			
		}
		
	}
	
	public void cauta(int st,int dr,int no_thrd) throws InterruptedException{
		
		ArrayList<SeekThread> threads = new ArrayList<SeekThread>();
		
		int s,d;
		
		s= st;
		for(int i=0;i<no_thrd;i++){
			d = N/no_thrd*(i+1);
			if(d<dr){
				threads.add(new SeekThread(s,d));
				s+=d+1;
			}
			else
				threads.add(new SeekThread(s,dr));
			
		}
		
		for(int i=0;i<threads.size();i++)
			threads.get(i).start();
		
		for(int i=0;i<threads.size();i++)
			threads.get(i).join();
		
		int new_st=st,new_dr=dr;
		
		
		int g=(int)(Math.log(no_thrd+1)/Math.log(N+1));
		
		while(g-1>0){
			//threads.clear();
			for(int i=0;i<threads.size();i++){
				if(threads.get(i).st<val && threads.get(i).dr>val){
					new_st = threads.get(i).st;
					new_dr = threads.get(i).dr;
				}
					
			}
			s = new_st;
			for(int i=0;i<threads.size();i++){
				d = new_dr/no_thrd*(i+1);
				if(d<dr){
					threads.get(i).setMargins(s,d);
					s+=d+1;
				}
				else
					threads.get(i).setMargins(s,dr);
				
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		ParallelSeek ps = new ParallelSeek();
		ps.populateVector();
		ps.printVector();
		
		try {
			ps.cauta(0, N-1, 4);
			System.out.println(pos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
