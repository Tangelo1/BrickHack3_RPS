
public class Player {
	private int numFingers, numWins = 0;
	private State currentState;

	public Player(){
		numFingers = -1;
		currentState = State.NONE;
	}
	
	public Player(int numFingers){
		this.numFingers = numFingers;
		if(numFingers < 2)
			currentState = State.ROCK;
		else if(numFingers == -1)
			currentState = State.NONE;
		else if(numFingers > 1 && numFingers < 4)
			currentState = State.SCISSORS;
		else
			currentState = State.PAPER;
	}
	
	public Player(State currentState){
		this.currentState = currentState;
		if(currentState == State.NONE)
			numFingers = -1;
		else if(currentState == State.ROCK)
			numFingers = 0;
		else if(currentState == State.PAPER)
			numFingers = 5;
		else
			numFingers = 2;
	}
	
	public int getNumWins() {
		return numWins;
	}

	public void setNumWins(int numWins) {
		this.numWins = numWins;
	}

	@Override
	public String toString() {
		return "Player [numFingers=" + numFingers + ", currentState=" + currentState + "]";
	}

	public int getNumFingers() {
		return numFingers;
	}

	public void setNumFingers(int numFingers) {
		this.numFingers = numFingers;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
	
	public void setCurrentState(int numFingers) {
		if(numFingers < 2)
			currentState = State.ROCK;
		else if(numFingers == -1)
			currentState = State.NONE;
		else if(numFingers > 1 && numFingers < 4)
			currentState = State.SCISSORS;
		else
			currentState = State.PAPER;
	}
}
