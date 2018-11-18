import java.util.LinkedList;

public class BreadthFirstSearch extends ASearch {
    // Define lists here ...
    LinkedList<ASearchNode> openlist;
    LinkedList<ASearchNode> closelist;

    @Override
    public String getSolverName() {
        return "BFS";
    }

    @Override
    public ASearchNode createSearchRoot
            (
                    IProblemState problemState
            ) {
        ASearchNode newNode = new BlindSearchNode(problemState);
        return newNode;
    }

    @Override
    public void initLists() {
        openlist = new LinkedList<>();
        closelist = new LinkedList<>();
    }

    @Override
    public ASearchNode getOpen(ASearchNode node) {
        if (isOpen(node)) {
            return node;
        }
        return null;
    }

    @Override
    public boolean isOpen(ASearchNode node) {
        if (openlist.contains(node)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isClosed(ASearchNode node){
        if(closelist.contains(node)){
            return true;
        }
        return false;
    }

    @Override
    public void addToOpen(ASearchNode node) {
        openlist.add(node);
    }

    @Override
    public void addToClosed(ASearchNode node) {
        closelist.add(node);
    }

    @Override
    public int openSize() {
        return openlist.size();
    }

    @Override
    public ASearchNode getBest() {
        return openlist.removeFirst();
    }


}
