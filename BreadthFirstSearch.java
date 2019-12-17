import java.util.*;

public class BreadthFirstSearch implements GraphSearchAlgorithm {
	LinkedList<State> vertices;

	public Path search(State start, State goal) {
		LinkedList<Path> frontier = new LinkedList<>();
		HashSet<State> visited = new HashSet<State>();
		Path path = new Path(start); // create new path, pass in state
		frontier.add(path); // add the new path to the frontier(discovered, but not yet visited)
		while (!frontier.isEmpty()) {
			path = frontier.pop(); // takes from the beginning
			visited.add(path.getLastState());
			List<Action> actions = path.getLastState().getActions();

			for (Action a : actions) {
				if (!visited.contains(a.getNextState())) {// does not contain action get next state) {
					Path newPath = new Path(path, a);
					frontier.add(newPath);
					if (goal.equals(newPath.getLastState())) {
						return newPath;
					}
				}
			}
		}
		return null;
	}
}