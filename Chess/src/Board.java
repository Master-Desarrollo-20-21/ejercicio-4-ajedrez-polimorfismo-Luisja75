class Board {

	private static final int[] INITIAL_COLUMNS_KING = {4};
	private static final int[] INITIAL_FILE_KING = {0,7};
	private static final int[] INITIAL_COLUMNS_KNIHGT = {1,6};
	private static final int[] INITIAL_FILE_KNIHGT = {0,7};
	private static final int[] INITIAL_COLUMNS_PAWN = {0,1,2,3,4,5,6,7};
	private static final int[] INITIAL_FILE_PAWN = {1,6};
	private Square[][] squares;
	Console console;
	
	public Board(Color[] colors) {
		console = new Console();
		setSquares();
		setInitialSquares(colors);
	}
	
	private void setSquares() {
		squares = new Square[Coordinate.ALLOWS[0].length][Coordinate.ALLOWS[1].length];
		for (int i=0; i<Coordinate.ALLOWS[0].length; i++) {
			for (int j=0; j<Coordinate.ALLOWS[1].length; j++) {
				squares[i][j] = new Square();
			}
		}			
	}		
	
	private void setInitialSquares(Color[] colors) {
		for (int i=0; i<colors.length; i++)
		{
			setInitialSquares(INITIAL_FILE_PAWN[i], INITIAL_COLUMNS_PAWN, new Pawn(colors[i]));
			setInitialSquares(INITIAL_FILE_KNIHGT[i], INITIAL_COLUMNS_KNIHGT, new Knight(colors[i]));
			setInitialSquares(INITIAL_FILE_KING[i], INITIAL_COLUMNS_KING, new King(colors[i]));
		}
	}
	
	private void setInitialSquares(int file, int[] columns, Piece piece) {
		for (int j : columns)
		{
			(squares[file][j]).setPiece(piece);
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
				(squares[i][j]).show();
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
			movement = new Movement();
		} while (!this.isMovementCorrect(color, movement));   	
		
		return movement;
	}	
	
	private boolean isMovementCorrect(Color color, Movement movement) {
		return coordenadaOrigenValida(color, movement) && 
			   coordenadaDestinoValida(color, movement) &&
			   movementAllowInToken(color, movement);
	}
	
	private boolean coordenadaOrigenValida(Color color, Movement movement) {
		Square box = this.getBox(movement.getOrigin());
		if(!box.hasPiece()) {
			console.out("La coordenada origen no tiene ficha\n");
			return false;
		}
		if (!box.IsColor(color)) {
			console.out("La coordenada origen tiene una ficha que no es de tu jugador\n");
			return false;
		}
		return true;
	}

	private boolean coordenadaDestinoValida(Color color, Movement movement) {
		Square box = this.getBox(movement.getDestination());
		if(box.IsColor(color)) {
			console.out("La coordenada destino tiene una ficha de tu jugador\n");
			return false;
		}		
		return true;
	}
	
	private boolean movementAllowInToken(Color color, Movement movement) {
		DataMovement dataMovement = new DataMovement(this, color, movement);
		Square boxOrigin = this.getBox(movement.getOrigin());
		Piece tokenOrigin = boxOrigin.getPiece();
		return tokenOrigin.isMovementAllow(dataMovement);
	}

	public Square getBox(Coordinate coordenada) {
		return squares[coordenada.getRow()-1][coordenada.getColum()-1];
	}

	public boolean moveToken(Coordinate origin, Coordinate destination) {
		boolean win = false;

		Square squareOrigin = squares[origin.getRow()-1][origin.getColum()-1];
		Piece pieceOrigin = squareOrigin.getPiece();
		squareOrigin.setPiece(null);

		Square squareDestination = squares[destination.getRow()-1][destination.getColum()-1]; 		
		win = squareDestination.isKing();
		squareDestination.setPiece(pieceOrigin);
		pieceOrigin.setMovementDone();
		
		return win;
	}
}
