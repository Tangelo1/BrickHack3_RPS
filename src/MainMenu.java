
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Graphics;


public class MainMenu extends BasicGameState
{
	Image background, title;
	Image opener1, opener2, opener3;
	Button SPButton;
	Button MPButton;
	Button exitButton;

	public MainMenu(int state){}
	
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException 
	{
		background = new Image("res/BG.png");
		title = new Image("res/RockPaperScissors.png");
		SPButton = new Button("res/SinglePlayer.png", 660, 470, 660, 100);
		MPButton = new Button("res/MultiPlayer.png", 660, 590, 660, 100);
		exitButton = new Button("res/QuitButton.png", 660, 790, 660, 220);
		Music openingMenuMusic = new Music("res/Searching.ogg");
		openingMenuMusic.loop();
		
	
	}

	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.drawImage(background, 0, 0);
		g.drawImage(title, 350, 100);
		g.drawString("Music Credit: Eric Skriff; You da real MVP", 50, 1030);
		SPButton.render(g);
		MPButton.render(g);
		exitButton.render(g);
	}

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		Input input = container.getInput();
		
		if(SPButton.isClicked(input))
		{
			sbg.getState(Game.RPS).init(container, sbg);
			sbg.enterState(Game.RPS);
		}
		
		if(exitButton.isClicked(input))
		{
			container.exit();
		}
	}
	
	public int getID() 
	{
		return 0;
	}
}
