package ex4;

public interface ListObserver {
	
	public boolean elementAdded(ListEvent e);
	public boolean elementRemoved(ListEvent e);

}
