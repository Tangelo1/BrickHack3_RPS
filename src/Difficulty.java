import java.awt.Color;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Difficulty extends BasicGameState
{
	
	public static int difficulty = 0;
	Button easy;
	Button medium;
	Button hard;
	Button back;
	
	Image selectText;
	Image bg;
	public Difficulty(int state){}
	
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException
	{
		bg = new Image("res/BG.png");
		selectText = new Image("res/Difficulty.png");
		
		easy = new Button("res/EasyMode.png", 960-330, 300, 660, 220);
		medium = new Button("res/MediumMode.png", 960-330, 560, 660, 220);
		hard = new Button("res/HardMode.png", 960-330, 820, 660, 220);
		
		back = new Button("res/RetMainMenu.png", 20, 820, 660, 220);
		
		
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		bg.draw(0,0);
		selectText.draw(0, 0);
		easy.render(g);
		medium.render(g);
		hard.render(g);
		
		back.render(g);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		Input input = container.getInput();
		
		if(easy.isClicked(input))
		{
			difficulty = 1;
			sbg.getState(Game.SINGLE).init(container, sbg);
			sbg.enterState(Game.SINGLE);
		}
		if(medium.isClicked(input))
		{
			difficulty = 2;
			sbg.getState(Game.SINGLE).init(container, sbg);
			sbg.enterState(Game.SINGLE);
		}
		if(hard.isClicked(input))
		{
			difficulty = 3;
			sbg.getState(Game.SINGLE).init(container, sbg);
			sbg.enterState(Game.SINGLE);
		}
		if(back.isClicked(input)) {
			sbg.enterState(Game.MAIN_MENU);
		}
		
		System.out.println("Difficulty: " + difficulty);
	}
	
	@Override
	public int getID() 
	{
		return 3;
	}
}
