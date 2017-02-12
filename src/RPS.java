import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.leapmotion.leap.Controller;

public class RPS extends BasicGameState {
	private Player p1;
	private Player p2;
	Image background, text1, text2, text3, text4, text5;
	private boolean doThis = true;
	private int time;
	private Image[] imgs;
	private Image p1R;
	private Image p1P;
	private Image p1S;
	private Image p2R;
	private Image p2P;
	private Image p2S;
	private Image p1Wins;
	private Image p2Wins;
	private Image pTie;	
	
	public RPS(int game) {
		// TODO Auto-generated constructor stub
	}
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		
		time = 0;
		p1 = new Player();
		p2 = new Player();
		imgs = new Image[5];
		
		p1R = new Image("res/Rock.png");
		p1P = new Image("res/Paper.png");
		p1S = new Image("res/Scissors.png");
		
		p2R = new Image("res/RockR.png");
		p2P = new Image("res/PaperR.png");
		p2S = new Image("res/ScissorsR.png");
		
		p1Wins = new Image("res/PN1Win.png");
		p2Wins = new Image("res/PN2Win.png");
		pTie = new Image("res/Tie.png");
		
		background = new Image("res/BG.png");
		imgs[0] = new Image("res/Text1.png"); //ROCK
		imgs[1] = new Image("res/Text2.png"); //PAPER
		imgs[2] = new Image("res/Text3.png"); //SCISSORS
		imgs[3] = new Image("res/Text4.png"); //SAYS
		imgs[4] = new Image("res/Text5.png"); //SHOOT!
	}

	
	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		
		if(time >= 1000 && time < 1750)
			g.drawImage(imgs[0], 0, 0);
		if(time >= 1750 && time < 2500)
			g.drawImage(imgs[1], 0, 0);
		if(time >= 2500 && time < 3250)
			g.drawImage(imgs[2], 0, 0);
		if(time >= 3250 && time < 4000)
			g.drawImage(imgs[3], 0, 0);
		if(time >= 4000)
			g.drawImage(imgs[4], 0, 0);
		
		// CATCH NO HANDS
		//RANDOMIZE IMAGES?
		
		if(ControllerListener.ifGameOver) {
			State p1State = p1.getCurrentState();
			State p2State = p2.getCurrentState();
			switch (p1State) {
			case ROCK:
				g.drawImage(p1R, 150, 210);
				break;
			case PAPER:
				g.drawImage(p1P, 150, 210);
				break;
			case SCISSORS:
				g.drawImage(p1S, 150, 210);
				break;
			default:
				break;
			}
			switch (p2State) {
			case ROCK:
				g.drawImage(p2R, 1920-150-660, 210);
				break;
			case PAPER:
				g.drawImage(p2P, 1920-150-660, 210);
				break;
			case SCISSORS:
				g.drawImage(p2S, 1920-150-660, 210);
				break;
			default:
				break;
			}
			
			if(Model.getEndValue() == 1) 
				g.drawImage(p1Wins, 0, 780);
			else if(Model.getEndValue() == 2)
				g.drawImage(p2Wins, 0, 780);
			else if(Model.getEndValue() == 0)
				g.drawImage(pTie, 0, 780);
			//else
				//System.out.println("Neither player won, nor tied. It's something weird.");
			
			
			if(time >= 8000) {
				if(Model.getEndValue() != -1){
					reset();
					sbg.getState(Game.END).init(container, sbg);
					sbg.enterState(Game.END);
				}
				else {
					sbg.getState(Game.MAIN_MENU).init(container, sbg);
					reset();
					sbg.enterState(Game.MAIN_MENU);			
				}
			}
		}

		
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		time += delta;
		
		if(doThis && time > 4500){
			doThis = false;
			doOnce();
		}		
		
	}
	
	public void doOnce() {
		Controller controller = new Controller();
		ControllerListener listener = new ControllerListener(p1, p2);
		controller.addListener(listener);
	}

	public void reset(){
		//System.out.println("In reset");
		ControllerListener.played = false;
		ControllerListener.ifGameOver = false;
		doThis = true;
		time = 0;
		p1 = null;
		p2 = null;
		
		
	}

	public int getID() {
		return 1;
	}



}
