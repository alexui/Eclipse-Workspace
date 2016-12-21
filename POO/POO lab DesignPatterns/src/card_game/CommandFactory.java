package card_game;

public class CommandFactory {

	/**
	*	TODO
	*	
	*	This class behaves as a Singleton, so make the
	*	necessary arrangements
	*/

	private static CommandFactory instance;
	
	private  CommandFactory(){
		
	}
	
	public CommandFactory getFactory(){
		if(instance==null)
			instance = new CommandFactory();
		return instance;
	}
	
	public GameCommand getCommand (Card c, GameAction action ) {
		
		GameCommand command=null;

		{
			if(action.equals(GameAction.BUY))
				command = new BuyCommand(c,action);
			if(action.equals(GameAction.PLAY))
				command = new ActionCommand(c,action);
		}
			
		return command;
	}
}

