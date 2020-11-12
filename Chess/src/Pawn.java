class Pawn extends Token {

	private static final int LIMIT_NUMBER_VOX_MOVEMENT = 1;
	private static final int LIMIT_NUMBER_VOX_FIRST_MOVEMENT = 2;
	private boolean firstMovement;
	
	public Pawn(Color color)
	{
		super(color);
		firstMovement = true;		
	}

	@Override
	public boolean isDirectionAllow(TypeDirection typeDirection) {
		return  (color == Color.WHITE && typeDirection==TypeDirection.FORWARD) ||
				(color == Color.WHITE && typeDirection==TypeDirection.BACK);
	}
	
	@Override
	public boolean isDistanceAllow(int distance) {
		int distanceMAximumAllow = Pawn.LIMIT_NUMBER_VOX_MOVEMENT;
		if (firstMovement) {
			distanceMAximumAllow = Pawn.LIMIT_NUMBER_VOX_FIRST_MOVEMENT;
		}		
		return distance <= distanceMAximumAllow;
	}
	
	@Override
	public boolean isMovementAllow(TypeMovement typeMovement) {
		return typeMovement == TypeMovement.VERTICAL || typeMovement == TypeMovement.DIAGONAL_BY_EAT;
	}
	
	@Override
	public boolean isKing() {
		return false;
	}
	
	@Override
	public void show() {
		if (color == Color.WHITE) {
			console.out(TypeToken.PAWN.getKeyword().toLowerCase());
		} 
		else {
			console.out(TypeToken.PAWN.getKeyword().toUpperCase());
		}
	}		
}
