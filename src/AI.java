
public class AI {
	public AI(){}
	
	public State getState(Player player){
		State human = player.getCurrentState();
		int rand = (int) (Math.random()*20);
		if(rand >= 0&& rand <=16){
			if(human == State.ROCK)
				return State.PAPER;
			else if(human == State.PAPER)
				return State.SCISSORS;
			else
				return State.ROCK;
		}
		else if(rand == 17)
			return State.ROCK;
		else if(rand == 18)
			return State.PAPER;
		else
			return State.SCISSORS;
			
	}
}
