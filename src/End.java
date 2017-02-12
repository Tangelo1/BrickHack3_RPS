import java.awt.Color;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class End extends BasicGameState
{
	Button exitButton;
	Image endBG;
	Image banner;

	public End(int state){}
	
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException
	{
		endBG = new Image("res/BG.png");
		banner = new Image("res/GG.png");
		exitButton = new Button("res/RetMainMenu.png", 660, 600, 660, 220);
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		endBG.draw(0,0);
		banner.draw(0,0);
		exitButton.render(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		Input input = container.getInput();
		if(exitButton.isClicked(input))
			sbg.enterState(Game.MAIN_MENU);
			
			
	}
	
	@Override
	public int getID() 
	{
		return 2;
	}
}
