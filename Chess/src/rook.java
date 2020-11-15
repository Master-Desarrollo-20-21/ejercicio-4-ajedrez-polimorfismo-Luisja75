class Rook extends Piece {
		
	public Rook(Color color){
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
	public void setMovementDone() {
	}
	
	@Override
	public boolean isKing() {
		return false;
	}

	@Override
	public String getKeyword() {
		return TypeToken.ROOK.getKeyword();
	}	
}
