
public interface Observable {
	/**
	 * adauga observator
	 * @param o
	 */
	void addObserver(Observer o);
	/**
	 * sterge observator
	 * @param o
	 */
	void removeObserver(Observer o);
}
