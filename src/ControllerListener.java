import com.leapmotion.leap.*;

public class ControllerListener extends Listener {
		private static Player p1;
		private static Player p2;
		
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
	        int[] player_1 = new int[600];
	        int[] player_2 = new int[600];
	        
	        	Hand hand1 = frame.hands().leftmost();
	        	Hand hand2 = frame.hands().rightmost();
		        if(!hand1.equals(hand2)) {	
		        	FingerList onHand1 = hand1.fingers().extended();
		        	FingerList onHand2 = hand2.fingers().extended();
		        	for(int i = 0; i < 600; i++) {
		        		System.out.println("Frame " + i + " hand1: " + onHand1.count() + "            " + "Frame " + i + " hand2: " + onHand2.count());
		        		player_1[i] = onHand1.count();
		        		player_2[i] = onHand2.count();
		        	}
		        	
		        	p1.setCurrentState(Model.mode(player_1));
		        	p2.setCurrentState(Model.mode(player_2));
		        	System.out.println("p1: " + p1.getCurrentState());
		        	System.out.println("p2: " + p2.getCurrentState());
		        	Model.checkWinner(p1.getCurrentState(), p2.getCurrentState());
		        	
		        	System.out.println("Player " + Model.getEndValue() + " wins!!!!");
		        }
		        else
		        	Model.setEndValue(-1);
		        controller.removeListener(this);
	    }
	    
	    public void onDisconnect(Controller controller) {
	    	System.out.println("Controller Disconnected");
	    }
	    
	    public static void reset(){
	    	p1 = new Player();
	    	p2 = new Player();
	    	
	    	
	    }
	}
