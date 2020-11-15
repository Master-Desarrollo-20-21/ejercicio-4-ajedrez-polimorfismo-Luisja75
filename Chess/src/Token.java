abstract class Token {

	protected Console console;
	protected Color color;			
	
	public Token(Color color) 
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
	
	public boolean isMovementAllow(Movement movement, boolean isEatPeace){
		if (this.isMovementAllow(movement.getDataMovement().getType(), isEatPeace) && 
			this.isDirectionAllow(movement.getDataMovement().getDirection()) && 
			this.isFreeWay(movement.getDataMovement().getFreeWay()) &&
			this.isDistanceAllow(movement.getDataMovement().getDistance())) {
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
	
	public abstract void setMovementDone();
	
	public abstract boolean isKing();
	
	public abstract void show();	
}

