package card_game;

import java.util.ArrayList;
import java.util.LinkedList;

interface Observable {
	
	boolean addObserver(Observer o);	
	boolean removeObserver(Observer o);
}

public class PlayArea implements Observable{
	
	private String currentPlayer;	
	
	private LinkedList<GameCommand> commands = new LinkedList<GameCommand>();
	private LinkedList<GameCommand> undo = new LinkedList<GameCommand>();
	private ArrayList<Observer> observers = new ArrayList<Observer>();


	/* TODO implement an undoable behavior	
		
		This class needs to hold a collection of all the Commands that have been issued (played), *in order*, and a reference to the last issued Command.
		When someone decides to undo a Command, you need to
		- undo the actual action of the Command
		- get back to the previous Command
		- keep the "undid" Commands in case you want to "redo"
		When you play a fresh Command, you need to delete the "undid" Commands from your Collection.

		Example: you played GameCommands C1, C2, C3. Reference to last Command: C3. 
		You undo. Your collection of Commands is still C1, C2, C3, but last Command becomes C2.
		You undo again. Your collection is the same, but last Command becomes C1.
		You redo. Your collection remains the same, last Command is C2.
		You play a fresh Command, C4. Your collection will become C1, C2, C4 (C3 was "undid", so we toss that one).
	*/

	public void setPlayer(String p){
		currentPlayer = p;
	}
	public void play(GameCommand c){
		
		commands.addLast(c);
		c.execute();
		for(Observer o : observers){
			o.notifyEvent(new GameEvent(c.c,currentPlayer,c.action));
		}
		undo =new LinkedList<GameCommand>();
	}
	@Override
	public boolean addObserver(Observer o) {
		return observers.add(o);
	}
	@Override
	public boolean removeObserver(Observer o) {
		return observers.remove(o);
	}	
	
	public void undo(){
		
		GameCommand c = commands.getLast();

		commands.removeLast();//se elimina comanda din lista de comenzi initiale
		undo.addLast(c); //comanda se salveaza pentru a putea fi reexecutata
		
		GameEvent event = new GameEvent(c.c,currentPlayer,c.action); // are loc modificarea evenimentului pentru a instiinta observatorii despre 'undo'
		
		if(c.getType().equals(GameAction.BUY))
			event.action=GameAction.UNBUY;
		if(c.getType().equals(GameAction.PLAY))
			event.action=GameAction.UNPLAY;
		if(c.getCard().getType().equals(CardType.VICTORY)) // caz special 
			{
			event.card = c.getCard();
			event.card.type=CardType.valueOf("UndoVictory"); // apelam la un nou cardType din enum care contine de fapt string-uri
			}
		
		for(Observer o : observers){
			o.notifyEvent(event);
		}
	}
	
	public void redo(){
		
		GameCommand c = undo.getLast(); //se preia ultima comanda din lista undo dupa care se elimina din aceasta
		undo.removeLast(); 
		 // se executa din nou comanda
		commands.addLast(c);
		c.execute();
		for(Observer o : observers){
			o.notifyEvent(new GameEvent(c.c,currentPlayer,c.action));
		}
	}
}

class GameEvent{
	Card card;
	String player;
	GameAction action;
	
	public GameEvent(Card card, String player, GameAction action){
		this.card = card;
		this.player = player;
		this.action = action;
	}
	
	public Card getCard(){
		return card;
	}
	
	public String getPlayer(){
		return player;
	}
	
	public GameAction getAction(){
		return action;
	}
}

