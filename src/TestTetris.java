import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.awt.Color;

public class TestTetris {
	@Test
	public void testSingleRowCheckRow() {
		// single row check
		Grid grid = new Grid();	
		setupRowCheck(grid,1);
		grid.checkRows();
		checkRowCheck(grid);
	}
	
	@Test
	public void testDoubleRowCheckRows() {
		// double row check
		Grid grid = new Grid();
		setupRowCheck(grid,2);
		grid.checkRows();
		checkRowCheck(grid);
	}
	
	private static void checkRowCheck(Grid grid) {
		
		// all squares should empty except: (row: 19, col: 0)
		//									(row: 19, col: 5)
		//									(row: 19, col 8)
		
		for (int row = 0; row < Grid.HEIGHT; row++) {
			for (int col = 0; col < Grid.WIDTH; col++) {
				if ( row != 19) {
					// all squares not in row 19 should be empty
					assertTrue(!grid.isSet(row, col));
				} else if ((col == 0) || (col == 5) || (col == 8)){
					// squares in row 19 and in either col: 0,5 or 8
					// must be not empty
					assertTrue(grid.isSet(row, col));
				} else {
					// squares in row 19 and NOT in either col: 0,5 or 8
					// must be empty
					assertTrue(!grid.isSet(row, col));
				}
			}
		}
	}
	
	private static void setupRowCheck(Grid grid, int numOfRows) {
		// add a two full rows
		for (int row = Grid.HEIGHT - numOfRows ; row < Grid.HEIGHT; row++) {
			for (int col = 0; col < Grid.WIDTH; col++) {
				grid.set(row, col, Color.RED);
			}
		}
		int foo = numOfRows + 1;
		// add some colored squares above
		grid.set(Grid.HEIGHT - foo, 0, Color.RED);
		grid.set(Grid.HEIGHT - foo, 5, Color.RED);
		grid.set(Grid.HEIGHT - foo, 8, Color.RED);
	}
	
	
	@Test
	public static void testMovement() {
		Grid grid = new Grid();
		LShape peice = new LShape(1, Grid.WIDTH / 2 - 1, grid);
		// can move left
			// walls
			// set peices
		// can move right
			// walls
			// set peices
		// can move down
			// walls
			// set peices
		
		
	}

	
}
