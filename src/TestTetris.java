import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.awt.Color;
public class TestTetris {
	@Test
	public void testCheckRows() {
		Grid grid = new Grid();
		// add a full row
		for (int col = 0; col < Grid.WIDTH; col++) {
			grid.set(Grid.HEIGHT - 1, col, Color.RED);
		}
		// add some colored squares above
		grid.set(Grid.HEIGHT - 2, 0, Color.RED);
		grid.set(Grid.HEIGHT - 2, 5, Color.RED);
		grid.set(Grid.HEIGHT - 2, 8, Color.RED);
		
		// run checkRows
		grid.checkRows();
		
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
}
