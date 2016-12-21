package card_game;

enum GameAction{
	PLAY,
	BUY,
	UNBUY,
	UNPLAY
}

public abstract class GameCommand {
	protected Card c;
	protected GameAction action;
	
	public GameCommand(Card c, GameAction action){
		this.c= c;
		this.action = action;
	}
	
	/**
	 * Executes the command - in the action phase it plays the card, in the
	 * buy phase it returns the price of the bought card.
	 * @return the effect of playing the given card
	 */
	public abstract int execute();
	
	public Card getCard(){
		return c;
	}
	public GameAction getType(){
		return action;
	}
}

/**
 * A GameCommand subclass for action phase commands.
 *
 */
class ActionCommand extends GameCommand{	
	
	public ActionCommand(Card c, GameAction action) {
		super(c, action);
	}

	public String toString(){
		return "Action Command";
	}

	@Override
	public int execute() {
		return c.play();
	}
}

/**
 * A GameCommand subclass for buy phase commands.
 *
 */
class BuyCommand extends GameCommand{
	
	public BuyCommand(Card c, GameAction action) {
		super(c, action);
	}

	public String toString(){
		return "Buy Command";
	}

	@Override
	public int execute() {
		return c.getPrice();
	}
}