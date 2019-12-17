
import java.util.*;

public class DepthFirstSearch implements GraphSearchAlgorithm {
	public Path search(State start, State goal) {

		LinkedList<Path> frontier = new LinkedList<>();
		HashSet<State> visited = new HashSet<State>();
		Path path = new Path(start);
		frontier.add(path);
		while (!frontier.isEmpty()) {
			
			if (goal.equals(path.getLastState())) {
				return path;
			}
			
			path = frontier.removeLast(); 
			visited.add(path.getLastState());
			
			List<Action> actions = path.getLastState().getActions();
			for (Action a : actions) {
				if (!visited.contains(a.getNextState())) {// does not contain action get next state) {
					Path newP = new Path(path, a);
					frontier.add(newP);
				
				}
			}
		}
		return null;

	}

}