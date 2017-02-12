import java.util.HashMap;

public class Model {
	private static int endValue = -1;
	/**
	 * This is the game logic. Checks who wins RPS
	 * @param s1 State of Player 1
	 * @param s2 State of Player 2
	 * @return The winner to RPS.    1 means Player 1 wins
	 * 								 2 means Player 2 wins
	 * 								 0 means it's a tie
	 * 								-1 means something messed up
	 */
	public static void checkWinner(State s1, State s2){
		if (s1 == s2)
			endValue = 0;
		else if (s1 == State.ROCK && s2 == State.SCISSORS)
			endValue = 1;
		else if (s1 == State.PAPER && s2 == State.ROCK)
			endValue = 1;
		else if (s1 == State.SCISSORS && s2 == State.PAPER)
			endValue = 1;
		else if (s2 == State.ROCK && s1 == State.SCISSORS)
			endValue = 2;
		else if (s2 == State.PAPER && s1 == State.ROCK)
			endValue = 2;
		else if (s2 == State.SCISSORS && s1 == State.PAPER)
			endValue = 2;
		else
			endValue = -1;
	}
	
	public static int mode(int[] array){
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	    int max = 1, temp = 0;
	    for(int i = 0; i < array.length; i++){
	            if(hm.get(array[i])!= null){
	            	int count = hm.get(array[i]);
		            count = count + 1;
		            hm.put(array[i], count);
		            if(count > max){
		            	max = count;
		                temp = array[i];
		            }
	            }
	            else
	            	hm.put(array[i],1);
	    }
	    return temp;
    }

	public static int getEndValue() {
		return endValue;
	}

	public static void setEndValue(int endValue) {
		Model.endValue = endValue;
	}
}
