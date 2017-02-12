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
	
	public RPS(int game) {
		// TODO Auto-generated constructor stub
	}
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		time = 0;
		p1 = new Player();
		p2 = new Player();
		imgs = new Image[5];
		
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
		
		if(time >= 1000 && time < 2000)
			g.drawImage(imgs[0], 0, 0);
		if(time >= 2000 && time < 3000)
			g.drawImage(imgs[1], 0, 0);
		if(time >= 3000 && time < 4000)
			g.drawImage(imgs[2], 0, 0);
		if(time >= 4000 && time < 5000)
			g.drawImage(imgs[3], 0, 0);
		if(time >= 5000)
			g.drawImage(imgs[4], 0, 0);

		
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		time += delta;
		System.out.println();
		
		if(doThis && time > 5000){
			doThis = false;
			doOnce();
		}
		//if(Model.getEndValue() != -1){
			//sbg.getState(Game.END).init(container, sbg);
			//sbg.enterState(Game.END);
	//	}
//		else {
//			sbg.getState(Game.MAIN_MENU).init(container, sbg);
//			reset();
//			sbg.enterState(Game.MAIN_MENU);			
//		}
			
		
	}
	
	public void doOnce(){
		Controller controller = new Controller();
		ControllerListener listener = new ControllerListener(p1, p2);
		controller.addListener(listener);
//        try {
//            System.in.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
	}

	public void reset(){
		ControllerListener.reset();
		p1 = new Player();
		p2 = new Player();
		
		
	}

	public int getID() {
		return 1;
	}



}
