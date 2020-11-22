class King extends Piece {
	
	private static final int LIMIT_NUMBER_VOX_MOVEMENT = 1;
	public static final String UNICODE_PIECE_WHITE = "\u2654";
	public static final String UNICODE_PIECE_BLACK = "\u265A";
	
	public King(Color color){
		super(color);
	}
	
	@Override
	public void setMovementDone() {
	}
	
	@Override
	public boolean isKing() {
		return true;
	}
	
	@Override
	protected boolean isDirectionAllow(TypeDirection typeDirection) {
		return  true;
	}
	
	@Override
	protected boolean isDistanceAllow(int distance) {
		return distance == King.LIMIT_NUMBER_VOX_MOVEMENT;
	}	
	
	@Override
	protected boolean isMovementAllow(TypeMovement typeMovement, boolean isEatPeace) {
		return true;
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
			return King.UNICODE_PIECE_WHITE;
		} 
		else {
			return King.UNICODE_PIECE_BLACK;
		}
	}	
}
