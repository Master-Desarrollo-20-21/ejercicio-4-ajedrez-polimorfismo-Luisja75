class Queen extends Piece {
	
	public static final String UNICODE_PIECE_WHITE = "\u2655";
	public static final String UNICODE_PIECE_BLACK = "\u265B";
	
	public Queen(Color color){
		super(color);
	}
	
	@Override
	public void setMovementDone() {
	}
	
	@Override
	public boolean isKing() {
		return false;
	}
	
	@Override
	protected boolean isDirectionAllow(TypeDirection typeDirection) {
		return  true;
	}
	
	@Override
	protected boolean isDistanceAllow(int distance) {
		return true;
	}	
	
	@Override
	protected boolean isMovementAllow(TypeMovement typeMovement, boolean isEatPeace) {
		return true;
	}	
	
	@Override
	protected boolean isFreeWay(boolean freeWay) {
		if (!freeWay) {
			console.out("El movimiento introducido no est� permitido porque hay piezas en el camnino\n");
		}
		return freeWay;
	}
	
	@Override
	protected String getSymbol() {
		if (this.color == Color.WHITE) {
			return Queen.UNICODE_PIECE_WHITE;
		} 
		else {
			return Queen.UNICODE_PIECE_BLACK;
		}
	}
}
