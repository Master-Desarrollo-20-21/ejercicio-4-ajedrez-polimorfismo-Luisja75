class Bishop extends Piece {

	public static final String UNICODE_PIECE_WHITE = "\u2657";
	public static final String UNICODE_PIECE_BLACK = "\u265D";
	
	
	public Bishop(Color color){
		super(color);
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
		return typeMovement == TypeMovement.DIAGONAL;
	}	
	
	@Override
	protected boolean isFreeWay(boolean freeWay) {
		if (!freeWay) {
			console.out("El movimiento introducido no está permitido porque hay piezas en el camnino\n");
		}
		return freeWay;
	}	
	
	@Override
	public void setMovementDone() {
	}
	
	@Override
	public boolean isKing() {
		return true;
	}
	
	@Override
	public String getSymbol() {
		if (this.color == Color.WHITE) {
			return Bishop.UNICODE_PIECE_WHITE;
		} 
		else {
			return Bishop.UNICODE_PIECE_BLACK;
		}
	}	
}
