abstract class Piece {

	protected Console console;
	protected Color color;
	protected String unicodePiece;

	protected void setUnicodePiece(String unicodePiece) {
		this.unicodePiece = unicodePiece;
	}
		
	public Piece(Color color) 
	{
		console = new Console();
		this.color = color;
	}
	
	public boolean isPlayer(Color color) {
		if (!hasPlayer()) {
			return false;
		}
				
		return this.color == color;
	}	

	public boolean hasPlayer() {
		return (color != null);
	}			
	
	public boolean isMovementAllow(DataMovement dataMovement){
		if (dataMovement.getType() == TypeMovement.UNKNOWN){
			console.out("El movimiento introducido es desconocido\n");
			return false;
		}
		
		if (this.isMovementAllow(dataMovement.getType(), dataMovement.isEatPeace()) && 
			this.isDirectionAllow(dataMovement.getDirection()) && 
			this.isFreeWay(dataMovement.isFreeWay()) &&
			this.isDistanceAllow(dataMovement.getDistance())) {
			return true;
		}
		else {
			console.out("El movimiento introducido no está permitido para la pieza que se quiere mover.");
			return false;
		}
	}
	
	protected abstract boolean isDirectionAllow(TypeDirection typeDirection);
	
	protected abstract boolean isDistanceAllow(int distance);

	protected abstract boolean isMovementAllow(TypeMovement typeMovement, boolean isEatPeace);

	protected abstract boolean isFreeWay(boolean freeWay);

	public String show() {
		return this.getSymbol();
	}		
	
	protected abstract String getSymbol();
	
	public abstract void setMovementDone();
	
	public abstract boolean isKing();
}

