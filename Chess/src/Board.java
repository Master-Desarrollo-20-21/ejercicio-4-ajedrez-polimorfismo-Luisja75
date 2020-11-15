class Board {

	private static final int[] INITIAL_COLUMNS_KING = {4};
	private static final int[] INITIAL_FILE_KING = {0,7};
	private static final int[] INITIAL_COLUMNS_KNIHGT = {1,6};
	private static final int[] INITIAL_FILE_KNIHGT = {0,7};
	private static final int[] INITIAL_COLUMNS_PAWN = {0,1,2,3,4,5,6,7};
	private static final int[] INITIAL_FILE_PAWN = {1,6};
	private Console console;
	private Box[][] boxs;

	public Board(Color[] colors) {
		console = new Console();
		setBoxs();
		setInitialTokens(colors);
	}
	
	private void setBoxs() {
		boxs = new Box[Coordinate.ALLOWS[0].length][Coordinate.ALLOWS[1].length];
		for (int i=0; i<Coordinate.ALLOWS[0].length; i++) {
			for (int j=0; j<Coordinate.ALLOWS[1].length; j++) {
				boxs[i][j] = new Box(new Coordinate(i, j));
			}
		}			
	}		
	
	private void setInitialTokens(Color[] colors) {
		for (int i=0; i<colors.length; i++)
		{
			setInitialTokens(INITIAL_FILE_PAWN[i], INITIAL_COLUMNS_PAWN, new Pawn(colors[i]));
			setInitialTokens(INITIAL_FILE_KNIHGT[i], INITIAL_COLUMNS_KNIHGT, new Knight(colors[i]));
			setInitialTokens(INITIAL_FILE_KING[i], INITIAL_COLUMNS_KING, new King(colors[i]));
		}
	}
	
	private void setInitialTokens(int file, int[] columns, Token token) {
		for (int j : columns)
		{
			(boxs[file][j]).setToken(token);
		}
	}
	
	public void show() {
		console.out("  ");
		for (String column : Coordinate.ALLOWS[1]) {	
			console.out(column + " ");
		}
		console.out("\n");
		
		for (int i=0; i<Coordinate.ALLOWS[0].length; i++) {
			console.out(Coordinate.ALLOWS[0][i] + " ");
			for (int j=0; j<Coordinate.ALLOWS[1].length; j++) {				
				(boxs[i][j]).show();
				console.out(" ");
			}
			console.out("\n");
		}		
		console.out("\n");
	}
	
	public Movement getMovement(Color color) {
		console.out("Mueve el jugador " + color + "\n");
		Movement movement;
		do {
			movement = new Movement(this);
		} while (!this.isMovementCorrect(color, movement));   	
		
		return movement;
	}	
	
	private boolean isMovementCorrect(Color color, Movement movement) {
		return coordenadaOrigenValida(color, movement) && 
			   coordenadaDestinoValida(color, movement) &&
			   movementAllowInToken(color, movement);
	}
	
	private boolean coordenadaOrigenValida(Color color, Movement movement) {
		Box box = this.getBox(movement.getOrigin());
		if(!box.hasToken()) {
			console.out("La coordenada origen no tiene ficha\n");
			return false;
		}
		if (!box.IsPlayer(color)) {
			console.out("La coordenada origen tiene una ficha que no es de tu jugador\n");
			return false;
		}
		return true;
	}

	private boolean coordenadaDestinoValida(Color color, Movement movement) {
		Box box = this.getBox(movement.getDestination());
		if(box.IsPlayer(color)) {
			console.out("La coordenada destino tiene una ficha de tu jugador\n");
			return false;
		}
		
		return true;
	}
	
	private boolean movementAllowInToken(Color color, Movement movement) {		
		boolean isEatPeace = false;
		Box boxDestination = this.getBox(movement.getDestination());
		if(!boxDestination.IsPlayer(color)) {
			isEatPeace = true;
		}

		Box boxOrigin = this.getBox(movement.getOrigin());
		Token tokenOrigin = boxOrigin.getToken();

		return tokenOrigin.isMovementAllow(movement, isEatPeace);
	}
	
	public boolean win() {
		int numberKings = 0;
		for (int i=0; i<Coordinate.ALLOWS[0].length; i++) {
			for (int j=0; j<Coordinate.ALLOWS[1].length; j++) {
				if ((boxs[i][j]).isKing()) {
					numberKings++;
				}
			}
		}
		return (numberKings<2);
	}	

	public Box getBox(Coordinate coordenada) {
		return boxs[coordenada.getRow()-1][coordenada.getColum()-1];
	}

	public void moveToken(Coordinate origin, Coordinate destination) {
		Token token = (boxs[origin.getRow()-1][origin.getColum()-1]).getToken();
		(boxs[origin.getRow()-1][origin.getColum()-1]).setToken(null);
		(boxs[destination.getRow()-1][destination.getColum()-1]).setToken(token);
		token.setMovementDone();
	}	
}
