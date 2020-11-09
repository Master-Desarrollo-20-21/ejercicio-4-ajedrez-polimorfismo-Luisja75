class Board {

	private static final int DIMENSION_BOARD = 8;
	private static final int[] INITIAL_COLUMNS_KING = {4};
	private static final int[] INITIAL_FILE_KING = {0,7};
	private static final int[] INITIAL_COLUMNS_KNIHGT = {1,6};
	private static final int[] INITIAL_FILE_KNIHGT = {0,7};
	private static final int[] INITIAL_COLUMNS_PAWN = {0,1,2,3,4,5,6,7};
	private static final int[] INITIAL_FILE_PAWN = {1,6};
	private Console console;
	private Box[][] boxs;

	public Board(Player[] players) {
		console = new Console();
		setBoxs();
		setInitialTokens(players);
	}
	
	public void show() {
		console.out("  1 2 3 4 5 6 7 8\n");
		for (int i=0; i<=DIMENSION_BOARD-1; i++) {
			console.out(i+1 + " ");
			for (int j=0; j<=DIMENSION_BOARD-1; j++) {				
				(boxs[i][j]).show();
				console.out(" ");
			}
			console.out("\n");
		}		
		console.out("\n");
	}
	
	public boolean win() {
		int numberKings = 0;
		for (int i=0; i<=DIMENSION_BOARD-1; i++) {
			for (int j=0; j<=DIMENSION_BOARD-1; j++) {
				if ((boxs[i][j]).isKing()) {
					numberKings++;
				}
			}
		}
		return (numberKings<2);
	}	

	public Box getBox(Coordenada coordenada) {
		return boxs[coordenada.fila-1][coordenada.columna-1];
	}

	public void moveToken(Coordenada origin, Coordenada destination) {
		Token token = (boxs[origin.fila-1][origin.columna-1]).getToken();
		(boxs[origin.fila-1][origin.columna-1]).setToken(null);
		(boxs[destination.fila-1][destination.columna-1]).setToken(token);
	}	

	private void setBoxs() {
		boxs = new Box[DIMENSION_BOARD][DIMENSION_BOARD];
		for (int i=0; i<=DIMENSION_BOARD-1; i++) {
			for (int j=0; j<=DIMENSION_BOARD-1; j++) {
				boxs[i][j] = new Box(new Coordenada(i, j));
			}
		}			
	}
	
	private void setInitialTokens(Player[] players) {
		for (int i=0; i<players.length; i++)
		{
			setInitialTokens(INITIAL_FILE_PAWN[i], INITIAL_COLUMNS_PAWN, new Pawn(players[i]));
			setInitialTokens(INITIAL_FILE_KNIHGT[i], INITIAL_COLUMNS_KNIHGT, new Knight(players[i]));
			setInitialTokens(INITIAL_FILE_KING[i], INITIAL_COLUMNS_KING, new King(players[i]));
		}
	}
	
	private void setInitialTokens(int file, int[] columns, Token token) {
		for (int j : columns)
		{
			(boxs[file][j]).setToken(token);
		}
	}
}
