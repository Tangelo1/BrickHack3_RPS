import java.util.ArrayList;

public class AI {
	private static int difficulty;
	private State currentState;
	private static ArrayList<State> pStates = new ArrayList<State>();
	private static ArrayList<State> aiStates = new ArrayList<State>();
	
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
				
				if(pStates.size() == 0) {
					pStates.add(player.getCurrentState());
					aiStates.add(State.PAPER);
					return State.PAPER;
				}
				else if(pStates.size() < 10) {
					if((pStates.get(pStates.size() - 1) == State.PAPER &&
							aiStates.get(aiStates.size() - 1) == State.SCISSORS) ||
							(pStates.get(pStates.size() - 1) == State.SCISSORS) && (aiStates.get(aiStates.size() - 1) == State.ROCK) ||
							(pStates.get(pStates.size() - 1) == State.ROCK) && (aiStates.get(aiStates.size() - 1) == State.PAPER)) {
				        if(pStates.get(pStates.size() - 1) == State.PAPER) { pStates.add(State.ROCK); aiStates.add(State.PAPER);
				            return State.ROCK;}
				        else if(pStates.get(pStates.size() - 1) == State.SCISSORS){ pStates.add(State.PAPER);aiStates.add(State.PAPER);
				            return State.PAPER; }
				        else { pStates.add(State.SCISSORS);aiStates.add(State.ROCK);
				            return State.SCISSORS; }
					}
					else if((pStates.get(pStates.size() - 1) == State.PAPER && aiStates.get(aiStates.size() - 1) == State.ROCK)
					        || (pStates.get(pStates.size() - 1) == State.SCISSORS && aiStates.get(aiStates.size() - 1) == State.PAPER)
					        || (pStates.get(pStates.size() - 1) == State.ROCK && aiStates.get(aiStates.size() - 1) == State.SCISSORS)) {
						pStates.add(aiStates.get(aiStates.size() - 1));aiStates.add(State.SCISSORS);
						return aiStates.get(aiStates.size() - 1);
					}
				    else {
				        if(pStates.get(pStates.size() - 1) == State.ROCK){ pStates.add(State.PAPER);aiStates.add(State.SCISSORS);
				            return State.PAPER;}
				        else if(pStates.get(pStates.size() - 1) == State.SCISSORS){ pStates.add(State.ROCK);aiStates.add(State.ROCK);
				            return State.ROCK;}
				        else{ pStates.add(State.PAPER);aiStates.add(State.SCISSORS);
				            return State.SCISSORS; }
				    }
				}
				else {
					pStates.add(player.getCurrentState());
					State mode;
					int r = 0, p = 0, s = 0;
					for(State st: pStates) {
						if(st == State.ROCK) r++;
						if(st == State.PAPER) p++;
						if(st == State.SCISSORS) s++;
					}
					if(p >= r && p >= s) mode = State.PAPER;
					else if(r >= p && r >= s) mode = State.ROCK;
					else mode = State.ROCK;
					
					if(mode == State.ROCK)
						return State.PAPER;
					else if(mode == State.PAPER)
						return State.SCISSORS;
					else
						return State.ROCK;
					
				}
				
				//no break necessary
			
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
