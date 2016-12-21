package card_game;

import java.util.ArrayList;

public interface Observer{
	void notifyEvent(GameEvent e);
}

class ScoreCounter implements Observer{
	
	// TODO hold information on scores for each player and update accordingly (for Victory cards etc), when notified

	private ArrayList<Player> players;

	public ScoreCounter(){
		players = new ArrayList<Player>();
	}
	
	class Player{
		
		private String name;
		private int score;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		public Player(String name, int score) {
			
			this.name = name;
			this.score = score;
		}
		
		@Override
		public String toString(){
			return "["+name+","+score+"] ";
		}
	}
			
	private boolean containsPlayer(String player){
		for(int i=0;i<players.size();i++)
			if(players.get(i).name.equals(player))
				return true;
		return false;
	}
	
	private int indexOf(String player){
		for(int i=0;i<players.size();i++)
			if(players.get(i).name.equals(player))
				return i;
		return -1;
	}
	
	/**
	 * Prints the score for each player in the game who had played at least a turn.
	 */
	public void printScore(){
		if(players.size()!=0)
		for(Player player : players){
			System.out.println(player.toString());
		}
	}

	@Override
	public void notifyEvent(GameEvent e) {
		
		if(e.getCard().getType()==CardType.VICTORY)
			if(containsPlayer(e.getPlayer())==false) // daca jucatorul nu se afla in lista, este aduagat
			{
				players.add(new Player(e.getPlayer(),e.getCard().play()));
			}
			else
			{
				int index = indexOf(e.getPlayer());
				players.get(index).score+=e.getCard().play();
			}
		
		if(e.getCard().getType()==CardType.valueOf("UndoVictory"))
		{
			int index = indexOf(e.getPlayer());
			players.get(index).score-=e.getCard().play();
		}
	}
}


class GameLogger implements Observer{

	@Override
	public void notifyEvent(GameEvent e) {

		System.out.println(e.getPlayer()+" "+e.getAction().name()+";");
	}	
	//When notified, it prints the current player and details about what card he played/bought
	
}
