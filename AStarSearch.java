import java.util.*;

public class AStarSearch implements GraphSearchAlgorithm {
	LinkedList<State> vertices;

	public void Graph() {
		vertices = new LinkedList<State>();
	}

	public Path search(State start, State goal) {
		PathPriorityQueue frontier = new PathPriorityQueue();
		HashSet<State> visited = new HashSet<State>();
		Path path = new Path(start); // create new path, pass in state

		frontier.add(path, path.getCost()); // add the new path to the frontier(discovered, but not yet visited)
		while (!frontier.isEmpty()) {
			if (goal.equals(path.getLastState())) {
				return path;
			}

			path = frontier.poll();
			visited.add(path.getLastState());
			List<Action> actions = path.getLastState().getActions();
			int score = path.getCost();

			for (Action a : actions) {
				if (!visited.contains(a.getNextState())) {// does not contain next state(result of the action)
					int cost = a.getCost();// calculate the cost
					int heuristic = a.getNextState().heuristicTo(goal); // find heuristic

					int total = score + cost + heuristic;
					Path newPath = new Path(path, a); // create new path w added action
					frontier.add(newPath, total);
				}
			}
		}
		return null;

	}
}