import com.leapmotion.leap.*;

public class ControllerListener extends Listener {
		private static Player p1;
		private static Player p2;
		
		public static boolean ifGameOver = false;
		public static boolean played = false;
		
		public ControllerListener(Player p1, Player p2) {
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
	        int[] player_2 = new int[800];
	        
	        	Hand hand1 = frame.hands().leftmost();
	        	Hand hand2 = frame.hands().rightmost();
		        if(!hand1.equals(hand2) && (hand1.isValid() && hand2.isValid())) {	
		        	FingerList onHand1 = hand1.fingers().extended();
		        	FingerList onHand2 = hand2.fingers().extended();
		        	
		        	for(int i = 0; i < 800; i++) {
		        		//if(i % 10 == 0)
		        			//System.out.println("Frame " + i + " hand1: " + onHand1.count() + "            " + "Frame " + i + " hand2: " + onHand2.count());
		        		player_1[i] = onHand1.count();
		        		player_2[i] = onHand2.count();
		        	}
		        	
		        	if(!played) {
		        		p1.setCurrentState(Model.mode(player_1));
		        		p2.setCurrentState(Model.mode(player_2));
		        		played = true;
		        	
		        	
		        	State p1State = p1.getCurrentState();
		        	State p2State = p2.getCurrentState();
		        	
		        	//System.out.println("p1: " + p1State);
		        	//System.out.println("p2: " + p2State);
		        	
		        	Model.checkWinner(p1State, p2State);
		        	ifGameOver = true;
		        	
		        	//1111System.out.println("Player " + Model.getEndValue() + " wins!!!!");
		        	}
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
