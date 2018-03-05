import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.awt.Point;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.util.HashSet;

public class GoCountingTest {
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none(); 
	
	String board5x5 = "  B  \n" +
	                  " B B \n" +
	                  "B W B\n" +
	                  " W W \n" +
	                  "  W  ";
	
	@Test
	public void blackCorner5x5BoardTest() {
		GoCounting gocounting = new GoCounting(board5x5);
		
		Set<Point> territory = new HashSet<>();
		territory.add(new Point(0, 0));
		territory.add(new Point(0, 1));
		territory.add(new Point(1, 0));
		
		assertEquals(gocounting.BLACK, gocounting.getTerritoryOwner(0, 1));
		assertEquals(territory, gocounting.getTerritory(0, 1));
	}
	
	@Test
	public void whiteCenter5x5BoardTest() {
		GoCounting gocounting = new GoCounting(board5x5);
		
		Set<Point> territory = new HashSet<>();
		territory.add(new Point(2, 3));
		
		assertEquals(gocounting.WHITE, gocounting.getTerritoryOwner(2, 3));
		assertEquals(territory, gocounting.getTerritory(2, 3));
	}
	
	@Test
	public void openCorner5x5BoardTest() {
		GoCounting gocounting = new GoCounting(board5x5);
		
		Set<Point> territory = new HashSet<>();
		territory.add(new Point(0, 3));
		territory.add(new Point(0, 4));
		territory.add(new Point(1, 4));
		
		assertEquals(gocounting.NONE, gocounting.getTerritoryOwner(1, 4));
		assertEquals(territory, gocounting.getTerritory(1, 4));
	}
	
	@Test
	public void stoneNotTerritory5x5Board() {
		GoCounting gocounting = new GoCounting(board5x5);
		
		Set<Point> territory = new HashSet<>();
		
		assertEquals(gocounting.NONE, gocounting.getTerritoryOwner(1, 1));
		assertEquals(territory, gocounting.getTerritory(1, 1));
	}
	
	@Test
	public void invalidXTooLow5x5Board() {
		GoCounting gocounting = new GoCounting(board5x5);
		
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Invalid coordinate");
		
		gocounting.getTerritory(-1, 1);
	}
	
	@Test
	public void invalidXTooHigh5x5Board() {
		GoCounting gocounting = new GoCounting(board5x5);
		
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Invalid coordinate");
		
		gocounting.getTerritory(5, 1);
	}
	
	@Test
	public void invalidYTooLow5x5Board() {
		GoCounting gocounting = new GoCounting(board5x5);
		
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Invalid coordinate");
		
		gocounting.getTerritory(1, -1);
	}
	
	@Test
	public void invalidYTooHigh5x5Board() {
		GoCounting gocounting = new GoCounting(board5x5);
		
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("Invalid coordinate");
		
		gocounting.getTerritory(1, 5);
	}
	
	@Test
	public void oneTerritoryIsWholeBoardTest() {
		GoCounting gocounting = new GoCounting(" ");
		
		HashMap<String, Set<Point>> territories = new HashMap<>();
		Set<Point> blackTerritory = new HashSet<>();
		Set<Point> whiteTerritory = new HashSet<>();
		Set<Point> noneTerritory = new HashSet<>();
		noneTerritory.add(new Point(0, 0));
		
		territories.put("BLACK", blackTerritory);
		territories.put("WHITE", whiteTerritory);
		territories.put("NONE", noneTerritory);
		
		assertEquals(territories, gocounting.getTerritories());
	}
	
	@Test
	public void twoTerritoryRectangularBoardTest() {
		GoCounting gocounting = new GoCounting(" BW \n BW ");
		
		Set<Point> blackTerritory = new HashSet<>();
		blackTerritory.add(new Point(0, 0));
		blackTerritory.add(new Point(0, 1));
		
		Set<Point> whiteTerritory = new HashSet<>();
		whiteTerritory.add(new Point(3, 0));
		whiteTerritory.add(new Point(3, 1));
		
		Set<Point> noneTerritory = new HashSet<>();
		
		HashMap<String, Set<Point>> territories = new HashMap<>();
		territories.put("BLACK", blackTerritory);
		territories.put("WHITE", whiteTerritory);
		territories.put("NONE", noneTerritory);
		
		assertEquals(territories, gocounting.getTerritories());
	}
	
	@Test
	public void twoRegionRectangularBoardTest() {
		GoCounting gocounting = new GoCounting(" B ");
		
		HashMap<String, Set<Point>> territories = new HashMap<>();
		Set<Point> blackTerritory = new HashSet<>();
		blackTerritory.add(new Point(0, 0));
		blackTerritory.add(new Point(2, 0));
		Set<Point> whiteTerritory = new HashSet<>();
		Set<Point> noneTerritory = new HashSet<>();
		
		territories.put("BLACK", blackTerritory);
		territories.put("WHITE", whiteTerritory);
		territories.put("NONE", noneTerritory);
		
		assertEquals(territories, gocounting.getTerritories());
	}
}
