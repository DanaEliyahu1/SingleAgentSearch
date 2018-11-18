import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class AStarSearch   extends ASearch
{
	// Define lists here ...
	PriorityQueue<ASearchNode> openlist;
	HashSet<ASearchNode> closelist;
	
	@Override
	public String getSolverName() 
	{
		return "AStar";
	}
	
	@Override
	public ASearchNode createSearchRoot(
		IProblemState problemState
	) 
	{	
		ASearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}

	@Override
	public void initLists()
	{
		openlist = new PriorityQueue<>(new Comparator<ASearchNode>() {
			@Override
			public int compare(ASearchNode o1, ASearchNode o2) {
				return (int)(o1.getF()-o2.getF());
			}
		});
		closelist = new HashSet<>();
	}

	@Override
	public ASearchNode getOpen(ASearchNode node)
	{
		if (isOpen(node)){
			return node;
		}
		return null;
	}

	@Override
	public boolean isOpen(ASearchNode node)
	{
		if (openlist.contains(node)) {
			return true;
		}
		return false;
	}


	@Override
	public boolean isClosed(ASearchNode node)
	{
		if (closelist.contains(node)) {
			return true;
		}
		return false;
	}



	@Override
	public void addToOpen(ASearchNode node){
		openlist.add(node);
	}


	@Override
	public void addToClosed(ASearchNode node){
		closelist.add(node);
	}


	@Override
	public int openSize() 
	{
		return openlist.size();
	}

	@Override
	public ASearchNode getBest() 
	{
		return openlist.poll();
	}

}
