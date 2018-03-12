import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class GoCounting {
	private Player[][] board;
	
	GoCounting (String boardString) {
		String[] lines = boardString.split("\n");
		
		board = new Player[lines[0].length()][lines.length];
		
		for (int i = 0; i < lines.length; i++) {
			for (int j = 0; j < lines[i].length(); j++) {
				if (lines[i].charAt(j) == 'B') {
					board[j][i] = Player.BLACK;
				} else if (lines[i].charAt(j) == 'W') {
					board[j][i] = Player.WHITE;
				} else {
					board[j][i] = Player.NONE;
				}
			}
		}
	}
	
	private ArrayList<Point> getAdjacent(Point p) {
		ArrayList<Point> adjacent = new ArrayList<>();
		if (p.x > 0) {
			adjacent.add(new Point(p.x - 1, p.y));
		}
		if (p.x < board.length - 1) {
			adjacent.add(new Point(p.x + 1, p.y)); 
		}
		if (p.y > 0) {
			adjacent.add(new Point(p.x, p.y - 1));
		}
		if (p.y < board[0].length - 1) {
			adjacent.add(new Point(p.x, p.y + 1));
		}
		return adjacent;
	}
	
	Player getTerritoryOwner(int x, int y) {
		
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
			throw new IllegalArgumentException("Invalid coordinate");
		}
		
		if (board[x][y] == Player.BLACK || board[x][y] == Player.WHITE) {
			return Player.NONE;
		}
		
		ArrayList<Point> visited = new ArrayList<>();
		ArrayList<Point> edges = new ArrayList<>();
		ArrayList<Point> territory = new ArrayList<>();
		
		ArrayList<Point> tovisit = new ArrayList<>();
		
		tovisit.add(new Point(x, y));
		
		while (tovisit.size() > 0) {
			Point current = tovisit.remove(0);
			
			if (board[current.x][current.y] == Player.NONE) {
				visited.add(current);
				territory.add(current);
				
				ArrayList<Point> adjacent = getAdjacent(current);
				
				for (Point p : adjacent) {
					if (!visited.contains(p) && !tovisit.contains(p)) {
						tovisit.add(p);
					}
				}
			} else {
				edges.add(current);
			}
		}
		
		if (edges.size() == 0) {
			return Player.NONE;
		}
		
		Player owner = board[edges.get(0).x][edges.get(0).y];
		for (int i = 0; i < edges.size(); i++) {
			if (owner != board[edges.get(i).x][edges.get(i).y]) {
				owner = Player.NONE;
			}
		}
		
		return owner;
	}
	
	Set<Point> getTerritory(int x, int y) {
		
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
			throw new IllegalArgumentException("Invalid coordinate");
		}
		
		ArrayList<Point> visited = new ArrayList<>();
		HashSet<Point> territory = new HashSet<>();
		
		ArrayList<Point> tovisit = new ArrayList<>();
		
		tovisit.add(new Point(x, y));
		
		while (tovisit.size() > 0) {
			Point current = tovisit.remove(0);
			
			if (board[current.x][current.y] == Player.NONE) {
				visited.add(current);
				territory.add(current);
				
				ArrayList<Point> adjacent = getAdjacent(current);
				
				for (Point p : adjacent) {
					if (!visited.contains(p) && !tovisit.contains(p)) {
						tovisit.add(p);
					}
				}
			}
		}
		
		return territory;
	}
	
	HashMap<String, Set<Point>> getTerritories() {
		HashMap<String, Set<Point>> territories = new HashMap<String, Set<Point>>();
		
		territories.put("WHITE", new HashSet<Point>());
		territories.put("BLACK", new HashSet<Point>());
		territories.put("NONE", new HashSet<Point>());
		
		for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] == Player.NONE) {
					if (getTerritoryOwner(j, i) == Player.NONE) {
						territories.get("NONE").add(new Point(j, i));
					} else if (getTerritoryOwner(j, i) == Player.BLACK) {
						territories.get("BLACK").add(new Point(j, i));
					} else {
						territories.get("WHITE").add(new Point(j, i));
					}
				}
			}
		}
		
		return territories;
	}
}
