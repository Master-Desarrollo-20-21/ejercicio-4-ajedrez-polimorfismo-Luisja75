class Knight extends Piece {

	public static final String UNICODE_PIECE_WHITE = "\u2658";
	public static final String UNICODE_PIECE_BLACK = "\u265E";
	
	public Knight(Color color)
	{
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
		return true;
	}
	
	@Override
	protected boolean isDistanceAllow(int distance) {
		return true;
	}
			
	@Override
	protected boolean isMovementAllow(TypeMovement typeMovement, boolean isEatPeace) {
		if (typeMovement == TypeMovement.L)	{
			return true;
		}
		else {
			return false;
		}
	}	

	@Override
	protected boolean isFreeWay(boolean freeWay) {
		return true;
	}	
	
	@Override
	protected String getSymbol() {
		if (this.color == Color.WHITE) {
			return Knight.UNICODE_PIECE_WHITE;
		} 
		else {
			return Knight.UNICODE_PIECE_BLACK;
		}
	}	
}
