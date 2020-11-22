class Rook extends Piece {

	public static final String UNICODE_PIECE_WHITE = "\u2656";
	public static final String UNICODE_PIECE_BLACK = "\u265C";
	
	public Rook(Color color){
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
		return typeMovement == TypeMovement.VERTICAL || typeMovement == TypeMovement.HORIZONTAL;
	}	
	
	@Override
	protected boolean isFreeWay(boolean freeWay) {
		if (!freeWay) {
			console.out("El movimiento introducido no está permitido porque hay piezas en el camnino\n");
		}
		return freeWay;
	}	

	@Override
	protected String getSymbol() {
		if (this.color == Color.WHITE) {
			return Rook.UNICODE_PIECE_WHITE;
		} 
		else {
			return Rook.UNICODE_PIECE_BLACK;
		}
	}	
}
