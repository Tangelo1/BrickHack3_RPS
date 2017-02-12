import com.leapmotion.leap.Controller;
import com.leapmotion.leap.FingerList;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Listener;

public class ControllerListenerSingle extends Listener {
		private static Player p1;
		private static AI p2;
		
		public static boolean ifGameOver = false;
		public static boolean played = false;
		
		public ControllerListenerSingle(Player p1, AI p2) {
			this.p1 = p1;
			this.p2 = p2;
		}
		
		public void onInit(Controller controller) {
			System.out.println("Controller initialized");
		}
	    public void onConnect(Controller controller) {
	        System.out.println("Controller Connected");
	    }
	    public void onFrame(Controller controller) {    
	        Frame frame = controller.frame();
	        int[] player_1 = new int[800];
	        
	        	Hand hand1 = frame.hands().leftmost();
		        if(hand1.isValid()) {	
		        	FingerList onHand1 = hand1.fingers().extended();
		        	
		        	for(int i = 0; i < 800; i++) {
		        		//if(i % 10 == 0)
		        			//System.out.println("Frame " + i + " hand1: " + onHand1.count() + "            " + "Frame " + i);
		        		player_1[i] = onHand1.count();
		        	}
		        	
		        	
		        	if(!played) {
		        		p1.setCurrentState(Model.mode(player_1));
		        		p2.setCurrentState(p2.play(p1));
		        		played  = true;
		        	}
		        	
		        	State p1State = p1.getCurrentState();
		        	State p2State = p2.getCurrentState();
		        	
		        	//System.out.println("p1: " + p1State);
		        	//System.out.println("p2: " + p2State);
		        	
		        	Model.checkWinner(p1State, p2State);
		        	ifGameOver = true;
		        	
		        	//System.out.println("Player " + Model.getEndValue() + " wins!!!!");
		        }
		        else
		        	Model.setEndValue(-1);
		        
		        if(ifGameOver)
		        	controller.delete();
	    	
	    }
	    
	    public void onDisconnect(Controller controller) {
	    	System.out.println("Controller Disconnected");
	    }
	    
	}
