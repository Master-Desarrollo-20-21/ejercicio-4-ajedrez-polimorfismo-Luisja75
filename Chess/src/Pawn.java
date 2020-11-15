class Pawn extends Piece {

	private static final int LIMIT_NUMBER_VOX_MOVEMENT = 1;
	private static final int LIMIT_NUMBER_VOX_FIRST_MOVEMENT = 2;
	private boolean firstMovement;
	
	public Pawn(Color color)
	{
		super(color);
		firstMovement = true;		
	}
	
	@Override
	protected boolean isDirectionAllow(TypeDirection typeDirection) {
		return  (color == Color.WHITE && typeDirection==TypeDirection.FORWARD) ||
				(color == Color.BLACK && typeDirection==TypeDirection.BACK);
	}
	
	@Override
	protected boolean isDistanceAllow(int distance) {
		int distanceMAximumAllow = Pawn.LIMIT_NUMBER_VOX_MOVEMENT;
		if (firstMovement) {
			distanceMAximumAllow = Pawn.LIMIT_NUMBER_VOX_FIRST_MOVEMENT;
		}		
		return distance <= distanceMAximumAllow;
	}
	
	@Override
	protected boolean isMovementAllow(TypeMovement typeMovement, boolean isEatPeace) {
		return typeMovement == TypeMovement.VERTICAL || (typeMovement == TypeMovement.DIAGONAL && isEatPeace);
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
		this.firstMovement = false;
	}
	
	@Override
	public boolean isKing() {
		return false;
	}
	
	@Override
	public String getKeyword() {
		return TypeToken.PAWN.getKeyword();
	}			
}
