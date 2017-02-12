
public class AI {
	private static int difficulty;
	private State currentState;
	
	public AI(int d) {
		difficulty = d;
	}
	
	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State state) {
		currentState = state;
		
	}

	public State play(Player player) {
		switch(difficulty){
			case 1:
				int rand = (int) (Math.random()*99);
				if(rand >= 0 && rand < 33) {
					return State.ROCK;
				}
				else if(rand >= 33 && rand < 66) {
					return State.PAPER;
				}
				else if(rand >=66 && rand < 100) {
					return  State.SCISSORS;
				}
				
				
				break;
				
			case 2:
				
				break;
				
			case 3:
				State human = player.getCurrentState();
				int rand1 = (int) (Math.random()*20);
				if(rand1 >= 0 && rand1 <= 16){
					if(human == State.ROCK)
						return State.PAPER;
					else if(human == State.PAPER)
						return State.SCISSORS;
					else
						return State.ROCK;
				}
				else if(rand1 == 17)
					return State.ROCK;
				else if(rand1 == 18)
					return State.PAPER;
				else
					return State.SCISSORS;
			default:
				break;
		}
		
		
		
		return null;
	}
}
