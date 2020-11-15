class King extends Piece {
	
	private static final int LIMIT_NUMBER_VOX_MOVEMENT = 1;
	
	public King(Color color){
		super(color);
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
	public void setMovementDone() {
	}
	
	@Override
	public boolean isKing() {
		return true;
	}
	
	@Override
	public void show() {
		if (this.color == Color.WHITE) {
			console.out(TypeToken.KING.getKeyword().toLowerCase());
		} 
		else {
			console.out(TypeToken.KING.getKeyword().toUpperCase());
		}
	}	
}
