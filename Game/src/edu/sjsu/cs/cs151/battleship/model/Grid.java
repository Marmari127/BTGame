package edu.sjsu.cs.cs151.battleship.model;

/**
 * Constructs grid with a fixed length and width. Each cell has a coordinate object. 
 */
public class Grid 
{
	/**
	 * Constructor for Grid.
	 */
	public Grid()
	{
		grid = new Coordinates[GRID_ROW][GRID_COLUMN];
		for(int i = 0; i < GRID_ROW; i++)
		{
			for(int j = 0; j< GRID_COLUMN; j++)
			{
				grid[i][j] = new Coordinates(i,j);
			}

		}
	}

	/**
	 * Returns coordinates of specific grid
	 * @return coordinates
	 */
	public Coordinates[][] getCoordinate()
	{
		return grid;
	}

	/**
	 * Returns coordinates of specific grid
	 * @return coordinates
	 */
	public Coordinates getCoordinate(int x, int y)
	{
		return grid[x][y];
	} 
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param isHit
	 */
	public void setCoordinates(int x, int y, boolean isHit)
	{
		grid[x][y].setHit(isHit);
	}

	/**
	 * 
	 * @param ship
	 * @param row
	 * @param col
	 * @param alignment
	 */
	public void addShip(Ship ship, int row, int col, int alignment)
	{
		int r = row;
		int c = col;

		if(alignment == Ship.HORIZONTAL)
		{
			for(int i = c; i < c + ship.getShipSize(); i++)
			{
				if(grid[r][i].containsShip == true)
				{
					throw new IllegalArgumentException("Ship already exists at Cooridnates (" + r + ","  + c + ")");
				}
				grid[r][i].setContainsShip(true);
			}


		}
		else
		{
			for(int i = r; i < r + ship.getShipSize(); i++)
			{
				if(grid[i][c].containsShip == true)
				{
					throw new IllegalArgumentException("Ship already exists at Coordinates (" + r + ","  + c + ")");
				}
				grid[i][c].setContainsShip(true);
			}
		}


	}

	/**
	 * 
	 * @return
	 */
	public boolean isValidLocation()
	{

		return true;
	}

	/**
	 * 
	 * @param row
	 * @param col
	 */
	public void guessShip(int row, int col)
	{

		if(this.getCoordinate(row, col).containsShip == false)
		{
			this.getCoordinate(row, col).setStatus("M");
		}
		else
		{
			this.getCoordinate(row, col).setStatus("H");
		}
	}

	/**
	 * 
	 */
	public void printOppGrid()
	{
		System.out.println("Opponent Grid");
		for(int i = 0; i < GRID_ROW; i++)
		{
			for(int j = 0; j< GRID_COLUMN; j++)
			{
				System.out.print(grid[i][j].getStatus() + " ");
			}
			System.out.println("");

		}

		System.out.println(" ");
	}

	/**
	 * 
	 */
	public void printGrid()
	{
		System.out.println("Player Grid");

		for(int i = 0; i < GRID_ROW; i++)
		{
			for(int j = 0; j< GRID_COLUMN; j++)
			{
				if(grid[i][j].containsShip == false)
				{
					System.out.print("- ");
				}
				else
				{
					System.out.print("x ");

				}
			}
			System.out.println("");
		}
		System.out.println(" ");
	}

	public static final int GRID_ROW = 10;
	public static final int GRID_COLUMN = 10;

	private Coordinates[][] grid;
}