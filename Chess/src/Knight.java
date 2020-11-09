class Knight extends Token {
		
	public Knight(Player player)
	{
		super(player);
	}
	
	@Override
	public boolean isDirectionAllow(TypeDirection typeDirection) {
		return true;
	}
	
	@Override
	public boolean isDistanceAllow(int distance) {
		return true;
	}
			
	@Override
	public boolean isMovementAllow(TypeMovement typeMovement) {
		if (typeMovement == TypeMovement.L)	{
			return true;
		}
		else {
			return false;
		}
	}	
	
	@Override
	public boolean isKing() {
		return false;
	}
	
	@Override
	public void show() {
		if (player.isWhite()) {
			console.out(TypeToken.KNIGHT.getKeyword().toLowerCase());
		} 
		else {
			console.out(TypeToken.KNIGHT.getKeyword().toUpperCase());
		}
	}	
}
