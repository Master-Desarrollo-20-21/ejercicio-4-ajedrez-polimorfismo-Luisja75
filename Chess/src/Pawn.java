class Pawn extends Piece {

	public static final String UNICODE_PIECE_WHITE = "\u2659";
	public static final String UNICODE_PIECE_BLACK = "\u265F";
	private static final int LIMIT_NUMBER_VOX_MOVEMENT = 1;
	private static final int LIMIT_NUMBER_VOX_FIRST_MOVEMENT = 2;
	private boolean firstMovement;
	
	public Pawn(Color color)
	{
		super(color);
		firstMovement = true;		
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
	protected String getSymbol() {
		if (this.color == Color.WHITE) {
			return Pawn.UNICODE_PIECE_WHITE;
		} 
		else {
			return Pawn.UNICODE_PIECE_BLACK;
		}
	}
}
