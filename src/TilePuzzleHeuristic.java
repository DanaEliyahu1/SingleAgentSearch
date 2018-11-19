
public class TilePuzzleHeuristic implements IHeuristic
{

	@Override
	public double getHeuristic(IProblemState problemState)
	{
		if(problemState.isGoalState()){
			return 0;
		}
		else {
			TilePuzzleState State=(TilePuzzleState)problemState;
			int [][] places = State._tilePuzzle;
			int sum=0;
			int n=places.length;
			for (int i = 0; i <n ; i++) {
				for (int j = 0; j <n ; j++) {
					int K = places[i][j];
					if(K==0)continue;
					sum +=(K*(Math.abs(i-((K-1)/n))+Math.abs(j-((K-1)%n))));
				}
			}
			return sum;
		}

	}
	
}
