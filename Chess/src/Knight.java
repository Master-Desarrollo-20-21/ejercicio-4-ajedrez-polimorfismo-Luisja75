class Knight extends Piece {
		
	public Knight(Color color)
	{
		super(color);
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
	public void setMovementDone() {
	}
	
	@Override
	public boolean isKing() {
		return false;
	}
	
	@Override
	public void show() {
		if (this.color == Color.WHITE) {
			console.out(TypeToken.KNIGHT.getKeyword().toLowerCase());
		} 
		else {
			console.out(TypeToken.KNIGHT.getKeyword().toUpperCase());
		}
	}	
}
