class King extends Token {
	
	private static final int LIMIT_NUMBER_VOX_MOVEMENT = 1;
	
	public King(Color color){
		super(color);
	}
	
	@Override
	public boolean isDirectionAllow(TypeDirection typeDirection) {
		return  true;
	}
	
	@Override
	public boolean isDistanceAllow(int distance) {
		return distance == King.LIMIT_NUMBER_VOX_MOVEMENT;
	}	
	
	@Override
	public boolean isMovementAllow(TypeMovement typeMovement) {
		return true;
	}	
	
	@Override
	public boolean isKing() {
		return true;
	}
	
	@Override
	public void show() {
		if (color == Color.WHITE) {
			console.out(TypeToken.KING.getKeyword().toLowerCase());
		} 
		else {
			console.out(TypeToken.KING.getKeyword().toUpperCase());
		}
	}	
}
