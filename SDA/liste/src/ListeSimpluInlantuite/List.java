package ListeSimpluInlantuite;
import java.util.*;

public class List {

		private Info a;
		private List urm;
		Scanner scan = new Scanner(System.in);
		
		public List()
		{
			a = new Info();
			urm=null;
		}
		
		public void setInfoNod()
		{
			int n; String s;
			System.out.println("int: ");
			n = scan.nextInt();
			System.out.println("string: ");
			s = scan.next();
			a.setInfo(n, s);
		}
		
		public List searchNod(List l,int n)
		{
			if(l==null){System.err.println("Null pointer."); return null;}
			int i;
			List p=l;
			for(i=0;i<n-1;p=p.urm,i++);
			return p;
		}
		
		public void addNodBefore(List l,int IndexNod)
		{
			if(l==null) {System.err.println("Null pointer."); return;}
			List nod = new List();
			nod.setInfoNod();
			if(IndexNod<=1)
			{
				System.err.println("Null pointer."); return;
			}
			List Dest=l.searchNod(l, IndexNod-1);
			nod.urm=Dest.urm;
			Dest.urm=nod;
		}
		
		public void addNodAfter(List l,int IndexNod)
		{
			if(l==null) {System.err.println("Null pointer."); return;}
			List nod = new List();
			nod.setInfoNod();
			List Dest=l.searchNod(l, IndexNod);
			nod.urm=Dest.urm;
			Dest.urm=nod;
		}
		
		public void getList(List l)
		{
			System.out.println("List:");
			if(l==null) {System.err.println("Null pointer."); return;}
			List p;
			for(p=l;p!=null;p=p.urm)
			{
				System.out.printf("(%d,%s) ",p.a.getInfoNumber(),p.a.getInfoString());
			}
			System.out.println();
		}
		
		public void setRandomList(List l,int n)
		{
			System.out.println("Building list:");
			if(l==null) {System.err.println("Null pointer."); return;}
			l.setInfoNod();
			int i;
			List p=l,nod;
			for(i=1;i<n;i++)
			{
				nod=new List();
				nod.setInfoNod();
				p.urm=nod;
				p=p.urm;
			}
		}
		
		public void addAtTheEnd(List l)
		{
			if(l==null) {System.err.println("Null pointer."); return;}
			List p;
			for(p=l;p.urm!=null;p=p.urm);
			List nod = new List();
			nod.setInfoNod();
			p.urm=nod;
		}
		
		public List addAtTheBeggining(List  l)
		{
			if(l==null) {System.err.println("Null pointer."); return null;}
			List nod = new List();
			nod.setInfoNod();
			nod.urm=l;
			l=nod;
			return l;
		}
		
}