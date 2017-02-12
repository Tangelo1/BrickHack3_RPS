
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.leapmotion.leap.Controller;

public class Game extends StateBasedGame
{
	public static final int MAIN_MENU = 0;
	public static final int RPS = 1; 
	public static final int END = 2;
	public static final int DIFFICULTY = 3;
	public static final int SINGLE = 4;

	//hello world it's 2017
	public Game(String name)
	{
		super(name);
		addState(new MainMenu(MAIN_MENU));
		addState(new RPS(RPS));
		addState(new End(END));
	}

	public void initStatesList(GameContainer gc) throws SlickException {}
	
	public static void main(String[] args)
	{

		AppGameContainer appgc;
		try
		{
			appgc = new AppGameContainer(new Game("Rock Paper Scissors"), 1920, 1080, false);
			appgc.setIcon("res/icon.png");
			appgc.start();
		}
		catch(SlickException ex)
		{
			ex.printStackTrace();
		}
	}
}
